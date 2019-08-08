package com.jfeat.am.module.store.services.domain.service.impl;

import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.store.api.IdRequest;
import com.jfeat.am.module.store.services.constants.ShiftingStatus;
import com.jfeat.am.module.store.services.crud.service.impl.CRUDStoreShiftingServiceImpl;
import com.jfeat.am.module.store.services.domain.dao.QueryCashierClientDao;
import com.jfeat.am.module.store.services.domain.dao.QueryStoreAssistantDao;
import com.jfeat.am.module.store.services.domain.service.StoreShiftingService;
import com.jfeat.am.module.store.services.exception.ExceptionEnum;
import com.jfeat.am.module.store.services.persistence.dao.StoreShiftingMapper;
import com.jfeat.am.module.store.services.persistence.model.StoreShifting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("StoreShiftingService")
public class StoreShiftingServiceImpl extends CRUDStoreShiftingServiceImpl implements StoreShiftingService {


    @Resource
    StoreShiftingMapper shiftingMapper;
    @Resource
    QueryStoreAssistantDao  queryStoreAssistantDao;
    @Resource
    QueryCashierClientDao queryCashierClientDao;


    /**
     * 新建 交班 表， 传递  店铺 id 以及 下一位 员工的 id
     * */
    public Integer createShifting(Long userId,IdRequest entity){

        Long nowAssistantId = queryStoreAssistantDao.userId(userId);
        if (entity.getNextAssistantId().compareTo(nowAssistantId)==0){
            throw new BusinessException(ExceptionEnum.CAN_NOT_SHIFT_TO_SELF.getFriendlyCode(),ExceptionEnum.CAN_NOT_SHIFT_TO_SELF.getFriendlyMsg());
        }
        String userName = queryStoreAssistantDao.userName(userId);
        String nextUserName = queryStoreAssistantDao.nextUserName(entity.getNextAssistantId());
        Long storeId = entity.getStoreId();
        //       Long cashierClientId = queryCashierClientDao.cashierClientId(storeId);


        StoreShifting shifting = new StoreShifting();

        shifting.setStatus(ShiftingStatus.APPLYING);
        shifting.setStoreId(storeId);
        shifting.setAssistantId(nowAssistantId);
        shifting.setCashier(userName);

        shifting.setNextAssistantId(entity.getNextAssistantId());
        shifting.setNextCashier(nextUserName);

             shifting.setCashierClientId(entity.getCashierClientId());
        //shifting.setOrgId(JWTKit.getOrgId);
        return shiftingMapper.insert(shifting);
    }
                            
}
