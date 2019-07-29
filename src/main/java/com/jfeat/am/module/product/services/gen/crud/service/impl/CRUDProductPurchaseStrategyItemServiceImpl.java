package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductPurchaseStrategyItem;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductPurchaseStrategyItemMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductPurchaseStrategyItemService;
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
 *CRUDProductPurchaseStrategyItemService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductPurchaseStrategyItemServiceImpl  extends CRUDServiceOnlyImpl<ProductPurchaseStrategyItem> implements CRUDProductPurchaseStrategyItemService {





        @Resource
        protected ProductPurchaseStrategyItemMapper productPurchaseStrategyItemMapper;

        @Override
        protected BaseMapper<ProductPurchaseStrategyItem> getMasterMapper() {
                return productPurchaseStrategyItemMapper;
        }







}


