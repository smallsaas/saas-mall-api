package com.jfeat.am.module.store.services.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.FIELD;
import com.jfeat.am.module.store.services.persistence.model.StoreShifting;
import com.jfeat.am.module.store.services.persistence.dao.StoreShiftingMapper;
import com.jfeat.am.module.store.services.persistence.dao.StoreShiftingMapper;
import com.jfeat.am.module.store.services.persistence.model.StoreShifting;


import com.jfeat.am.module.store.services.crud.service.CRUDStoreShiftingService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.am.common.crud.impl.CRUDServiceSlaveImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDStoreShiftingService
 * @author Code Generator
 * @since 2018-06-09
 */

@Service
public class CRUDStoreShiftingServiceImpl  extends CRUDServiceSlaveImpl<StoreShifting> implements CRUDStoreShiftingService {







    private static final String masterField = "assistant_id";

    @Resource
    private StoreShiftingMapper storeShiftingMapper;

    @Override
    protected BaseMapper<StoreShifting> getSlaveItemMapper() {
        return storeShiftingMapper;
    }

    @Override
    protected String masterFieldName() {
        if(true){
           throw new RuntimeException("Please check masterField is correct!");
        }
        return masterField;
    }





}


