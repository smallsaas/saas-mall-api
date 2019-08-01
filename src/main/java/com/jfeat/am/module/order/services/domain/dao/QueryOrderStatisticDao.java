package com.jfeat.am.module.order.services.domain.dao;

import com.jfeat.am.module.order.services.domain.model.OrderStatisticRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderStatistic;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-31
 */
public interface QueryOrderStatisticDao extends BaseMapper<OrderStatistic> {
    List<OrderStatisticRecord> findOrderStatisticPage(Page<OrderStatisticRecord> page, @Param("record") OrderStatisticRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}