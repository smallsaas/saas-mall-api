package com.jfeat.am.module.store.services.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.common.constant.tips.Ids;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.store.services.crud.service.CRUDStoreAssistantRelationService;
import com.jfeat.am.module.store.services.crud.service.impl.CRUDStoreAssistantServiceImpl;
import com.jfeat.am.module.store.services.domain.dao.QueryStoreAssistantDao;
import com.jfeat.am.module.store.services.domain.model.StoreAssistantModel;
import com.jfeat.am.module.store.services.domain.model.StoreAssistantRecord;
import com.jfeat.am.module.store.services.domain.service.StoreAssistantService;
import com.jfeat.am.module.store.services.persistence.dao.*;
import com.jfeat.am.module.store.services.persistence.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service
public class StoreAssistantServiceImpl extends CRUDStoreAssistantServiceImpl implements StoreAssistantService {

    @Resource
    StoreAssistantMapper storeAssistantMapper;
    @Resource
    QueryStoreAssistantDao queryStoreAssistantDao;
    @Resource(name = "CRUDStoreAssistantRelationService")
    CRUDStoreAssistantRelationService crudStoreAssistantRelationService;
    @Resource
    StoreAssistantRelationMapper storeAssistantRelationMapper;
    @Resource
    AssistantVipRelationMapper assistantVipRelationMapper;
    @Resource
    StoreShiftingMapper storeShiftingMapper;
    @Resource
    StoreMapper storeMapper;


    @Override
    public StoreAssistant getStoreAssistantByUserId(Long userId) {
        Long assistantId = queryStoreAssistantDao.userId(userId);
        if (assistantId==null){
            throw new BusinessException(BusinessCode.AuthorizationError);
        }

        return storeAssistantMapper.selectById(assistantId);
    }

    /**
     * assistant details
     * */
    public StoreAssistantModel assistantDetails(Long id){
        StoreAssistant assistant  = storeAssistantMapper.selectById(id);
        StoreAssistantModel model = null;
        if(assistant != null) {
            JSONObject object = JSON.parseObject(JSON.toJSONString(assistant));
            List<AssistantVipRelation> assistantVipRelations = assistantVipRelationMapper.selectList(new EntityWrapper<AssistantVipRelation>().eq(AssistantVipRelation.ASSISTANT_ID,id));
            object.put("assistantVipRelations",assistantVipRelations);
            List<StoreShifting> storeShiftings = storeShiftingMapper.selectList(new EntityWrapper<StoreShifting>().eq(StoreShifting.ASSISTANT_ID,id));
            object.put("storeShifting",storeShiftings);
            model = JSONObject.parseObject(JSON.toJSONString(object),StoreAssistantModel.class);

            List<StoreAssistantRelation> relations =
                    storeAssistantRelationMapper.selectList(new EntityWrapper<StoreAssistantRelation>().eq(StoreAssistantRelation.ASSISTANT_ID, id));
            List<Store> stores = new ArrayList<>();

            if(relations != null) {
                List<Long> ids = new ArrayList<>();
                for(StoreAssistantRelation relation : relations) {
                    if(Integer.valueOf(1).equals(relation.getIsShopkeeper())) {
                        model.setIsShopkeeper(1);
                    }
                    ids.add(relation.getStoreId());
                }
                if(!ids.isEmpty()) {
                    stores.addAll(storeMapper.selectBatchIds(ids));
                }
            }
            model.setIsShopkeeper(Integer.valueOf(1).equals(model.getIsShopkeeper())? 1 : 0);
            model.setStores(stores);
        }

        return model;
    }
    /**
     * (店员不存在时)新建 店员 并 插入 店员与店铺的关系
     */
    @Transactional
    public Integer addStoreAssistant(StoreAssistant entity) {

        int affect = 0;
        Long assistantId = queryStoreAssistantDao.userId(entity.getUserId());
        if(assistantId == null) {
//            affect += storeAssistantMapper.insert(entity);
            affect += this.createMaster(entity);
            assistantId=entity.getId();
        }else {

        }
        StoreAssistantRelation relation = new StoreAssistantRelation();
        relation.setAssistantId(assistantId);
        relation.setStoreId(entity.getStoreId());
        relation.setIsShopkeeper(Integer.valueOf(entity.getPosition()));
        affect += crudStoreAssistantRelationService.addRelation(relation);

        return affect;
    }


