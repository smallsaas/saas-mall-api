package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryInclPostageProvisoDao;
import com.jfeat.am.module.frontproduct.services.domain.model.InclPostageProvisoRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.InclPostageProvisoService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDInclPostageProvisoServiceImpl;
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
@Service("inclPostageProvisoService")
public class InclPostageProvisoServiceImpl extends CRUDInclPostageProvisoServiceImpl implements InclPostageProvisoService {
    @Resource
    QueryInclPostageProvisoDao queryInclPostageProvisoDao;

    @Override
    public List findInclPostageProvisoPage(Page<InclPostageProvisoRecord> page, InclPostageProvisoRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryInclPostageProvisoDao.findInclPostageProvisoPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
