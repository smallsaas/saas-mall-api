package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductBrand;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductBrandMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductBrandService;
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


