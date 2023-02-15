package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.model.OrderItemRecord;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderItemService;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;

import java.util.*;

/**
 * Created by vincent on 2017/10/19.
 */
public interface OrderItemService extends CRUDOrderItemService{
    List findOrderItemPage(Page<OrderItemRecord> page, OrderItemRecord record, String search,
                           String orderBy, Date startTime, Date endTime);

    List<OrderItemRecord> listOrderItem(OrderItemRecord orderItemRecord);

    List listOrderUser(OrderItemRecord orderItemRecord);

    HashMap<String,Objects> getUser(Integer userId);

    /**
     * 分页-获取所有的商品订单
     *
     * @param page myBatisPlus分页对象
     * @return 商品列表
     */
    Page<OrderItemRecord> getOrderItemPage(Page<OrderItemRecord> page);

    /**
     * 分页-获取指定用户的商品订单
     *
     * @param page 分页对象
     * @param userId 用户id
     * @return 商品列表
     */
    Page<OrderItemRecord> getOrderItemPage(Page<OrderItemRecord> page,Integer userId);

}