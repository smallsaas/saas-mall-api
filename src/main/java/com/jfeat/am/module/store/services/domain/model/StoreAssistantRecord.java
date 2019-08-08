package com.jfeat.am.module.store.services.domain.model;

import com.jfeat.am.module.store.services.persistence.model.StoreAssistant;

/**
 * Created by Code Generator on 2018-06-09
 */
public class StoreAssistantRecord extends StoreAssistant{
    private String username;
    private Integer isShopkeeper;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIsShopkeeper() {
        return isShopkeeper;
    }

    public void setIsShopkeeper(Integer isShopkeeper) {
        this.isShopkeeper = isShopkeeper;
    }
}
