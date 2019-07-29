package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductImageRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductImageService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductImageService extends CRUDProductImageService{
    List findProductImagePage(Page<ProductImageRecord> page, ProductImageRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}