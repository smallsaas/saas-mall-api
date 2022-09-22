package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.ProductItemRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductItem;
import com.jfeat.am.module.frontproduct.services.gen.crud.model.ProductItemModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-09-20
 */
public interface QueryProductItemDao extends QueryMasterDao<ProductItem> {
   /*
    * Query entity list by page
    */
    List<ProductItemRecord> findProductItemPage(Page<ProductItemRecord> page, @Param("record") ProductItemRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    ProductItemModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<ProductItemModel> queryMasterModelList(@Param("masterId") Object masterId);

    Integer batchAddProductItem(@Param("productItemList") List<ProductItem> productItemList);
}