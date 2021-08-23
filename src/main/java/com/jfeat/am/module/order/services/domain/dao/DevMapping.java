package com.jfeat.am.module.order.services.domain.dao;

public interface DevMapping {

    Integer deleteOrder(String type);
    Integer deleteOrderService(String type);
    Integer deleteOrderServiceItem(String type);
}
