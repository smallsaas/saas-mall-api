package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.order.services.gen.persistence.model.Express;
import com.jfeat.am.module.order.services.gen.persistence.dao.ExpressMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDExpressService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDExpressService
 * @author Code Generator
 * @since 2019-08-01
 */

@Service
public class CRUDExpressServiceImpl  extends CRUDServiceOnlyImpl<Express> implements CRUDExpressService {





        @Resource
        protected ExpressMapper expressMapper;

        @Override
        protected BaseMapper<Express> getMasterMapper() {
                return expressMapper;
        }







}


