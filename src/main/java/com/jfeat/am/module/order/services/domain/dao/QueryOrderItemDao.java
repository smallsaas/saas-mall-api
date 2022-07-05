package com.jfeat.am.module.order.services.domain.dao;

import com.jfeat.am.module.order.services.domain.model.OrderItemRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-31
 */
public interface QueryOrderItemDao extends BaseMapper<OrderItem> {

    List<OrderItemRecord> inventory(@Param("orgId")Long orgId,@Param("search")String search);

    List<OrderItemRecord> findOrderItemPage(Page<OrderItemRecord> page, @Param("record") OrderItemRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}