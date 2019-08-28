package com.jfeat.am.module.frontproduct.services.domain.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductBrand;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductDescription;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductImage;

import java.util.List;

/**
 * @author hero
 * @date 12:26
 */
public class FrontProductModel extends FrontProduct {

    private ProductBrand productBrand;

    private String fareName;

    private List<ProductImage> productImageList;

    private List<Long> tagIds;

    private ProductDescription productDescription;

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
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

    public String getFareName() {
        return fareName;
    }

    public void setFareName(String fareName) {
        this.fareName = fareName;
    }

    public ProductBrand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand;
    }
}
