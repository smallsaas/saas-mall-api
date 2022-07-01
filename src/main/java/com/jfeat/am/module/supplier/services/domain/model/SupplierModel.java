package com.jfeat.am.module.supplier.services.domain.model;
// this is serviceModel.java.vm


import com.jfeat.am.module.supplier.services.gen.persistence.model.Supplier;

/**
 * Created by Code generator on 2022-05-19
 *  * slaves.size() : 0
 *  * modelpack : $modelpack
 */
public class SupplierModel extends Supplier {

    String endUserName;

    String account;

    public String getEndUserName() {
        return endUserName;
    }

    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
