package com.jfeat.am.module.order.services.domain.model;

import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;
import com.jfeat.am.module.order.services.gen.persistence.model.TOrder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Code Generator on 2019-07-31
 */
public class OrderRecord extends TOrder {
    String pName;
    String barcode;
    // 用户名
    String userName;
    // 用户真实姓名
    String realName;
    //邀请人进货额
    BigDecimal orderAmount;
    //邀请人盟友
    String allianceName;
    // 订单产品列表
    List<OrderItem> orderItemRecordList ;
    // 用户头像
    String avatar;
    // 用户电话
    String userPhone;
    // 产品id
    Long productId;
    // 产品名
    String productName;
    // 订单用户信息
    HashMap<String,Objects> user;

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public HashMap<String, Objects> getUser() {
        return user;
    }
    public void setUser(HashMap<String, Objects> user) {
        this.user = user;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<OrderItem> getOrderItemRecordList() {
        return orderItemRecordList;
    }

    public void setOrderItemRecordList(List<OrderItem> orderItemRecordList) {
        this.orderItemRecordList = orderItemRecordList;
    }

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(String allianceName) {
        this.allianceName = allianceName;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
