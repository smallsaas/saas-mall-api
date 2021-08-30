package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryTrialImageDao;
import com.jfeat.am.module.frontproduct.services.domain.model.TrialImageRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.TrialImageService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDTrialImageServiceImpl;
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
@Service("trialImageService")
public class TrialImageServiceImpl extends CRUDTrialImageServiceImpl implements TrialImageService {
    @Resource
    QueryTrialImageDao queryTrialImageDao;

    @Override
    public List findTrialImagePage(Page<TrialImageRecord> page, TrialImageRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryTrialImageDao.findTrialImagePage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
