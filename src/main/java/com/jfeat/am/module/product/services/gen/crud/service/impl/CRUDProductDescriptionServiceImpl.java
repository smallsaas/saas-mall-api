package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductDescription;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductDescriptionMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductDescriptionService;
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
 *CRUDProductDescriptionService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductDescriptionServiceImpl  extends CRUDServiceOnlyImpl<ProductDescription> implements CRUDProductDescriptionService {





        @Resource
        protected ProductDescriptionMapper productDescriptionMapper;

        @Override
        protected BaseMapper<ProductDescription> getMasterMapper() {
                return productDescriptionMapper;
        }







}


