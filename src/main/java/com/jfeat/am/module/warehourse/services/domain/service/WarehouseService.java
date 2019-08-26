package com.jfeat.am.module.warehourse.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.warehourse.services.domain.model.WarehouseRecord;
import com.jfeat.am.module.warehourse.services.gen.crud.service.CRUDWarehouseService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface WarehouseService extends CRUDWarehouseService{
    List findWarehousePage(Page<WarehouseRecord> page, WarehouseRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}