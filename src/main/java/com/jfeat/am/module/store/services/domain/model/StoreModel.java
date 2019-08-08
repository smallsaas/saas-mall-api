package com.jfeat.am.module.store.services.domain.model;

import com.jfeat.am.module.store.services.persistence.model.Store;
import com.jfeat.am.module.store.services.persistence.model.StoreAssistant;
import com.jfeat.images.services.persistence.model.StockImages;

import java.util.List;

/**
 * Created by Code Generator on 2018-06-09
 */
public class StoreModel extends Store{

    private List<StoreAssistant> storeAssistant;
    List<StockImages> images;


    public List<StoreAssistant> getStoreAssistant() {
        return storeAssistant;
    }

    public void setStoreAssistant(List<StoreAssistant> storeAssistant) {
        this.storeAssistant = storeAssistant;
    }

    public List<StockImages> getImages() {
        return images;
    }

    public void setImages(List<StockImages> images) {
        this.images = images;
    }
}
