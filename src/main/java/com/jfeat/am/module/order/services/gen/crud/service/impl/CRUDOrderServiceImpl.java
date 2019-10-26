package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.order.services.gen.persistence.model.TOrder;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDOrderService
 * @author Code Generator
 * @since 2019-07-31
 */

@Service
public class CRUDOrderServiceImpl  extends CRUDServiceOnlyImpl<TOrder> implements CRUDOrderService {





        @Resource
        protected OrderMapper orderMapper;

        @Override
        protected BaseMapper<TOrder> getMasterMapper() {
                return orderMapper;
        }







}


