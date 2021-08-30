package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductPurchaseStrategyItemRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductPurchaseStrategyItemService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductPurchaseStrategyItemService extends CRUDProductPurchaseStrategyItemService{
    List findProductPurchaseStrategyItemPage(Page<ProductPurchaseStrategyItemRecord> page, ProductPurchaseStrategyItemRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}