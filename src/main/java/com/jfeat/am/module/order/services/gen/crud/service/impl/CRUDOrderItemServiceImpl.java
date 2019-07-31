package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderItemMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderItemService;
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
 *CRUDOrderItemService
 * @author Code Generator
 * @since 2019-07-31
 */

@Service
public class CRUDOrderItemServiceImpl  extends CRUDServiceOnlyImpl<OrderItem> implements CRUDOrderItemService {





        @Resource
        protected OrderItemMapper orderItemMapper;

        @Override
        protected BaseMapper<OrderItem> getMasterMapper() {
                return orderItemMapper;
        }







}


