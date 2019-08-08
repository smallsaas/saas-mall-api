package com.jfeat.am.module.store.services.domain.service.impl;

import com.jfeat.am.module.store.services.domain.service.StoreAssistantRelationService;

import com.jfeat.am.module.store.services.crud.service.impl.CRUDStoreAssistantRelationServiceImpl;
import org.springframework.stereotype.Service;
import com.jfeat.am.common.constant.tips.Ids;

import javax.annotation.Resource;

import com.jfeat.am.module.store.services.persistence.dao.StoreAssistantRelationMapper;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("StoreAssistantRelationService")
public class StoreAssistantRelationServiceImpl extends CRUDStoreAssistantRelationServiceImpl implements StoreAssistantRelationService {
    @Resource
    private StoreAssistantRelationMapper storeAssistantRelationMapper;

    @Override
    public Integer bulkDelete(Ids ids) {
        Integer success = 0;
        for (Long id : ids.getIds()) {
            success += storeAssistantRelationMapper.deleteById(id);
        }
        return success;
    }
}
