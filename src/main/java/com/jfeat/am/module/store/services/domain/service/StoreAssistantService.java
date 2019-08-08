package com.jfeat.am.module.store.services.domain.service;

import com.jfeat.am.common.constant.tips.Ids;
import com.jfeat.am.module.store.services.crud.service.CRUDStoreAssistantService;
import com.jfeat.am.module.store.services.domain.model.StoreAssistantModel;
import com.jfeat.am.module.store.services.domain.model.StoreAssistantRecord;
import com.jfeat.am.module.store.services.persistence.model.StoreAssistant;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface StoreAssistantService extends CRUDStoreAssistantService{



    StoreAssistant getStoreAssistantByUserId(Long userId);


    /**
     * assistant details
     * */
    StoreAssistantModel assistantDetails(Long id);

    /**
     *
     * 指派店长
     * */
    @Transactional
    Integer assignShopkeeper(Long storeId, Long userId);

    /**
     * delete assistant 删除某个店员
     * */
    @Transactional
    Integer deleteAssistant(Long storeId, Long assistantId);

    /**
     * 所有店长
     * */
    List<StoreAssistant> allStoreKeeper();


    /**
     *
     * 员工归属的所有的店铺
     * */
    StoreAssistantModel allStores(Long userId);


    /**
     * 新建 店员 并 插入 店员与店铺的关系
     * */
    @Transactional
    Integer addStoreAssistant(StoreAssistant entity);

    /**
     * 移除 店员
     */
    @Transactional
    Integer deleteStoreAssistant(Long storeId, Ids ids);




    @Deprecated
    StoreAssistantRecord assistantDetails(long id);

    /**
     *
     * @Return userName
     * */
    @Deprecated
    StoreAssistantRecord assistant(long id);

}