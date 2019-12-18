package com.jfeat.am.module.frontproduct.services.domain.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;

import java.util.ArrayList;
import java.util.List;

public class FrontProductList {
    private List<FrontProduct> products;
    Integer length;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<FrontProduct> getProducts() {
        return products;
    }

    public void setProducts(List<FrontProduct> products) {
        this.products = products;
    }
}
