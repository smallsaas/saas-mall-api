package com.jfeat.am.module.store.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.store.services.domain.dao.QueryWarehouseDao;
import com.jfeat.am.module.store.services.domain.model.WarehouseRecord;
import com.jfeat.am.module.store.services.domain.service.WarehouseService;
import com.jfeat.am.module.store.services.gen.crud.service.impl.CRUDWarehouseServiceImpl;
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
@Service("warehouseService")
public class WarehouseServiceImpl extends CRUDWarehouseServiceImpl implements WarehouseService {
    @Resource
    QueryWarehouseDao queryWarehouseDao;

    @Override
    public List findWarehousePage(Page<WarehouseRecord> page, WarehouseRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryWarehouseDao.findWarehousePage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
