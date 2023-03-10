package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;
import com.jfeat.am.module.frontuser.services.gen.persistence.model.FrontUser;
import com.jfeat.am.module.order.services.domain.model.*;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.rmi.ServerException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by vincent on 2017/10/19.
 */
public interface OrderService extends CRUDOrderService{
    List findOrderPage(
             QueryWrapper queryWrapper,
            Page<OrderRecord> page,
                       OrderRecord record, String search,
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
     * 根据id列表获取多个订单
     * @param ids
     * @return
     */
    List<OrderRecord> listOrder(List<Integer> ids);

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

    @Transactional
    Integer deliver(OrderDeliver orderDeliver);

    @Transactional
    ExpressInfo expressInfo(Long id);

    void setItemsByPages(Page<OrderRecord> page);

    /**
     * 获取商品已团总数
     * @param productId 商品id
     * @return 已团总数
     */
    int sumQuantityByProductId(Long productId);

    /**
     * 大匠小程序团购 - 取消订单
     * @param productId
     * @return
     */
    int cancelOrderByProductId(Long productId);

}