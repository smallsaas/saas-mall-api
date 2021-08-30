package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductTagRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductTag;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public interface QueryFrontProductTagDao extends BaseMapper<FrontProductTag> {
    List<FrontProductTagRecord> findProductTagPage(Page<FrontProductTagRecord> page, @Param("record") FrontProductTagRecord record,
                                                   @Param("search") String search, @Param("orderBy") String orderBy,
                                                   @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}