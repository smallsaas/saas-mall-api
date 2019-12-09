package com.jfeat.am.module.configmanagement.services.domain.model;

import com.jfeat.am.module.configmanagement.services.gen.persistence.model.MallConfigGroup;

public class MallConfigGroupRequest {
    MallConfigGroup[] children;

    public MallConfigGroup[] getChildren() {
        return children;
    }

    public void setChildren(MallConfigGroup[] children) {
        this.children = children;
    }
}
