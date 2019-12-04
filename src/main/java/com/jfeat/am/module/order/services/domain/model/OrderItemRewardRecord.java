package com.jfeat.am.module.order.services.domain.model;

import com.jfeat.am.module.order.services.gen.persistence.model.OrderItemReward;

import java.math.BigDecimal;

/**
 * Created by Code Generator on 2019-07-31
 */
public class OrderItemRewardRecord extends OrderItemReward{

    //json串
    String proportion;
    //产品名
    String productName;
    //用户名
    String userName;
    //百分比
    String percentages;
    //订单项总价格
    BigDecimal itemPrice;
    //订单分红
    BigDecimal itemReward;

    public BigDecimal getItemReward() {
        return itemReward;
    }

    public void setItemReward(BigDecimal itemReward) {
        this.itemReward = itemReward;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getPercentages() {
        return percentages;
    }

    public void setPercentages(String percentages) {
        this.percentages = percentages;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
