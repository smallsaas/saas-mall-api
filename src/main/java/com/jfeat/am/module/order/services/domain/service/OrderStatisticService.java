package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.model.OrderStatisticRecord;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderStatisticService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface OrderStatisticService extends CRUDOrderStatisticService{
    List findOrderStatisticPage(Page<OrderStatisticRecord> page, OrderStatisticRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}