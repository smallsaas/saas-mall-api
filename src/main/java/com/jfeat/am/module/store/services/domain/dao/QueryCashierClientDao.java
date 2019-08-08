package com.jfeat.am.module.store.services.domain.dao;

import com.jfeat.am.module.store.services.domain.model.CashierClientRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Code Generator on 2018-06-09
 */
public interface QueryCashierClientDao extends BaseMapper<CashierClientRecord> {
    List<CashierClientRecord> findCashierClientPage(Page<CashierClientRecord> page, @Param("record") CashierClientRecord record, @Param("orderBy") String orderBy);


    @Select("select t_cashier_client.id from t_cashier_client where t_cashier_client.store_id = #{storeId}")
    Long cashierClientId(@Param("storeId") Long storeId);
}