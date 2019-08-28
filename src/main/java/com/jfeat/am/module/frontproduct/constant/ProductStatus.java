package com.jfeat.am.module.frontproduct.constant;

/**
 * @author hero
 * @date 14:47
 */
public enum ProductStatus {
    ONSELL("ONSELL","上架"),
    OFFSELL("OFFSELL","下架");
    private String status;
    private String desc;

    ProductStatus(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
