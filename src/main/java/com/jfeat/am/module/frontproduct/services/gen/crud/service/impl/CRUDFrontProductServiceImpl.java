package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFrontProductService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FrontProductMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDFrontProductService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDFrontProductServiceImpl extends CRUDServiceOnlyImpl<FrontProduct> implements CRUDFrontProductService {


        private static final  String EAV_ENTITY_NAME = "product";


        @Resource
        protected FrontProductMapper frontProductMapper;

        @Override
        protected BaseMapper<FrontProduct> getMasterMapper() {
                return frontProductMapper;
        }


        @Override
        protected String entityName() {
                return EAV_ENTITY_NAME;
        }




}


