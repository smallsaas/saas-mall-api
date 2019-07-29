package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductTagRelation;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductTagRelationMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductTagRelationService;
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
 *CRUDProductTagRelationService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductTagRelationServiceImpl  extends CRUDServiceOnlyImpl<ProductTagRelation> implements CRUDProductTagRelationService {





        @Resource
        protected ProductTagRelationMapper productTagRelationMapper;

        @Override
        protected BaseMapper<ProductTagRelation> getMasterMapper() {
                return productTagRelationMapper;
        }







}


