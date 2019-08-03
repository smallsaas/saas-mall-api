package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductModel;
import com.jfeat.am.module.product.services.domain.model.ProductRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ProductService extends CRUDProductService{
    List findProductPage(Page<ProductRecord> page, ProductRecord record, String search,
                           String orderBy, Date startTime, Date endTime);

    /**
     * 创建新的产品
     * @param entity
     * @return 数据库受影响的行数
     */
    Integer createProduct(ProductModel entity);

    /**
     * 根据id获取产品
     * @param id
     * @return
     */
    ProductModel getProduct(Long id);

    /**
     * 更新产品
     * @param entity
     * @return 数据库受影响的行数
     */
    Integer updateProduct(ProductModel entity);

    /**
     *
     * @param id
     * @param status
     * @return 数据库受影响的行数
     */
    Integer updateProductStatus(Long id, String status);
}