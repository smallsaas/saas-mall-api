package com.jfeat.am.module.store.services.domain.model;

import com.jfeat.am.module.store.services.persistence.model.Store;
import com.jfeat.images.services.persistence.model.StockImages;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Code Generator on 2018-06-09
 */
public class StoreRecord extends Store{
    private BigDecimal distance;
    private String warehouseName;
    private String warehouseAddress;
    private String warehousePCD;
    private String warehouseCode;
    private Long warehouseCharger;
    private  String storeAddress;
    private  Integer assistantCount;
    private List<StockImages> images;
    private boolean exact;

    public boolean isExact() {
        return exact;
    }

    public void setExact(boolean exact) {
        this.exact = exact;
    }

    public List<StockImages> getImages() {
        return images;
    }

    public void setImages(List<StockImages> images) {
        this.images = images;
    }

    public Long getWarehouseCharger() {
        return warehouseCharger;
    }

    public void setWarehouseCharger(Long warehouseCharger) {
        this.warehouseCharger = warehouseCharger;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehousePCD() {
        return warehousePCD;
    }

    public void setWarehousePCD(String warehousePCD) {
        this.warehousePCD = warehousePCD;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }


    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public Integer getAssistantCount() {
        return assistantCount;
    }

    public void setAssistantCount(Integer assistantCount) {
        this.assistantCount = assistantCount;
    }
}
