package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderCustomerServiceDao;
import com.jfeat.am.module.order.services.domain.model.OrderCustomerServiceRecord;
import com.jfeat.am.module.order.services.domain.service.OrderCustomerServiceService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDOrderCustomerServiceServiceImpl;
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
@Service("orderCustomerServiceService")
public class OrderCustomerServiceServiceImpl extends CRUDOrderCustomerServiceServiceImpl implements OrderCustomerServiceService {
    @Resource
    QueryOrderCustomerServiceDao queryOrderCustomerServiceDao;

    @Override
    public List findOrderCustomerServicePage(Page<OrderCustomerServiceRecord> page, OrderCustomerServiceRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryOrderCustomerServiceDao.findOrderCustomerServicePage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
