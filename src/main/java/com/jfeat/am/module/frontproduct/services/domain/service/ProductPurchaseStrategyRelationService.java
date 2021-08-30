package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductPurchaseStrategyRelationRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductPurchaseStrategyRelationService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductPurchaseStrategyRelationService extends CRUDProductPurchaseStrategyRelationService{
    List findProductPurchaseStrategyRelationPage(Page<ProductPurchaseStrategyRelationRecord> page, ProductPurchaseStrategyRelationRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}