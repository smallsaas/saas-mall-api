package com.jfeat.am.module.store.services.crud.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.FIELD;
import com.jfeat.am.module.store.services.persistence.model.StoreAssistant;
import com.jfeat.am.module.store.services.persistence.dao.StoreAssistantMapper;
import com.jfeat.am.module.store.services.persistence.dao.StoreShiftingMapper;
import com.jfeat.am.module.store.services.persistence.model.StoreShifting;


import com.jfeat.am.module.store.services.crud.service.CRUDStoreAssistantService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;

import javax.annotation.Resource;

import com.jfeat.am.common.crud.impl.CRUDServiceOverModelImpl;
import com.jfeat.am.module.store.services.domain.model.StoreAssistantModel;

/**
 * <p>
 * implementation
 * </p>
 * CRUDStoreAssistantService
 *
 * @author Code Generator
 * @since 2018-06-09
 */

@Service
public class CRUDStoreAssistantServiceImpl extends CRUDServiceOverModelImpl<StoreAssistant, StoreAssistantModel> implements CRUDStoreAssistantService {


    @Resource
    private StoreAssistantMapper storeAssistantMapper;


    @Override
    protected BaseMapper<StoreAssistant> getMasterMapper() {
        return storeAssistantMapper;
    }

    @Override
    protected Class<StoreAssistant> masterClassName() {
        return StoreAssistant.class;
    }

    @Override
    protected Class<StoreAssistantModel> modelClassName() {
        return StoreAssistantModel.class;
    }


    @Resource
    private StoreShiftingMapper storeShiftingMapper;

    @Deprecated
    private final static String storeShiftingFieldName = "assistant_id";

    private final static String storeShiftingKeyName = "storeShifting";

    @Override
    protected String[] slaveFieldNames() {
        return new String[]{
                storeShiftingKeyName

        };
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {
        if (field.compareTo(storeShiftingKeyName) == 0) {
            FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(storeShiftingFieldName);
            _field.setItemClassName(StoreShifting.class);
            _field.setItemMapper(storeShiftingMapper);
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


