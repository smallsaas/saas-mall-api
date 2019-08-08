package com.jfeat.am.module.store.services.domain.service;

import com.jfeat.am.module.store.services.crud.service.CRUDStoreService;
import com.jfeat.am.module.store.services.domain.model.StoreModel;
import com.jfeat.am.module.store.services.domain.model.StoreRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

/**
 * Created by vincent on 2017/10/19.
 */
public interface StoreService extends CRUDStoreService{

    StoreRecord findStoreInfo(Long id, BigDecimal latitude, BigDecimal longitude);



    /**
     *  create store include images
     * */
    Integer createStore(StoreModel entity);

    /**
     * update Store
     * */
    Integer updateStore(Long id, StoreModel entity);

}