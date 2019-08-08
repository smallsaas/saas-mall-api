package com.jfeat.am.module.store.services.crud.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.FIELD;
import com.jfeat.am.module.store.services.persistence.model.Store;
import com.jfeat.am.module.store.services.persistence.dao.StoreMapper;
import com.jfeat.am.module.store.services.persistence.dao.StoreAssistantMapper;
import com.jfeat.am.module.store.services.persistence.model.StoreAssistant;


import com.jfeat.am.module.store.services.crud.service.CRUDStoreService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;

import javax.annotation.Resource;

import com.jfeat.am.common.crud.impl.CRUDServiceOverModelImpl;
import com.jfeat.am.module.store.services.domain.model.StoreModel;

/**
 * <p>
 * implementation
 * </p>
 * CRUDStoreService
 *
 * @author Code Generator
 * @since 2018-06-09
 */

@Service
public class CRUDStoreServiceImpl extends CRUDServiceOverModelImpl<Store, StoreModel> implements CRUDStoreService {


    @Resource
    private StoreMapper storeMapper;


    @Override
    protected BaseMapper<Store> getMasterMapper() {
        return storeMapper;
    }

    @Override
    protected Class<Store> masterClassName() {
        return Store.class;
    }

    @Override
    protected Class<StoreModel> modelClassName() {
        return StoreModel.class;
    }


    @Resource
    private StoreAssistantMapper storeAssistantMapper;

    @Deprecated
    private final static String storeAssistantFieldName = "store_id";

    private final static String storeAssistantKeyName = "storeAssistant";

    @Override
    protected String[] slaveFieldNames() {
        return new String[]{
                storeAssistantKeyName

        };
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {
        if (field.compareTo(storeAssistantKeyName) == 0) {
            FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(storeAssistantFieldName);
            _field.setItemClassName(StoreAssistant.class);
            _field.setItemMapper(storeAssistantMapper);
            return _field;
        }

        throw new BusinessException(BusinessCode.BadRequest);
    }


    @Override
    protected String[] childFieldNames() {
        return new String[]{
        };
    }

    @Override
    protected FIELD onChildFieldItem(String field) {

        throw new BusinessException(BusinessCode.BadRequest);
    }


}


