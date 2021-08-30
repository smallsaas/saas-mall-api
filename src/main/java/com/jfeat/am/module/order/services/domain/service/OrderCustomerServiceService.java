package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.model.OrderCustomerServiceRecord;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderCustomerServiceService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface OrderCustomerServiceService extends CRUDOrderCustomerServiceService{
    List findOrderCustomerServicePage(Page<OrderCustomerServiceRecord> page, OrderCustomerServiceRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}