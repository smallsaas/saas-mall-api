package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductDescriptionRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductDescriptionService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductDescriptionService extends CRUDProductDescriptionService{
    List findProductDescriptionPage(Page<ProductDescriptionRecord> page, ProductDescriptionRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}