package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderCustomerService;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderCustomerServiceMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderCustomerServiceService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDOrderCustomerServiceService
 * @author Code Generator
 * @since 2019-07-31
 */

@Service
public class CRUDOrderCustomerServiceServiceImpl  extends CRUDServiceOnlyImpl<OrderCustomerService> implements CRUDOrderCustomerServiceService {





        @Resource
        protected OrderCustomerServiceMapper orderCustomerServiceMapper;

        @Override
        protected BaseMapper<OrderCustomerService> getMasterMapper() {
                return orderCustomerServiceMapper;
        }







}


