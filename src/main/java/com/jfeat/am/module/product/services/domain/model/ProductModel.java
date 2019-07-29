package com.jfeat.am.module.product.services.domain.model;

import com.jfeat.am.module.product.services.gen.persistence.model.Product;

import java.util.List;

/**
 * @author hero
 * @date 12:26
 */
public class ProductModel extends Product {

    private List<ProductImageModel> productImageModelList;

    private List<Integer> tagIds;

    private ProductDescriptionModel productDescriptionModel;

    public List<ProductImageModel> getProductImageModelList() {
        return productImageModelList;
    }

    public void setProductImageModelList(List<ProductImageModel> productImageModelList) {
        this.productImageModelList = productImageModelList;
    }

    public List<Integer> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Integer> tagIds) {
        this.tagIds = tagIds;
    }

    public ProductDescriptionModel getProductDescriptionModel() {
        return productDescriptionModel;
    }

    public void setProductDescriptionModel(ProductDescriptionModel productDescriptionModel) {
        this.productDescriptionModel = productDescriptionModel;
    }
}
