package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFrontProductCategoryService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface FrontProductCategoryService extends CRUDFrontProductCategoryService {
    List findProductCategoryPage(Page<FrontProductCategoryRecord> page, FrontProductCategoryRecord record, String search,
                                 String orderBy, Date startTime, Date endTime);

    /**
     * 创建新的产品类别
     * @param entity
     * @return
     */
    Integer createProductCategory(FrontProductCategoryModel entity);

    /**
     * 根据id获取产品类型
     * @param id
     * @return
     */
    FrontProductCategoryModel getProductCategoryById(Long id);

    /**
     * 根据id修改产品类型
     * @param entity
     * @return
     */
    Integer updateProductCategoryById(FrontProductCategoryModel entity);

    /**
     * 返回所欲产品类型
     * @return
     */
    List<FrontProductCategoryRecord> queryProductCategoryies();
}