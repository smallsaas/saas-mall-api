package com.jfeat.am.module.store.services.domain.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.store.services.domain.model.StoreRecord;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2018-06-09
 */
public interface QueryStoreDao extends BaseMapper<StoreRecord> {
    List<StoreRecord> findStorePage(Page<StoreRecord> page,
                                    @Param("record") StoreRecord record,
                                    @Param("orderBy") String orderBy,
                                    @Param("latitude") BigDecimal latitude,
                                    @Param("longitude") BigDecimal longitude,
                                    @Param("search") String search,
                                    @Param("startTime") Date startTime,
                                    @Param("endTime") Date endTime,
                                    @Param("type") String[] type,
                                    @Param("status") String[] status
    );
    StoreRecord findStoreInfo(@Param("id") Long id,
                              @Param("latitude") BigDecimal latitude,
                              @Param("longitude") BigDecimal longitude);


    /**
     * set store status to business
     * */
    Integer toBusiness(@Param("id") Long id);
    /**
     * set store status to Closed
     * */
    Integer toClosed(@Param("id") Long id);
    /**
     * set store status to Rest
     * */
    Integer toRest(@Param("id") Long id);

}