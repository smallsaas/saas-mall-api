package com.jfeat.am.module.order.services.domain.dao;

import com.jfeat.am.module.order.services.domain.model.OrderCustomerServiceItemRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderCustomerServiceItem;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-31
 */
public interface QueryOrderCustomerServiceItemDao extends BaseMapper<OrderCustomerServiceItem> {
    List<OrderCustomerServiceItemRecord> findOrderCustomerServiceItemPage(Page<OrderCustomerServiceItemRecord> page, @Param("record") OrderCustomerServiceItemRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}