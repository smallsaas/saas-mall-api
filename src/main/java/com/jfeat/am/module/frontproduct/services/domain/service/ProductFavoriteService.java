package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductFavoriteRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductFavoriteService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductFavoriteService extends CRUDProductFavoriteService{
    List findProductFavoritePage(Page<ProductFavoriteRecord> page, ProductFavoriteRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}