package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.order.services.gen.persistence.model.Order;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderService;
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
 *CRUDOrderService
 * @author Code Generator
 * @since 2019-07-31
 */

@Service
public class CRUDOrderServiceImpl  extends CRUDServiceOnlyImpl<Order> implements CRUDOrderService {





        @Resource
        protected OrderMapper orderMapper;

        @Override
        protected BaseMapper<Order> getMasterMapper() {
                return orderMapper;
        }







}


