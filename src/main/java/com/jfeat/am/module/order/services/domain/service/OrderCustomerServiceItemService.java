package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.model.OrderCustomerServiceItemRecord;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderCustomerServiceItemService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface OrderCustomerServiceItemService extends CRUDOrderCustomerServiceItemService{
    List findOrderCustomerServiceItemPage(Page<OrderCustomerServiceItemRecord> page, OrderCustomerServiceItemRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}