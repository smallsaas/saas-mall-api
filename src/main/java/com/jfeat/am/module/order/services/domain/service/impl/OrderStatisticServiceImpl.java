package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderStatisticDao;
import com.jfeat.am.module.order.services.domain.model.OrderStatisticRecord;
import com.jfeat.am.module.order.services.domain.service.OrderStatisticService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDOrderStatisticServiceImpl;
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
@Service("orderStatisticService")
public class OrderStatisticServiceImpl extends CRUDOrderStatisticServiceImpl implements OrderStatisticService {
    @Resource
    QueryOrderStatisticDao queryOrderStatisticDao;

    @Override
    public List findOrderStatisticPage(Page<OrderStatisticRecord> page, OrderStatisticRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryOrderStatisticDao.findOrderStatisticPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
