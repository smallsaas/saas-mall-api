package com.jfeat.am.module.store.services.definition;

public enum StoreStatus {
    BUSINESS("BUSINESS"),CLOSED("CLOSED"),REST("REST");
    private final String status;
    private StoreStatus(String status) {
        this.status = status;
    }
    public String toString() {
        return this.status;
    }
}
