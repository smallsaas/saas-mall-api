package com.jfeat.am.module.frontproduct.services.domain.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductCategoryProperty;
import com.jfeat.crud.base.request.Image;

import java.util.List;

/**
 * @author hero
 * @date 10:19
 */
public class FrontProductCategoryModel extends FrontProductCategory {
    List<Image> images;

    private List<ProductCategoryProperty> productCategoryPropertyList;

    public List<ProductCategoryProperty> getProductCategoryPropertyList() {
        return productCategoryPropertyList;
    }

    public void setProductCategoryPropertyList(List<ProductCategoryProperty> productCategoryPropertyList) {
        this.productCategoryPropertyList = productCategoryPropertyList;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
