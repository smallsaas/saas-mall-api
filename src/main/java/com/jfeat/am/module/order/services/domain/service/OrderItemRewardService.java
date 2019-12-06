package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.model.OrderItemRewardRecord;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderItemRewardService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface OrderItemRewardService extends CRUDOrderItemRewardService{
    List findOrderItemRewardPage(Page<OrderItemRewardRecord> page, OrderItemRewardRecord record, String search,
                           String orderBy, Date startTime, Date endTime,
                                 BigDecimal leftMoney,
                                 BigDecimal rightMoney,
                                 BigDecimal itemRewardLeftMoney,
                                 BigDecimal itemRewardRightMoney);
}