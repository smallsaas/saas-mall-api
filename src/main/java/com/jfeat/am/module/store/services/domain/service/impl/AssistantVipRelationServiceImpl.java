package com.jfeat.am.module.store.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.module.store.services.domain.service.AssistantVipRelationService;

import com.jfeat.am.module.store.services.crud.service.impl.CRUDAssistantVipRelationServiceImpl;
import com.jfeat.am.module.store.services.persistence.model.AssistantVipRelation;
import org.springframework.stereotype.Service;
import com.jfeat.am.common.constant.tips.Ids;

import javax.annotation.Resource;

import com.jfeat.am.module.store.services.persistence.dao.AssistantVipRelationMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service
public class AssistantVipRelationServiceImpl extends CRUDAssistantVipRelationServiceImpl implements AssistantVipRelationService {
    @Resource
    private AssistantVipRelationMapper assistantVipRelationMapper;

    @Override
    public Integer bulkDelete(Ids ids) {
        Integer success = 0;
        for (Long id : ids.getIds()) {
            success += assistantVipRelationMapper.deleteById(id);
        }
        return success;
    }

    @Transactional
    public Integer deleteRelation(AssistantVipRelation relation){

        return assistantVipRelationMapper.delete(new EntityWrapper<AssistantVipRelation>()
                .eq(AssistantVipRelation.ASSISTANT_ID,relation.getAssistantId())
                .eq(AssistantVipRelation.VIP_ID,relation.getVipId()));
    }
}
