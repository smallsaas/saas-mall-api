package com.jfeat.am.module.product.services.domain.dao;

import com.jfeat.am.module.product.services.domain.model.CarryModeRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.product.services.gen.persistence.model.CarryMode;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-01
 */
public interface QueryCarryModeDao extends BaseMapper<CarryMode> {
    List<CarryModeRecord> findCarryModePage(Page<CarryModeRecord> page, @Param("record") CarryModeRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}