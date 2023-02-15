package com.jfeat.am.module.frontproduct.services.domain.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.*;

import java.util.List;

/**
 * @author hero
 * @date 12:26
 */
public class FrontProductModel extends FrontProduct {


    private List<ProductSettlementProportionRecord> productSettlementProportion;

    private List<FrontProductModel> items;

    private List<ProductImage> bannerList;

    private  String categoryName;

    private String brandName;

    private ProductBrand productBrand;

    private String fareName;

    private List<ProductImage> productImageList;

    private List<Long> tagIds;

    private ProductDescription productDescription;

    private String description;

    private String noPermission;

    private String supplierName;

    private List<ProductSpecification> specifications;

    /**
     * 订单数量
     */
    private Integer orderNumber;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<FrontProductModel> getItems() {
        return items;
    }

    public void setItems(List<FrontProductModel> items) {
        this.items = items;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }


    public String getNoPermission() {
        return noPermission;
    }

    public void setNoPermission(String noPermission) {
        this.noPermission = noPermission;
    }

    public List<ProductSettlementProportionRecord> getProductSettlementProportionList() {
        return productSettlementProportion;
    }

    public void setProductSettlementProportionList(List<ProductSettlementProportionRecord> productSettlementProportionList) {
        this.productSettlementProportion = productSettlementProportionList;
    }

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductImage> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<ProductImage> bannerList) {
        this.bannerList = bannerList;
    }

    public List<ProductSpecification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<ProductSpecification> specifications) {
        this.specifications = specifications;
    }
}
