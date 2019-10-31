package com.jfeat.am.module.frontproduct.services.domain.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.CarryMode;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FareTemplate;

import java.util.List;

/**
 * @author hero
 * @date 12:07
 */
public class FareTemplateModel extends FareTemplate {

    private List<CarryMode> items;


    public List<CarryMode> getItems() {
        return items;
    }

    public void setItems(List<CarryMode> items) {
        this.items = items;
    }
}
