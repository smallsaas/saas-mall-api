package com.jfeat.am.module.configmanagement.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.configmanagement.services.domain.dao.QueryConfigDao;
import com.jfeat.am.module.configmanagement.services.domain.model.ConfigRecord;
import com.jfeat.am.module.configmanagement.services.domain.service.ConfigService;
import com.jfeat.am.module.configmanagement.services.gen.crud.service.impl.CRUDConfigOverModelServiceImpl;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("configService")
public class ConfigServiceImpl extends CRUDConfigOverModelServiceImpl implements ConfigService {
    @Resource
    QueryConfigDao queryConfigDao;

    @Override
    public List findConfigPage(Page<ConfigRecord> page, ConfigRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryConfigDao.findConfigPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    public Properties getConfig(String type) {
        List<Config> configList = configMapper.selectList(new EntityWrapper<Config>().eq("type", type).eq("visible",1));
        Properties properties = new Properties(configList.size());
        configList.forEach(item -> {
            properties.setProperty(item.getKeyName(),item.getValue());
        });

        return properties;
    }

    @Override
    public Integer updateConfig(String type, Properties entity) {
        int affected = 0;
        Enumeration<?> enumeration = entity.propertyNames();
        while (enumeration.hasMoreElements()){
            String key = (String)enumeration.nextElement();
            affected += configMapper.update(new Config().setValue(entity.getProperty(key)),new EntityWrapper<Config>().eq("type",type).eq("key_name",key));
        }
        return affected;
    }
}