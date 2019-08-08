package com.jfeat.am.module.store.services.domain.service;

import com.jfeat.am.module.store.services.crud.service.CRUDAssistantVipRelationService;
import com.jfeat.am.common.constant.tips.Ids;
import com.jfeat.am.module.store.services.persistence.model.AssistantVipRelation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vincent on 2017/10/19.
 */
public interface AssistantVipRelationService extends CRUDAssistantVipRelationService {
    Integer bulkDelete(Ids ids);

    @Transactional
    public Integer deleteRelation(AssistantVipRelation relation);
}