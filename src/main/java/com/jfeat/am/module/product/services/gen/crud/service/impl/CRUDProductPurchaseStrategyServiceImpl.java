package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductPurchaseStrategy;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductPurchaseStrategyMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductPurchaseStrategyService;
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
 *CRUDProductPurchaseStrategyService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductPurchaseStrategyServiceImpl  extends CRUDServiceOnlyImpl<ProductPurchaseStrategy> implements CRUDProductPurchaseStrategyService {





        @Resource
        protected ProductPurchaseStrategyMapper productPurchaseStrategyMapper;

        @Override
        protected BaseMapper<ProductPurchaseStrategy> getMasterMapper() {
                return productPurchaseStrategyMapper;
        }







}


