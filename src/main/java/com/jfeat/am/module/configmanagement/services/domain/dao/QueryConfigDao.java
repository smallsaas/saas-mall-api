package com.jfeat.am.module.configmanagement.services.domain.dao;

import com.jfeat.am.module.configmanagement.services.domain.model.ConfigRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-13
 */
public interface QueryConfigDao extends BaseMapper<Config> {
    List<ConfigRecord> findConfigPage(Page<ConfigRecord> page, @Param("record") ConfigRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}