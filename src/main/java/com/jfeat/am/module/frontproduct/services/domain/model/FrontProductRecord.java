package com.jfeat.am.module.frontproduct.services.domain.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductBrand;

/**
 * Created by Code Generator on 2019-07-25
 */
public class FrontProductRecord extends FrontProduct {

    private String brandName;

    private ProductBrand productBrand;

    public ProductBrand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
