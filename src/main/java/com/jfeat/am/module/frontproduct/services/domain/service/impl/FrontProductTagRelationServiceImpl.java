package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryFrontProductTagRelationDao;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductTagRelationRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductTagRelationService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDFrontProductTagRelationServiceImpl;
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
@Service("productTagRelationService")
public class FrontProductTagRelationServiceImpl extends CRUDFrontProductTagRelationServiceImpl implements FrontProductTagRelationService {
    @Resource
    QueryFrontProductTagRelationDao queryFrontProductTagRelationDao;

    @Override
    public List findProductTagRelationPage(Page<FrontProductTagRelationRecord> page, FrontProductTagRelationRecord record,
                                           String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryFrontProductTagRelationDao.findProductTagRelationPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
