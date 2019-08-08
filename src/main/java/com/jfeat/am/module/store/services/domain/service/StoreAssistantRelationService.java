package com.jfeat.am.module.store.services.domain.service;

import com.jfeat.am.module.store.services.crud.service.CRUDStoreAssistantRelationService;
import com.jfeat.am.common.constant.tips.Ids;

/**
 * Created by vincent on 2017/10/19.
 */
public interface StoreAssistantRelationService extends CRUDStoreAssistantRelationService{
        Integer bulkDelete(Ids ids);
}