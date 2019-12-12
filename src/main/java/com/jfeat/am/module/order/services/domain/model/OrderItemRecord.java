package com.jfeat.am.module.order.services.domain.model;

import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;

import java.math.BigDecimal;

/**
 * Created by Code Generator on 2019-07-31
 */
public class OrderItemRecord extends OrderItem{
    //总价
    BigDecimal totalPrice;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
