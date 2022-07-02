package com.jfeat.am.module.supplier.services.domain.model;


import com.jfeat.am.module.supplier.services.gen.persistence.model.Supplier;

/**
 * Created by Code generator on 2022-05-19
 */
public class SupplierRecord extends Supplier {
    String account;
    String snapshotUrl;
    String endUserName;

    Integer orderCount;

    Integer productCount;

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getEndUserName() {
        return endUserName;
    }

    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName;
    }


    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
