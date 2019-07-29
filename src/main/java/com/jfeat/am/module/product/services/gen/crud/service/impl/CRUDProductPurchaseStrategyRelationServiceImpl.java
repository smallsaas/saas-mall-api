package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductPurchaseStrategyRelation;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductPurchaseStrategyRelationMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductPurchaseStrategyRelationService;
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


