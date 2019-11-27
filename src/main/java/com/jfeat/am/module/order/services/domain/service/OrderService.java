package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.model.OrderModel;
import com.jfeat.am.module.order.services.domain.model.OrderRecord;
import com.jfeat.am.module.order.services.domain.model.OrderRequest;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderService;

import java.rmi.ServerException;
import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface OrderService extends CRUDOrderService{
    List findOrderPage(Page<OrderRecord> page, OrderRecord record, String search,
                           String orderBy, Date startTime,Date startEndTime, Date endTime,Long allianceId);

   /* public Integer createOrder(OrderRequest requestOrder) throws ServerException;*/
    /**
     * 根据id获取订单详情
     * @param id
     * @return
     */
    OrderModel getOrder(Long id);

    /**
     * 更新指定id数据的状态
     * @param id
     * @param orderStatus
     * @return 数据库受影响的行数
     */
    Integer updateOrderStatus(Long id, String orderStatus);
}