package com.jfeat.am.module.configmanagement.services.domain.model;

import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.MallConfigGroup;

public class ConfigRequest extends MallConfigGroup{
    Config[] items;

    public Config[] getItems() {
        return items;
    }

    public void setItems(Config[] items) {
        this.items = items;
    }
}
