package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderProcessLog;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderProcessLogMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderProcessLogService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDOrderProcessLogService
 * @author Code Generator
 * @since 2019-07-31
 */

@Service
public class CRUDOrderProcessLogServiceImpl  extends CRUDServiceOnlyImpl<OrderProcessLog> implements CRUDOrderProcessLogService {





        @Resource
        protected OrderProcessLogMapper orderProcessLogMapper;

        @Override
        protected BaseMapper<OrderProcessLog> getMasterMapper() {
                return orderProcessLogMapper;
        }







}


