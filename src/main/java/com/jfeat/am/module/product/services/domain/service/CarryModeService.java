package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.CarryModeRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDCarryModeService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface CarryModeService extends CRUDCarryModeService{
    List findCarryModePage(Page<CarryModeRecord> page, CarryModeRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}