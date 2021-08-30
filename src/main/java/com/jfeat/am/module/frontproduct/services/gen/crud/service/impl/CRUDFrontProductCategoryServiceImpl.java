package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFrontProductCategoryService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FrontProductCategoryMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDFrontProductCategoryService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDFrontProductCategoryServiceImpl extends CRUDServiceOnlyImpl<FrontProductCategory> implements CRUDFrontProductCategoryService {





        @Resource
        protected FrontProductCategoryMapper frontProductCategoryMapper;

        @Override
        protected BaseMapper<FrontProductCategory> getMasterMapper() {
                return frontProductCategoryMapper;
        }







}


