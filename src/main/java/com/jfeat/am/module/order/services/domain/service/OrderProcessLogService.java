package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.model.OrderProcessLogRecord;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderProcessLogService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface OrderProcessLogService extends CRUDOrderProcessLogService{
    List findOrderProcessLogPage(Page<OrderProcessLogRecord> page, OrderProcessLogRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}