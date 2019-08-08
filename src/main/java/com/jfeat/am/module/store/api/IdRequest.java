package com.jfeat.am.module.store.api;

public class IdRequest {
    private Long nextAssistantId;
    private Long storeId;
    private Long cashierClientId;
    public Long getNextAssistantId() {
        return nextAssistantId;
    }

    public void setNextAssistantId(Long nextAssistantId) {
        this.nextAssistantId = nextAssistantId;
    }


    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getCashierClientId() {
        return cashierClientId;
    }

    public void setCashierClientId(Long cashierClientId) {
        this.cashierClientId = cashierClientId;
    }
}
