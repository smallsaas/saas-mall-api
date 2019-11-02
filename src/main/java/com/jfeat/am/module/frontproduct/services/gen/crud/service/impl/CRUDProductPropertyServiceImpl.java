package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductProperty;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.ProductPropertyMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDProductPropertyService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductPropertyServiceImpl  extends CRUDServiceOnlyImpl<ProductProperty> implements CRUDProductPropertyService {





        @Resource
        protected ProductPropertyMapper productPropertyMapper;

        @Override
        protected BaseMapper<ProductProperty> getMasterMapper() {
                return productPropertyMapper;
        }







}

