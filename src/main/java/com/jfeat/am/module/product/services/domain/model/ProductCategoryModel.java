package com.jfeat.am.module.product.services.domain.model;

import com.jfeat.am.module.product.services.gen.persistence.model.ProductCategory;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductCategoryProperty;

import java.util.List;

/**
 * @author hero
 * @date 10:19
 */
public class ProductCategoryModel extends ProductCategory {
    private List<ProductCategoryProperty> productCategoryPropertyList;

    public List<ProductCategoryProperty> getProductCategoryPropertyList() {
        return productCategoryPropertyList;
    }

    public void setProductCategoryPropertyList(List<ProductCategoryProperty> productCategoryPropertyList) {
        this.productCategoryPropertyList = productCategoryPropertyList;
    }
}
