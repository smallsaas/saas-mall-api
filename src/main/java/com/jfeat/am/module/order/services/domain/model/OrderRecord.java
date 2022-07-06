package com.jfeat.am.module.order.services.domain.model;

import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;
import com.jfeat.am.module.order.services.gen.persistence.model.TOrder;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-31
 */
public class OrderRecord extends TOrder {
    String pName;
    String barcode;
    String userName;
    String realName;
    //邀请人进货额
    BigDecimal orderAmount;
//邀请人盟友
    String allianceName;

    List<OrderItem> orderItemRecordList ;

    String avatar;

    String userPhone;

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
