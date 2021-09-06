package com.jfeat.am.module.order.services.gen.persistence.dao;

import com.jfeat.am.module.order.services.domain.model.OrderExpress;
import com.jfeat.am.module.order.services.gen.persistence.model.Express;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Code Generator
 * @since 2019-08-01
 */
public interface ExpressMapper extends BaseMapper<Express> {
    Integer createOrderExpress(@Param("orderExpress") OrderExpress orderExpress);
    OrderExpress getOrderExpressByOrderId(@Param("orderId") Long orderId);
}