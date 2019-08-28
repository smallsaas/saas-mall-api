package com.jfeat.am.module.frontproduct.services.domain.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.CarryMode;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FareTemplate;

import java.util.List;

/**
 * @author hero
 * @date 12:07
 */
public class FareTemplateModel extends FareTemplate {

    private List<CarryMode> carryModeList;


    public List<CarryMode> getCarryModeList() {
        return carryModeList;
    }

    public void setCarryModeList(List<CarryMode> carryModeList) {
        this.carryModeList = carryModeList;
    }
}
