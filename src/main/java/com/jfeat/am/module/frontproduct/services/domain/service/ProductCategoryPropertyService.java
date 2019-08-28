package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductCategoryPropertyRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductCategoryPropertyService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductCategoryPropertyService extends CRUDProductCategoryPropertyService{
    List findProductCategoryPropertyPage(Page<ProductCategoryPropertyRecord> page, ProductCategoryPropertyRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}