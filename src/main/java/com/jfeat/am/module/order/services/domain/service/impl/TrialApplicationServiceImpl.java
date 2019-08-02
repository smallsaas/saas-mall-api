package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryTrialApplicationDao;
import com.jfeat.am.module.order.services.domain.model.TrialApplicationRecord;
import com.jfeat.am.module.order.services.domain.service.TrialApplicationService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDTrialApplicationServiceImpl;
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
@Service("trialApplicationService")
public class TrialApplicationServiceImpl extends CRUDTrialApplicationServiceImpl implements TrialApplicationService {
    @Resource
    QueryTrialApplicationDao queryTrialApplicationDao;

    @Override
    public List findTrialApplicationPage(Page<TrialApplicationRecord> page, TrialApplicationRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryTrialApplicationDao.findTrialApplicationPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
