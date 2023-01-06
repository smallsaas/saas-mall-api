package com.jfeat.am.module.frontproduct.services.domain.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductBrand;

import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public class FrontProductRecord extends FrontProduct {

    List<FrontProductRecord> items;

    private  String categoryName;

    private String brandName;

    private ProductBrand productBrand;

    private String supplierName;

    private String category;

    private String appid;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public List<FrontProductRecord> getItems() {
        return items;
    }

    public void setItems(List<FrontProductRecord> items) {
        this.items = items;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
