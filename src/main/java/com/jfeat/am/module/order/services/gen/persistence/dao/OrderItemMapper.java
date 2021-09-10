package com.jfeat.am.module.order.services.gen.persistence.dao;

import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-31
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    List<OrderItem> selectItemList(@Param("orderId") Long orderId);
}