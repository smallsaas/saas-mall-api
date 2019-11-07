package com.jfeat.am.module.configmanagement.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.configmanagement.services.domain.dao.QueryConfigGroupDao;
import com.jfeat.am.module.configmanagement.services.domain.model.MallConfigGroupRecord;
import com.jfeat.am.module.configmanagement.services.domain.service.ConfigGroupOverModelService;
import com.jfeat.am.module.configmanagement.services.gen.crud.model.MallConfigGroupModel;
import com.jfeat.am.module.configmanagement.services.gen.crud.service.impl.CRUDConfigGroupOverModelServiceImpl;
import com.jfeat.am.module.configmanagement.services.gen.persistence.dao.ConfigMapper;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.MallConfigGroup;
import com.jfeat.crud.plus.CRUD;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
@Service("configGroupService")
public class ConfigGroupOverModelServiceImpl extends CRUDConfigGroupOverModelServiceImpl implements ConfigGroupOverModelService {
    @Resource
    QueryConfigGroupDao queryConfigGroupDao;
    @Resource
    ConfigMapper configMapper;

    @Override
    public List findConfigGroupPage(Page<MallConfigGroupRecord> page, MallConfigGroupRecord record,
                                    String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryConfigGroupDao.findConfigGroupPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    public List<MallConfigGroupModel> getAllConfigGroup() {
        List<MallConfigGroupModel> configGroupModelList = new ArrayList<>();
        List<MallConfigGroup> mallConfigGroupList = mallConfigGroupMapper.selectList(null);
        mallConfigGroupList.forEach(item -> {
            List<Config> configList = configMapper.selectList(new EntityWrapper<Config>().eq("group_id", item.getId()));
            MallConfigGroupModel configGroupModel = CRUD.castObject(item, MallConfigGroupModel.class);
            configGroupModel.setItems(configList);
            configGroupModelList.add(configGroupModel);
        });
        return configGroupModelList;
    }
}
