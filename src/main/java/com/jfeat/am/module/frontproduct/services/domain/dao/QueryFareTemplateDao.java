package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.FareTemplateRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FareTemplate;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-31
 */
public interface QueryFareTemplateDao extends BaseMapper<FareTemplate> {
    List<FareTemplateRecord> findFareTemplatePage(Page<FareTemplateRecord> page, @Param("record") FareTemplateRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    Long selectPcdIdByName(@Param("name")String name);
}