    /**
     * 移除 店员 （从店铺中移除，补在在该店铺）
     */
    @Transactional
    public Integer deleteStoreAssistant(Long storeId, Ids ids) {

        int affect = crudStoreAssistantRelationService.removePeerList(storeId, ids.getIds());
        return affect;
    }

    /**
     * 添加 店员 （已有的店员，不存在新建的问题）
     */
    @Transactional
    public Integer addStoreAssistant(Long storeId, Ids ids) {
        int affect = crudStoreAssistantRelationService.addPeerList(storeId, ids.getIds());
        return affect;
    }


    @Transactional
    public Integer assignShopkeeper(Long storeId, Long userId) {
        /**
         * 任命店长 函数
         * 1.普通员工 触发 店长
         * 2.店长 触发 为 普通 员工
         * */
        int affect = 0;

        StoreAssistantRelation relation = new StoreAssistantRelation();
        relation.setAssistantId(userId);
        relation.setStoreId(storeId);
        StoreAssistantRelation originRelation = storeAssistantRelationMapper.selectOne(relation);
        if (originRelation == null) {
            relation.setIsShopkeeper(1);
            affect += crudStoreAssistantRelationService.addRelation(relation);
            return affect;
        }else {
            if (originRelation.getIsShopkeeper().equals(1)) {
                originRelation.setIsShopkeeper(0);
                affect += crudStoreAssistantRelationService.updateRelation(originRelation);
            } else {
                originRelation.setIsShopkeeper(1);
                affect += crudStoreAssistantRelationService.updateRelation(originRelation);
            }
            return affect;
        }
    }

    /**
     * delete assistant 删除某个店员
     * */
    @Transactional
    public Integer deleteAssistant(Long storeId, Long assistantId){
        Integer effected = 0;
        effected += storeAssistantRelationMapper.delete(new EntityWrapper<StoreAssistantRelation>()
        .eq(StoreAssistantRelation.ASSISTANT_ID,assistantId)
        .eq(StoreAssistantRelation.STORE_ID,storeId));
        List<StoreAssistantRelation> relations =
                storeAssistantRelationMapper.selectList(new EntityWrapper<StoreAssistantRelation>().eq(StoreAssistantRelation.ASSISTANT_ID, assistantId));
        // 员工不属于任何店铺时，从assistant表删除
        if(relations == null || relations.isEmpty()) {
            effected += storeAssistantMapper.deleteById(assistantId);
        }
        return effected;
    }

    public List<StoreAssistant> allStoreKeeper() {
        /**
         * 店长管理 所有店长函数
         * */
        List<StoreAssistantRelation> shopkeepers = storeAssistantRelationMapper.selectList(new EntityWrapper<StoreAssistantRelation>().eq(StoreAssistantRelation.IS_SHOPKEEPER,1));

        List<StoreAssistant> assistants = new ArrayList<>();
        for (StoreAssistantRelation relation : shopkeepers){
            StoreAssistant assistant = storeAssistantMapper.selectById(relation.getAssistantId());
            assistants.add(assistant);
        }
        return assistants;
    }


    /**
     * 员工归属的所有的店铺
     */
    public StoreAssistantModel allStores(Long userId) {
        StoreAssistant storeAssistant = new StoreAssistant();
        storeAssistant.setUserId(userId);
        StoreAssistant origin = storeAssistantMapper.selectOne(storeAssistant);
        if (origin != null) {
            return queryStoreAssistantDao.assistantDetails(origin.getId());
        } else {
            return null;
        }
    }


    /**
     *
     * 暂时丢弃
     * */
    @Deprecated
    public StoreAssistantRecord assistantDetails(long id) {
        StoreAssistant storeAssistant = storeAssistantMapper.selectById(id);
        JSONObject object = JSON.parseObject(JSON.toJSONString(storeAssistant));
        StoreAssistantRecord record = JSON.parseObject(JSON.toJSONString(object), StoreAssistantRecord.class);
        return record;
    }


    /**
     * @Return userName
     */
    @Deprecated
    public StoreAssistantRecord assistant(long id) {
        StoreAssistant storeAssistant = storeAssistantMapper.selectById(id);
        JSONObject object = JSON.parseObject(JSON.toJSONString(storeAssistant));
        String username = storeAssistant.getName();
        object.put("username", username == null ? null : username);
        StoreAssistantRecord record = JSON.parseObject(JSON.toJSONString(object), StoreAssistantRecord.class);
        return record;
    }
}
