package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductCategory;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductCategoryMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductCategoryService;
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
 *CRUDProductCategoryService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductCategoryServiceImpl  extends CRUDServiceOnlyImpl<ProductCategory> implements CRUDProductCategoryService {





        @Resource
        protected ProductCategoryMapper productCategoryMapper;

        @Override
        protected BaseMapper<ProductCategory> getMasterMapper() {
                return productCategoryMapper;
        }







}


