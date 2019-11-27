package com.jfeat.am.module.order.services.domain.model;

import com.jfeat.am.module.order.services.gen.persistence.model.TOrder;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderProcessLog;

import java.util.List;

/**
 * @author hero
 * @date 17:40
 */
public class OrderModel extends TOrder {
    private List<OrderItem> orderItemList;

    private String userName;

    private List<OrderProcessLog> orderProcessLogList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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
