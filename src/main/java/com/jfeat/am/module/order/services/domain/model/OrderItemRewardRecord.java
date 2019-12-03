package com.jfeat.am.module.order.services.domain.model;

import com.jfeat.am.module.order.services.gen.persistence.model.OrderItemReward;

/**
 * Created by Code Generator on 2019-07-31
 */
public class OrderItemRewardRecord extends OrderItemReward{
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
