package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.dao.QueryTrialDao;
import com.jfeat.am.module.product.services.domain.model.TrialRecord;
import com.jfeat.am.module.product.services.domain.service.TrialOverModelService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDTrialOverModelServiceImpl;
import com.jfeat.am.module.product.services.gen.persistence.model.Trial;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("trialService")
public class TrialOverModelServiceImpl extends CRUDTrialOverModelServiceImpl implements TrialOverModelService {
    @Resource
    QueryTrialDao queryTrialDao;

    @Override
    public List findTrialPage(Page<TrialRecord> page, TrialRecord record,
                              String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryTrialDao.findTrialPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    public Integer updateTrialStatus(Integer id, Integer status) {
        return trialMapper.updateById(new Trial().setId(id).setEnabled(status));
    }
}
