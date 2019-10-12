package com.jfeat.am.module.alliance.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.alliance.services.domain.model.AllianceRecord;
import com.jfeat.am.module.alliance.services.gen.crud.service.CRUDAllianceService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface AllianceService extends CRUDAllianceService{
    List findAlliancePage(Page<AllianceRecord> page, AllianceRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
    Integer changeStatus(Long id);
}