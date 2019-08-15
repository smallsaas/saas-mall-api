package com.jfeat.am.module.advertisement.services.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.advertisement.services.domain.dao.QueryAdDao;
import com.jfeat.am.module.advertisement.services.domain.model.record.AdRecord;
import com.jfeat.am.module.advertisement.services.persistence.dao.AdMapper;
import com.jfeat.am.module.advertisement.services.persistence.model.Ad;
import com.jfeat.am.module.advertisement.services.service.AdService;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
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
 * @since 2017-09-20
 */
@Service
public class AdServiceImpl extends CRUDServiceOnlyImpl<Ad> implements AdService {
    @Resource
    private AdMapper adMapper;
    @Resource
    QueryAdDao queryAdDao;

    @Override
    protected BaseMapper<Ad> getMasterMapper() {
        return adMapper;
    }

    @Override
    public List findAdPage(Page<AdRecord> page, AdRecord record,
                           String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryAdDao.findAdPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
