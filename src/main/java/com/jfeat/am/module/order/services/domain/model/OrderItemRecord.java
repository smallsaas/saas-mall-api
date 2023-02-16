package com.jfeat.am.module.order.services.domain.model;

import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Code Generator on 2019-07-31
 */
public class OrderItemRecord extends OrderItem{
    //总价
    BigDecimal totalPrice;

    String skuCode;

    // 订单用户
    HashMap<String, Objects> user;

    // 订单号码,从t_order获取
    String orderNumber;

    // 创建时间，从t_order获取
    Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public HashMap<String, Objects> getUser() {
        return user;
    }

    public void setUser(HashMap<String, Objects> user) {
        this.user = user;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
