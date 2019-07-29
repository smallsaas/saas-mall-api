package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductBrandRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductBrandService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductBrandService extends CRUDProductBrandService{
    List findProductBrandPage(Page<ProductBrandRecord> page, ProductBrandRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}