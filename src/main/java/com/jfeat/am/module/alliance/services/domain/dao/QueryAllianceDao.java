package com.jfeat.am.module.alliance.services.domain.dao;

import com.jfeat.am.module.alliance.services.domain.model.AllianceRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.alliance.services.gen.persistence.model.Alliance;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-10-12
 */
public interface QueryAllianceDao extends BaseMapper<Alliance> {
    List<AllianceRecord> findAlliancePage(Page<AllianceRecord> page, @Param("record") AllianceRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}