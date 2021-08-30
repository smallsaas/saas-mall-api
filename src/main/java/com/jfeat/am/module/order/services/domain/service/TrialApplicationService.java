package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.model.TrialApplicationRecord;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDTrialApplicationService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface TrialApplicationService extends CRUDTrialApplicationService{
    List findTrialApplicationPage(Page<TrialApplicationRecord> page, TrialApplicationRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}