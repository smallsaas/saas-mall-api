package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductPropertyRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductPropertyService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductPropertyService extends CRUDProductPropertyService{
    List findProductPropertyPage(Page<ProductPropertyRecord> page, ProductPropertyRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}