package com.jfeat.am.module.frontproduct.services.domain.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductBrand;
import com.jfeat.crud.base.request.Image;

import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public class ProductBrandRecord extends ProductBrand{

    private List<Image> image;

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}
