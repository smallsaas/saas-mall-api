package com.jfeat.am.module.frontproduct.services.domain.model;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductSettlementProportion;

import java.math.BigDecimal;

/**
 * Created by Code Generator on 2019-07-25
 */
public class ProductSettlementProportionRecord extends ProductSettlementProportion{
   // {"fixedvalue":true,"percentage":false,"value":0.0}
    BigDecimal value;
    boolean fixedvalue;
    boolean percentage;
    String  rewardType;

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean isFixedvalue() {
        return fixedvalue;
    }

    public void setFixedvalue(boolean fixedvalue) {
        this.fixedvalue = fixedvalue;
    }

    public boolean isPercentage() {
        return percentage;
    }

    public void setPercentage(boolean percentage) {
        this.percentage = percentage;
    }
}
