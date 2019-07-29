package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.Product;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductService;
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
 *CRUDProductService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductServiceImpl  extends CRUDServiceOnlyImpl<Product> implements CRUDProductService {





        @Resource
        protected ProductMapper productMapper;

        @Override
        protected BaseMapper<Product> getMasterMapper() {
                return productMapper;
        }







}


