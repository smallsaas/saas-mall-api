package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFrontProductService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface FrontProductService extends CRUDFrontProductService {
    List findProductPage(Page<FrontProductRecord> page, FrontProductRecord record, String search,
                         String orderBy, Date startTime, Date endTime,Long supplierId,String supplierName);

    Long getTenantIdByOrgId(Long orgId);

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


    /**
     *
     * @param frontProductModelList
     * @return
     */
    Integer createProductHasChild(List<FrontProductModel> frontProductModelList);

    /**
     * 获取带子项产品
     * @param id
     * @return
     */
    FrontProductModel getProductHasChild(Long id);

    /**
     * 获取带子项的产品列表
     * @param page
     * @param record
     * @param search
     * @param orderBy
     * @param startTime
     * @param endTime
     * @param supplierId
     * @param supplierName
     * @return
     */
    List getProductPageHasChild(Page<FrontProductRecord> page, FrontProductRecord record, String search,
                         String orderBy, Date startTime, Date endTime,Long supplierId,String supplierName);

    /**
     * 更新带子项的产品
     * @param entity
     * @return
     */
    Integer updateProductHasChild(FrontProductModel entity);


    /**
     * 删除带子项的产品
     * @param id
     * @return
     */
    Integer deleteProductHasChild(Long id);
}