package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductSettlementProportionRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductSettlementProportionService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductSettlementProportionService extends CRUDProductSettlementProportionService{
    List findProductSettlementProportionPage(Page<ProductSettlementProportionRecord> page, ProductSettlementProportionRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}