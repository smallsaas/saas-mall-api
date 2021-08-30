package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryFrontProductTagDao;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductTagRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductTagService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDFrontProductTagServiceImpl;
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
@Service("productTagService")
public class FrontProductTagServiceImpl extends CRUDFrontProductTagServiceImpl implements FrontProductTagService {
    @Resource
    QueryFrontProductTagDao queryFrontProductTagDao;
    @Override
    public List findProductTagPage(Page<FrontProductTagRecord> page, FrontProductTagRecord record,
                                   String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryFrontProductTagDao.findProductTagPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
