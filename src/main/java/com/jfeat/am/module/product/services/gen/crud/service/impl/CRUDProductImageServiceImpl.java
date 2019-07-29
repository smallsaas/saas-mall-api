package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductImage;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductImageMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductImageService;
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


