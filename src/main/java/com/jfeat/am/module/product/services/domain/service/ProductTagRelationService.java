package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductTagRelationRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductTagRelationService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductTagRelationService extends CRUDProductTagRelationService{
    List findProductTagRelationPage(Page<ProductTagRelationRecord> page, ProductTagRelationRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}