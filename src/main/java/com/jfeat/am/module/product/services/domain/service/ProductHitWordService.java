package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductHitWordRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductHitWordService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductHitWordService extends CRUDProductHitWordService{
    List findProductHitWordPage(Page<ProductHitWordRecord> page, ProductHitWordRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}