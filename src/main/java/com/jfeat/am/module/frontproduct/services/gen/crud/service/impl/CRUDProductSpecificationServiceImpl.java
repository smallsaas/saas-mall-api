package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductSpecification;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.ProductSpecificationMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductSpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDProductSpecificationService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductSpecificationServiceImpl  extends CRUDServiceOnlyImpl<ProductSpecification> implements CRUDProductSpecificationService {





        @Resource
        protected ProductSpecificationMapper productSpecificationMapper;

        @Override
        protected BaseMapper<ProductSpecification> getMasterMapper() {
                return productSpecificationMapper;
        }







}


