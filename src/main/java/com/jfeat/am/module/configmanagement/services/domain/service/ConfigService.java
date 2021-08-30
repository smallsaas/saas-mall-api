package com.jfeat.am.module.configmanagement.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.configmanagement.services.domain.model.ConfigRecord;
import com.jfeat.am.module.configmanagement.services.gen.crud.service.CRUDConfigOverModelService;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ConfigService extends CRUDConfigOverModelService {
    List findConfigPage(Page<ConfigRecord> page, ConfigRecord record, String search,
                           String orderBy, Date startTime, Date endTime);

    /**
     * 获取指定类型配置
     * @param type
     * @return
     */
    Map<String,String> getConfig(String type);

    /**
     * 更新指定类型配置
     * @param type
     * @param entity
     * @return
     */
    Integer updateConfig(String type, Properties entity);


    //更新所有配置
    public Integer updateAllConfig(Properties entity);
    //获取所有配置
    public Map<String, String> getAllConfig() ;

    //根据组id查找Config
    List<Config> selectConfigByGroupId(Integer groupId);
}