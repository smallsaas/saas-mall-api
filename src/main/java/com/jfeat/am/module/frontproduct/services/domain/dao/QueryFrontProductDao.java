package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public interface QueryFrontProductDao extends BaseMapper<FrontProduct> {
    List<FrontProductRecord> findProductPage(Page<FrontProductRecord> page, @Param("record") FrontProductRecord record,
                                             @Param("search") String search, @Param("orderBy") String orderBy,
                                             @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 根据id获取ProductModel
     * @param id
     * @return
     */
    FrontProductModel findProductModelById(@Param("id") Long id);
}