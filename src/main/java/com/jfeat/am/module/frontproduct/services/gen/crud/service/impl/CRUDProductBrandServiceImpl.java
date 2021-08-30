package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductBrand;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.ProductBrandMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDProductBrandService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductBrandServiceImpl  extends CRUDServiceOnlyImpl<ProductBrand> implements CRUDProductBrandService {





        @Resource
        protected ProductBrandMapper productBrandMapper;

        @Override
        protected BaseMapper<ProductBrand> getMasterMapper() {
                return productBrandMapper;
        }







}


