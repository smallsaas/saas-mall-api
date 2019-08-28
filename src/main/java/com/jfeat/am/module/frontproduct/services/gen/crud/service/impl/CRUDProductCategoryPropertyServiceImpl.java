package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductCategoryProperty;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.ProductCategoryPropertyMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductCategoryPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDProductCategoryPropertyService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductCategoryPropertyServiceImpl  extends CRUDServiceOnlyImpl<ProductCategoryProperty> implements CRUDProductCategoryPropertyService {





        @Resource
        protected ProductCategoryPropertyMapper productCategoryPropertyMapper;

        @Override
        protected BaseMapper<ProductCategoryProperty> getMasterMapper() {
                return productCategoryPropertyMapper;
        }







}


