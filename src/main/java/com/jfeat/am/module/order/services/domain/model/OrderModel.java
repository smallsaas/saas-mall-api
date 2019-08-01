package com.jfeat.am.module.order.services.domain.model;

import com.jfeat.am.module.order.services.gen.persistence.model.Order;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderProcessLog;

import java.util.List;

/**
 * @author hero
 * @date 17:40
 */
public class OrderModel extends Order {
    private List<OrderItem> orderItemList;

    private List<OrderProcessLog> orderProcessLogList;

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public List<OrderProcessLog> getOrderProcessLogList() {
        return orderProcessLogList;
    }

    public void setOrderProcessLogList(List<OrderProcessLog> orderProcessLogList) {
        this.orderProcessLogList = orderProcessLogList;
    }
}
