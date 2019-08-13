package com.jfeat.am.module.configmanagement.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.configmanagement.services.domain.model.ConfigRecord;
import com.jfeat.am.module.configmanagement.services.gen.crud.service.CRUDConfigOverModelService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ConfigService extends CRUDConfigOverModelService {
    List findConfigPage(Page<ConfigRecord> page, ConfigRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}