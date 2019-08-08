package com.jfeat.am.module.store.services.domain.dao;

import com.jfeat.am.module.store.services.domain.model.StoreShiftingRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Code Generator on 2018-06-09
 */
public interface QueryStoreShiftingDao extends BaseMapper<StoreShiftingRecord> {
    List<StoreShiftingRecord> findStoreShiftingPage(Page<StoreShiftingRecord> page,
                                                    @Param("userId") Long userId,
                                                    @Param("record") StoreShiftingRecord record,
                                                    @Param("orderBy") String orderBy,
                                                    @Param("isMyApply") Integer isMyApply);
}