package com.jfeat.am.module.store.services.domain.dao;

import com.jfeat.am.module.store.services.domain.model.StoreAssistantModel;
import com.jfeat.am.module.store.services.domain.model.StoreAssistantRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Code Generator on 2018-06-09
 */
public interface QueryStoreAssistantDao extends BaseMapper<StoreAssistantRecord> {
    List<StoreAssistantRecord> findStoreAssistantPage(Page<StoreAssistantRecord> page, @Param("record") StoreAssistantRecord record,
                                                      @Param("orderBy") String orderBy, @Param("exact") boolean exact);



    StoreAssistantModel assistantDetails(@Param("id") Long id);



    @Select("select t_store_assistant.name as userName from t_store_assistant where t_store_assistant.user_id = #{userId}")
    String userName(@Param("userId") Long userId);


    @Select("select t_store_assistant.name as userName from t_store_assistant where t_store_assistant.id = #{id}")
    String nextUserName(@Param("id") Long id);


    @Select("select t_store_assistant.id from t_store_assistant where t_store_assistant.user_id = #{userId}")
    Long userId(@Param("userId") Long userId);


    @Select("select count(1) from #{tableName} where #{tableName}.#{fieldName} = '#{fieldValue}'")
    Integer checkRepeat(@Param("tableName") String tableName, @Param("fieldName") String fieldName, @Param("fieldValue") String fieldValue);



}