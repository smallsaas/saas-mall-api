package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderItemDao;
import com.jfeat.am.module.order.services.domain.model.OrderItemRecord;
import com.jfeat.am.module.order.services.domain.model.OrderModel;
import com.jfeat.am.module.order.services.domain.model.OrderRecord;
import com.jfeat.am.module.order.services.domain.service.OrderItemService;
import com.jfeat.am.module.order.services.domain.service.OrderService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDOrderItemServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("orderItemService")
public class OrderItemServiceImpl extends CRUDOrderItemServiceImpl implements OrderItemService {

    @Resource
    QueryOrderItemDao queryOrderItemDao;

    @Resource
    OrderService orderService;

    @Override
    public List findOrderItemPage(Page<OrderItemRecord> page, OrderItemRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryOrderItemDao.findOrderItemPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    public List<OrderItemRecord> listOrderItem(OrderItemRecord orderItemRecord) {

        return queryOrderItemDao.listOrderItem(orderItemRecord);
    }

    /**
     * 根据orderItemRecord中的参数，查询对应订单下的所有用户
     *
     * @param orderItemRecord 为了保证通用性，使用orderItemRecord实体类作为参数
     * @return 有数据返回userList 否则返回null
     */
    @Override
    public List listOrderUser(OrderItemRecord orderItemRecord) {

        // 查询订单
        List<OrderItemRecord> orderItemRecordList = this.listOrderItem(orderItemRecord);
        if (orderItemRecordList == null && orderItemRecordList.size() == 0) return null;

        // 遍历orderItemRecord list获取其中的每个订单的orderId用来查询order表，因为只有order表中才有userId
        for (OrderItemRecord orderItem : orderItemRecordList) {
            // 如果没有orderId则退出此次循环
            if (orderItem.getOrderId() == null) continue;
            OrderModel order = orderService.getOrder(orderItem.getOrderId().longValue());
            // 如果没有UserId则跳出此次的循环
            if (order.getUserId() == null) continue;
            HashMap<String,Objects> user = this.getUser(order.getUserId());
            // 如果该userId没有查出数据则跳过此次循环，因为有可能该用户已不存在，那么就没有必要返回这个用户的信息了
            if (user == null || user.isEmpty()) continue;
            orderItem.setUser(user);
        }

        return orderItemRecordList;
    }

    /**
     * 查询t_end_user表
     * @param userId 用户id
     * @return
     */
    @Override
    public HashMap<String,Objects> getUser(Integer userId) {
        return queryOrderItemDao.getUser(userId);
    }
}
