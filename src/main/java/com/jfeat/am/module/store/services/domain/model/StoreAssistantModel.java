package com.jfeat.am.module.store.services.domain.model;

import com.jfeat.am.module.store.services.persistence.model.*;

import java.util.List;

/**
 * Created by Code Generator on 2018-06-09
 */
public class StoreAssistantModel extends StoreAssistant{

    private List<StoreShifting> storeShifting;
    List<Store> stores;
    List<AssistantVipRelation> assistantVipRelations;
    private Integer isShopkeeper;


    public Integer getIsShopkeeper() {
        return isShopkeeper;
    }

    public void setIsShopkeeper(Integer isShopkeeper) {
        this.isShopkeeper = isShopkeeper;
    }

    public List<StoreShifting> getStoreShifting() {
        return storeShifting;
    }

    public void setStoreShifting(List<StoreShifting> storeShifting) {
        this.storeShifting = storeShifting;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<AssistantVipRelation> getAssistantVipRelations() {
        return assistantVipRelations;
    }

    public void setAssistantVipRelations(List<AssistantVipRelation> assistantVipRelations) {
        this.assistantVipRelations = assistantVipRelations;
    }
}
