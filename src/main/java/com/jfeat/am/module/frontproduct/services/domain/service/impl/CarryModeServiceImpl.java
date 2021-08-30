package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryCarryModeDao;
import com.jfeat.am.module.frontproduct.services.domain.model.CarryModeRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.CarryModeService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDCarryModeServiceImpl;
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
@Service("carryModeService")
public class CarryModeServiceImpl extends CRUDCarryModeServiceImpl implements CarryModeService {
    @Resource
    QueryCarryModeDao queryCarryModeDao;

    @Override
    public List findCarryModePage(Page<CarryModeRecord> page, CarryModeRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryCarryModeDao.findCarryModePage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
