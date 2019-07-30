package com.jfeat.am.module.product.services.domain.model;

import com.jfeat.am.module.product.services.gen.persistence.model.Product;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductDescription;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductImage;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductTag;

import java.util.List;

/**
 * @author hero
 * @date 12:26
 */
public class ProductModel extends Product {

    private List<ProductImage> productImageList;

    private List<Integer> tagIds;

    private List<ProductTag> productTagList;

    private ProductDescription productDescription;

    public List<Integer> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Integer> tagIds) {
        this.tagIds = tagIds;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public List<ProductTag> getProductTagList() {
        return productTagList;
    }

    public void setProductTagList(List<ProductTag> productTagList) {
        this.productTagList = productTagList;
    }
}
