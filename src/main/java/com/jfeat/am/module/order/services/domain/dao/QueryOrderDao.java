package com.jfeat.am.module.order.services.domain.dao;

import com.jfeat.am.module.order.services.domain.model.OrderRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.order.services.gen.persistence.model.TOrder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-31
 */
public interface QueryOrderDao extends BaseMapper<TOrder> {
    List<OrderRecord> findOrderPage(Page<OrderRecord> page, @Param("record") OrderRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime
                                            );

    Integer insertOrderItem(@Param("orderId")Long orderId,@Param("barcode")String barcode,@Param("productName")String productName,@Param("quantity")Integer quantity,@Param("finalPrice") BigDecimal finalPrice);

    List<Long> selectUserId(@Param("name") String name);
    Long selectProductId(@Param("barCode")String barCode);
}