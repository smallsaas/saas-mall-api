package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public interface QueryFrontProductCategoryDao extends BaseMapper<FrontProductCategory> {
    List<FrontProductCategoryRecord> findProductCategoryPage(Page<FrontProductCategoryRecord> page, @Param("record") FrontProductCategoryRecord record,
                                                             @Param("search") String search, @Param("orderBy") String orderBy,
                                                             @Param("startTime") Date startTime, @Param("endTime") Date endTime);


    List<FrontProductCategoryRecord> nextNoteTree(@Param("parentId") Long parentId);

    FrontProductCategoryRecord noteTree(@Param("id")Long id);
}