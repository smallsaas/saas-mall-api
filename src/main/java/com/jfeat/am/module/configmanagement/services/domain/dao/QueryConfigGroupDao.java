package com.jfeat.am.module.configmanagement.services.domain.dao;

import com.jfeat.am.module.configmanagement.services.domain.model.ConfigGroupRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.ConfigGroup;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-13
 */
public interface QueryConfigGroupDao extends BaseMapper<ConfigGroup> {
    List<ConfigGroupRecord> findConfigGroupPage(Page<ConfigGroupRecord> page, @Param("record") ConfigGroupRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}