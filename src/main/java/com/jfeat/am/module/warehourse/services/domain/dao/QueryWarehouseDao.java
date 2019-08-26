package com.jfeat.am.module.warehourse.services.domain.dao;

import com.jfeat.am.module.warehourse.services.domain.model.WarehouseRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.warehourse.services.gen.persistence.model.Warehouse;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-08
 */
public interface QueryWarehouseDao extends BaseMapper<Warehouse> {
    List<WarehouseRecord> findWarehousePage(Page<WarehouseRecord> page, @Param("record") WarehouseRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}