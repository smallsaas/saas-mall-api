package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductCategoryModel;
import com.jfeat.am.module.product.services.domain.model.ProductCategoryRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductCategoryService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductCategoryService extends CRUDProductCategoryService{
    List findProductCategoryPage(Page<ProductCategoryRecord> page, ProductCategoryRecord record, String search,
                           String orderBy, Date startTime, Date endTime);

    /**
     * 创建新的产品类别
     * @param entity
     * @return
     */
    Integer createProductCategory(ProductCategoryModel entity);

    /**
     * 根据id获取产品类型
     * @param id
     * @return
     */
    ProductCategoryModel getProductCategoryById(Long id);

    /**
     * 根据id修改产品类型
     * @param entity
     * @return
     */
    Integer updateProductCategoryById(ProductCategoryModel entity);
}