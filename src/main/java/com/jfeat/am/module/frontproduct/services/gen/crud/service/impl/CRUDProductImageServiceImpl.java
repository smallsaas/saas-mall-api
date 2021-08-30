package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductImage;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.ProductImageMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDProductImageService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductImageServiceImpl  extends CRUDServiceOnlyImpl<ProductImage> implements CRUDProductImageService {





        @Resource
        protected ProductImageMapper productImageMapper;

        @Override
        protected BaseMapper<ProductImage> getMasterMapper() {
                return productImageMapper;
        }







}


