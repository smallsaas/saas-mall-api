package com.jfeat.am.module.frontproduct.services.domain.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;

import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public class FrontProductCategoryRecord extends FrontProductCategory {

    private List<FrontProductCategoryRecord> subCategoryList;

    public List<FrontProductCategoryRecord> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<FrontProductCategoryRecord> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
