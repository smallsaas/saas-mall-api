package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderDao;
import com.jfeat.am.module.order.services.domain.model.OrderModel;
import com.jfeat.am.module.order.services.domain.model.OrderRecord;
import com.jfeat.am.module.order.services.domain.service.OrderService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDOrderServiceImpl;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderItemMapper;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderProcessLogMapper;
import com.jfeat.am.module.order.services.gen.persistence.model.TOrder;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderProcessLog;
import com.jfeat.crud.plus.CRUD;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("orderService")
public class OrderServiceImpl extends CRUDOrderServiceImpl implements OrderService {
    @Resource
    QueryOrderDao queryOrderDao;
    @Resource
    OrderItemMapper orderItemMapper;
    @Resource
    OrderProcessLogMapper orderProcessLogMapper;

    @Override
    public List findOrderPage(Page<OrderRecord> page, OrderRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryOrderDao.findOrderPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    public OrderModel getOrder(Long id) {
        TOrder TOrder = this.retrieveMaster(id);
        OrderModel orderModel = CRUD.castObject(TOrder, OrderModel.class);
        List<OrderItem> orderItemList = orderItemMapper.selectList(new EntityWrapper<OrderItem>().eq("order_id", id));
        orderModel.setOrderItemList(orderItemList);
        List<OrderProcessLog> orderProcessLogList = orderProcessLogMapper.selectList(new EntityWrapper<OrderProcessLog>().eq("order_id", id));
        orderModel.setOrderProcessLogList(orderProcessLogList);
        return orderModel;
    }

    @Override
    public Integer updateOrderStatus(Long id, String orderStatus) {
        return orderMapper.updateById(new TOrder().setId(id).setStatus(orderStatus));
    }
}
