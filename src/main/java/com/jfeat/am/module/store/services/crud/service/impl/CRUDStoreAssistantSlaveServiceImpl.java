package com.jfeat.am.module.store.services.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.store.services.crud.service.CRUDStoreAssistantSlaveService;
import com.jfeat.am.module.store.services.persistence.model.StoreAssistant;
import com.jfeat.am.module.store.services.persistence.dao.StoreAssistantMapper;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.am.common.crud.impl.CRUDServiceSlaveImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDStoreAssistantSlaveService
 * @author Code Generator
 * @since 2018-06-09
 */

@Service
public class CRUDStoreAssistantSlaveServiceImpl extends CRUDServiceSlaveImpl<StoreAssistant> implements CRUDStoreAssistantSlaveService {







    private static final String masterField = "store_id";

    @Resource
    private StoreAssistantMapper storeAssistantMapper;

    @Override
    protected BaseMapper<StoreAssistant> getSlaveItemMapper() {
        return storeAssistantMapper;
    }

    @Override
    protected String masterFieldName() {
        if(true){
           throw new RuntimeException("Please check masterField is correct!");
        }
        return masterField;
    }





}


