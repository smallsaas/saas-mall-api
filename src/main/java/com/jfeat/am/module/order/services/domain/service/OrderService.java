package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.model.OrderRecord;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface OrderService extends CRUDOrderService{
    List findOrderPage(Page<OrderRecord> page, OrderRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}