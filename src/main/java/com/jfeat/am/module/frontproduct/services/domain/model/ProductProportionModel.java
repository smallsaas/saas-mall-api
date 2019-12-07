package com.jfeat.am.module.frontproduct.services.domain.model;

import java.math.BigDecimal;

public class ProductProportionModel {
    boolean fixedvalue;
    boolean percentage;
    BigDecimal value;

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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
