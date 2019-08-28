package com.jfeat.am.module.frontproduct.services.gen.crud.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.Trial;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.TrialImage;

import java.util.List;

/**
 * Created by Code Generator on 2019-08-02
 */
public class TrialModel extends Trial{
    private FrontProduct frontProduct;
    private List<TrialImage> items;

    public List<TrialImage> getItems() {
        return this.items;
    }

    public void setItems(List<TrialImage> items) {
        this.items = items;
    }

    public FrontProduct getFrontProduct() {
        return frontProduct;
    }

    public void setFrontProduct(FrontProduct frontProduct) {
        this.frontProduct = frontProduct;
    }
}
