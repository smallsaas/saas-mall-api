package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;
import com.jfeat.am.module.frontuser.services.gen.persistence.model.FrontUser;
import com.jfeat.am.module.order.services.domain.model.OrderModel;
import com.jfeat.am.module.order.services.domain.model.OrderRecord;
import com.jfeat.am.module.order.services.domain.model.OrderRequest;
import com.jfeat.am.module.order.services.domain.model.RequestOrder;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderService;

import java.math.BigDecimal;
import java.rmi.ServerException;
import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface OrderService extends CRUDOrderService{
    List findOrderPage(Page<OrderRecord> page, OrderRecord record, String search,
                           String orderBy, Date startTime,Date startEndTime, Date endTime,Long allianceId,
                            BigDecimal leftMoney,BigDecimal rightMoney);

   /* public Integer createOrder(OrderRequest requestOrder) throws ServerException;*/
    /**
     * 根据id获取订单详情
     * @param id
     * @return
     */
    OrderModel getOrder(Long id);

    /**
     * 更新指定id数据的状态
     * @param id
     * @param orderStatus
     * @return 数据库受影响的行数
     */
    Integer updateOrderStatus(Long id, String orderStatus);



    public List<FrontUser> getUsers(String search);

    public List<FrontProductRecord> getProducts(String search);

    public Integer createOrder(RequestOrder requestOrder) throws ServerException;

    public Integer closeConfirmedOrder(Long id);

    public Integer cancelCloseConfirmedOrder(Long id);
    public Integer cancelOrder(Long id)throws ServerException;

}