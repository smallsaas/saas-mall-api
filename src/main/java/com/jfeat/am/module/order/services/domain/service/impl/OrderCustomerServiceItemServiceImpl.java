package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderCustomerServiceItemDao;
import com.jfeat.am.module.order.services.domain.model.OrderCustomerServiceItemRecord;
import com.jfeat.am.module.order.services.domain.service.OrderCustomerServiceItemService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDOrderCustomerServiceItemServiceImpl;
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
@Service("orderCustomerServiceItemService")
public class OrderCustomerServiceItemServiceImpl extends CRUDOrderCustomerServiceItemServiceImpl implements OrderCustomerServiceItemService {
    @Resource
    QueryOrderCustomerServiceItemDao queryOrderCustomerServiceItemDao;

    @Override
    public List findOrderCustomerServiceItemPage(Page<OrderCustomerServiceItemRecord> page, OrderCustomerServiceItemRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryOrderCustomerServiceItemDao.findOrderCustomerServiceItemPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
