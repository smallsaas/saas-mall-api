package com.jfeat.am.module.product.services.domain.model;

import com.jfeat.am.module.product.services.gen.persistence.model.ProductCategory;

import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public class ProductCategoryRecord extends ProductCategory{

    private List<ProductCategoryRecord> subCategoryList;

    public List<ProductCategoryRecord> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<ProductCategoryRecord> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
