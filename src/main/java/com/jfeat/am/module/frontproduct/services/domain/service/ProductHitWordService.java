package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductHitWordRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductHitWordService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductHitWordService extends CRUDProductHitWordService{
    List findProductHitWordPage(Page<ProductHitWordRecord> page, ProductHitWordRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}