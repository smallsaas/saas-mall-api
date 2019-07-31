package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItemReward;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderItemRewardMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderItemRewardService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDOrderItemRewardService
 * @author Code Generator
 * @since 2019-07-31
 */

@Service
public class CRUDOrderItemRewardServiceImpl  extends CRUDServiceOnlyImpl<OrderItemReward> implements CRUDOrderItemRewardService {





        @Resource
        protected OrderItemRewardMapper orderItemRewardMapper;

        @Override
        protected BaseMapper<OrderItemReward> getMasterMapper() {
                return orderItemRewardMapper;
        }







}


