package com.jfeat.am.module.configmanagement.services.gen.crud.model;

import java.util.List;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.MallConfigGroup;

/**
 * Created by Code Generator on 2019-08-13
 */
public class MallConfigGroupModel extends MallConfigGroup {
    private List<Config> items;

    public List<Config> getItems() {
        return this.items;
    }

    public void setItems(List<Config> items) {
        this.items = items;
    }
}
