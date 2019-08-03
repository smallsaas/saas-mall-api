package com.jfeat.am.module.product.services.gen.crud.model;

import com.jfeat.am.module.product.services.gen.persistence.model.Product;
import com.jfeat.am.module.product.services.gen.persistence.model.Trial;
import com.jfeat.am.module.product.services.gen.persistence.model.TrialImage;

import java.util.List;

/**
 * Created by Code Generator on 2019-08-02
 */
public class TrialModel extends Trial{
    private Product product;
    private List<TrialImage> items;

    public List<TrialImage> getItems() {
        return this.items;
    }

    public void setItems(List<TrialImage> items) {
        this.items = items;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
