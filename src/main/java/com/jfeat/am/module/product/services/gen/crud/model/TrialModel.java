package com.jfeat.am.module.product.services.gen.crud.model;

import java.util.List;
import com.jfeat.am.module.product.services.gen.persistence.model.TrialImage;
import com.jfeat.am.module.product.services.gen.persistence.model.Trial;

/**
 * Created by Code Generator on 2019-08-02
 */
public class TrialModel extends Trial{
    private List<TrialImage> items;

    public List<TrialImage> getItems() {
        return this.items;
    }

    public void setItems(List<TrialImage> items) {
        this.items = items;
    }
}
