package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFrontProductService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface FrontProductService extends CRUDFrontProductService {
    List findProductPage(Page<FrontProductRecord> page, FrontProductRecord record, String search,
                         String orderBy, Date startTime, Date endTime);

    /**
     * 创建新的产品
     * @param entity
     * @return 数据库受影响的行数
     */
    Integer createProduct(FrontProductModel entity);

    /**
     * 根据id获取产品
     * @param id
     * @return
     */
    FrontProductModel getProduct(Long id);

    /**
     * 更新产品
     * @param entity
     * @return 数据库受影响的行数
     */
    Integer updateProduct(FrontProductModel entity);

    /**
     *
     * @param id
     * @param status
     * @return 数据库受影响的行数
     */
    Integer updateProductStatus(Long id, String status);
}