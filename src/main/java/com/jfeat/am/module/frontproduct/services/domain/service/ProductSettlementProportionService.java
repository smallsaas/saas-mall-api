package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    public List<ProductSettlementProportionRecord> getProductSettlementProportionSettingGroup();
    public List<ProductSettlementProportionRecord> setProductSettlementProportionSettingGroup
            (List<ProductSettlementProportionRecord> settingGroup,Integer productId);
    public List<ProductSettlementProportionRecord> reSetProductSettlementProportionSettingGroup
            (List<ProductSettlementProportionRecord> settingGroup);

}