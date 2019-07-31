package com.jfeat.am.module.product.services.domain.model;

import com.jfeat.am.module.product.services.gen.persistence.model.FareTemplate;
import com.jfeat.am.module.product.services.gen.persistence.model.InclPostageProviso;

import java.util.List;

/**
 * @author hero
 * @date 12:07
 */
public class FareTemplateModel extends FareTemplate {

    private List<InclPostageProviso> inclPostageProvisoList;

    public List<InclPostageProviso> getInclPostageProvisoList() {
        return inclPostageProvisoList;
    }

    public void setInclPostageProvisoList(List<InclPostageProviso> inclPostageProvisoList) {
        this.inclPostageProvisoList = inclPostageProvisoList;
    }
}
