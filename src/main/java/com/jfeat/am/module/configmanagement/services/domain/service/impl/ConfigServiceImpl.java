package com.jfeat.am.module.configmanagement.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.configmanagement.services.domain.dao.QueryConfigDao;
import com.jfeat.am.module.configmanagement.services.domain.model.ConfigRecord;
import com.jfeat.am.module.configmanagement.services.domain.service.ConfigService;
import com.jfeat.am.module.configmanagement.services.gen.crud.service.impl.CRUDConfigOverModelServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
}
