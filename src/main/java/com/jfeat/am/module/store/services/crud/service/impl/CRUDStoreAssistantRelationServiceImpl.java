package com.jfeat.am.module.store.services.crud.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.FIELD;
import com.jfeat.am.module.store.services.persistence.model.Store;
import com.jfeat.am.module.store.services.persistence.model.StoreAssistant;
import com.jfeat.am.module.store.services.persistence.dao.StoreAssistantRelationMapper;
import com.jfeat.am.module.store.services.persistence.dao.StoreMapper;
import com.jfeat.am.module.store.services.persistence.dao.StoreAssistantMapper;
import com.jfeat.am.module.store.services.persistence.model.StoreAssistantRelation;
import com.jfeat.am.module.store.services.persistence.dao.StoreAssistantRelationMapper;


import com.jfeat.am.module.store.services.crud.service.CRUDStoreAssistantRelationService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;
import com.jfeat.am.common.exception.BusinessCode;

import javax.annotation.Resource;

import com.jfeat.am.common.crud.impl.CRUDServicePeerImpl;

/**
 * <p>
 * implementation
 * </p>
 * CRUDStoreAssistantRelationService
 *
 * @author Code Generator
 * @since 2018-07-25
 */

@Service("CRUDStoreAssistantRelationService")
public class CRUDStoreAssistantRelationServiceImpl extends CRUDServicePeerImpl<Store, StoreAssistant, StoreAssistantRelation> implements CRUDStoreAssistantRelationService {


    @Resource
    private StoreMapper masterMapper;

    @Resource
    private StoreAssistantMapper masterPeerMapper;

    @Resource
    private StoreAssistantRelationMapper relationMapper;


    @Override
    protected BaseMapper<Store> getMasterMapper() {
        return masterMapper;
    }

    @Override
    protected BaseMapper<StoreAssistant> getMasterPeerMapper() {
        return masterPeerMapper;
    }

    @Override
    protected BaseMapper<StoreAssistantRelation> getRelationMapper() {
        return relationMapper;
    }

    @Override
    protected String[] relationMatches() {
        return new String[0];
    }


}


