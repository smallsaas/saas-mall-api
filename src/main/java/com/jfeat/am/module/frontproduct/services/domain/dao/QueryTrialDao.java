package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.TrialRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.Trial;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-02
 */
public interface QueryTrialDao extends BaseMapper<Trial> {
    List<TrialRecord> findTrialPage(Page<TrialRecord> page, @Param("record") TrialRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}