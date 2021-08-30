package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderCustomerServiceItem;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderCustomerServiceItemMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderCustomerServiceItemService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDOrderCustomerServiceItemService
 * @author Code Generator
 * @since 2019-07-31
 */

@Service
public class CRUDOrderCustomerServiceItemServiceImpl  extends CRUDServiceOnlyImpl<OrderCustomerServiceItem> implements CRUDOrderCustomerServiceItemService {





        @Resource
        protected OrderCustomerServiceItemMapper orderCustomerServiceItemMapper;

        @Override
        protected BaseMapper<OrderCustomerServiceItem> getMasterMapper() {
                return orderCustomerServiceItemMapper;
        }







}


