package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.ProductBrandRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductBrand;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public interface QueryProductBrandDao extends BaseMapper<ProductBrand> {
    List<ProductBrandRecord> findProductBrandPage(Page<ProductBrandRecord> page, @Param("record") ProductBrandRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    ProductBrand queryProductBrandById(@Param("id")Long id);
}