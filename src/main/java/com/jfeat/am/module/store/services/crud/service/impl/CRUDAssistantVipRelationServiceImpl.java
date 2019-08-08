package com.jfeat.am.module.store.services.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.FIELD;
import com.jfeat.am.module.store.services.persistence.model.AssistantVipRelation;
import com.jfeat.am.module.store.services.persistence.dao.AssistantVipRelationMapper;


import com.jfeat.am.module.store.services.crud.service.CRUDAssistantVipRelationService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;
import com.jfeat.am.common.exception.BusinessCode;
import javax.annotation.Resource;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDAssistantVipRelationService
 * @author Code Generator
 * @since 2018-08-17
 */

@Service
public class CRUDAssistantVipRelationServiceImpl  extends CRUDServiceOnlyImpl<AssistantVipRelation> implements CRUDAssistantVipRelationService {





        @Resource
        private AssistantVipRelationMapper assistantVipRelationMapper;

        @Override
        protected BaseMapper<AssistantVipRelation> getMasterMapper() {
                return assistantVipRelationMapper;
        }







}


