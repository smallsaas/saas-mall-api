package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItemReward;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderItemRewardMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderItemRewardService;
import org.springframework.stereotype.Service;
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


