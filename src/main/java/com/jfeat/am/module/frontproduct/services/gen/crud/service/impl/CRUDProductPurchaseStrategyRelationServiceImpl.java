package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductPurchaseStrategyRelation;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.ProductPurchaseStrategyRelationMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductPurchaseStrategyRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDProductPurchaseStrategyRelationService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductPurchaseStrategyRelationServiceImpl  extends CRUDServiceOnlyImpl<ProductPurchaseStrategyRelation> implements CRUDProductPurchaseStrategyRelationService {





        @Resource
        protected ProductPurchaseStrategyRelationMapper productPurchaseStrategyRelationMapper;

        @Override
        protected BaseMapper<ProductPurchaseStrategyRelation> getMasterMapper() {
                return productPurchaseStrategyRelationMapper;
        }







}


