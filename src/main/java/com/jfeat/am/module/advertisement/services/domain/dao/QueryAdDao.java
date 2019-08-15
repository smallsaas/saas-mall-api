package com.jfeat.am.module.advertisement.services.domain.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.advertisement.services.domain.model.record.AdRecord;
import com.jfeat.am.module.advertisement.services.persistence.model.Ad;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-15
 */
public interface QueryAdDao extends BaseMapper<Ad> {
    List<AdRecord> findAdPage(Page<AdRecord> page, @Param("record") AdRecord record,
                              @Param("search") String search, @Param("orderBy") String orderBy,
                              @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}