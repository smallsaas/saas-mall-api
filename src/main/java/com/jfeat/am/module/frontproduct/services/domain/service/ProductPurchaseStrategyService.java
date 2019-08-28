package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductPurchaseStrategyRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductPurchaseStrategyService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductPurchaseStrategyService extends CRUDProductPurchaseStrategyService{
    List findProductPurchaseStrategyPage(Page<ProductPurchaseStrategyRecord> page, ProductPurchaseStrategyRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}