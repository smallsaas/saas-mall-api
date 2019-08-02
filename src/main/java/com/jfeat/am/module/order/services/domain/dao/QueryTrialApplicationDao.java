package com.jfeat.am.module.order.services.domain.dao;

import com.jfeat.am.module.order.services.domain.model.TrialApplicationRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.order.services.gen.persistence.model.TrialApplication;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-02
 */
public interface QueryTrialApplicationDao extends BaseMapper<TrialApplication> {
    List<TrialApplicationRecord> findTrialApplicationPage(Page<TrialApplicationRecord> page, @Param("record") TrialApplicationRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}