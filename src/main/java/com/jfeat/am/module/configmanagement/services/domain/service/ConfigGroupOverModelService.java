package com.jfeat.am.module.configmanagement.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.configmanagement.services.domain.model.ConfigGroupRecord;
import com.jfeat.am.module.configmanagement.services.gen.crud.model.ConfigGroupModel;
import com.jfeat.am.module.configmanagement.services.gen.crud.service.CRUDConfigGroupOverModelService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ConfigGroupOverModelService extends CRUDConfigGroupOverModelService{
    List findConfigGroupPage(Page<ConfigGroupRecord> page, ConfigGroupRecord record, String search,
                           String orderBy, Date startTime, Date endTime);

    /**
     * 获取所有配置管理项及其子类别
     * @return
     */
    List<ConfigGroupModel> getAllConfigGroup();
}