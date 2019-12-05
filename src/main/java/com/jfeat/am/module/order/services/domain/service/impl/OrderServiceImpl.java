package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderDao;

import com.jfeat.am.module.order.services.domain.model.OrderModel;
import com.jfeat.am.module.order.services.domain.model.OrderRecord;
import com.jfeat.am.module.order.services.domain.model.OrderRequest;
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
import java.math.BigDecimal;
import java.rmi.ServerException;
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
                              String search, String orderBy, Date startTime, Date startEndTime, Date endTime, Long allianceId, BigDecimal leftMoney,BigDecimal rigthMoney) {
        List recordList = this.queryOrderDao.findOrderPage(page, record, search, orderBy, startTime,startEndTime, endTime,allianceId,leftMoney,rigthMoney);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }



    @Override
    public OrderModel getOrder(Long id) {
        TOrder TOrder = this.retrieveMaster(id);
        OrderModel orderModel = CRUD.castObject(TOrder, OrderModel.class);
        //拼接省市区
        String detail;
        if(orderModel.getProvince()!=null &&orderModel.getCity()!=null &&orderModel.getDistrict()!=null){
            detail =orderModel.getProvince()+"\n"+orderModel.getCity()+"\n"+orderModel.getDistrict()+"\n"+
                    orderModel.getDetail();
            detail.replaceAll("null","");

        }else{
        detail=orderModel.getDetail();}


        orderModel.setDetail(detail);

        List<OrderItem> orderItemList = orderItemMapper.selectList(new EntityWrapper<OrderItem>().eq("order_id", id));
        orderModel.setOrderItemList(orderItemList);
        List<OrderProcessLog> orderProcessLogList = orderProcessLogMapper.selectList(new EntityWrapper<OrderProcessLog>().eq("order_id", id));
        orderModel.setOrderProcessLogList(orderProcessLogList);

        orderModel.setUserName(queryOrderDao.getUserName(TOrder.getUserId().longValue()));
        return orderModel;
    }

    @Override
    public Integer updateOrderStatus(Long id, String orderStatus) {
        return orderMapper.updateById(new TOrder().setId(id).setStatus(orderStatus));
    }
}
