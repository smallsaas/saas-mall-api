package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductSpecificationRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductSpecificationService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductSpecificationService extends CRUDProductSpecificationService{
    List findProductSpecificationPage(Page<ProductSpecificationRecord> page, ProductSpecificationRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}