package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderProcessLogDao;
import com.jfeat.am.module.order.services.domain.model.OrderProcessLogRecord;
import com.jfeat.am.module.order.services.domain.service.OrderProcessLogService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDOrderProcessLogServiceImpl;
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
@Service("orderProcessLogService")
public class OrderProcessLogServiceImpl extends CRUDOrderProcessLogServiceImpl implements OrderProcessLogService {
    @Resource
    QueryOrderProcessLogDao queryOrderProcessLogDao;

    @Override
    public List findOrderProcessLogPage(Page<OrderProcessLogRecord> page, OrderProcessLogRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryOrderProcessLogDao.findOrderProcessLogPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
