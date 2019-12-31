package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FrontProductMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.am.module.frontuser.services.gen.persistence.model.FrontUser;
import com.jfeat.am.module.order.api.OrderRechargeType;
import com.jfeat.am.module.order.definition.OrderStatus;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderDao;

import com.jfeat.am.module.order.services.domain.dao.QueryOrderWalletHistoryDao;
import com.jfeat.am.module.order.services.domain.model.*;
import com.jfeat.am.module.order.services.domain.service.OrderService;
import com.jfeat.am.module.order.services.domain.service.OrderWelletService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDOrderServiceImpl;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderItemMapper;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderMapper;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderProcessLogMapper;
import com.jfeat.am.module.order.services.gen.persistence.model.*;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUD;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    OrderMapper orderMapper;
    @Resource
    OrderItemMapper orderItemMapper;
    @Resource
    OrderProcessLogMapper orderProcessLogMapper;
    @Resource
    FrontProductMapper frontProductMapper;
    @Resource
    QueryOrderWalletHistoryDao queryOrderWalletHistoryDao;
    @Resource
    OrderWelletService orderWelletService;

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


    @Override
    public List<FrontUser> getUsers(String search) {

        return queryOrderDao.getUsers(search);
    }

    @Override
    public List<FrontProductRecord> getProducts(String search) {
        return queryOrderDao.getProducts(search);
    }

    @Override
    @Transactional
    public Integer createOrder(RequestOrder requestOrder) throws ServerException {

        Integer res=0;
        //之前是获取名字 现在更改为获取id
        FrontUser user = queryOrderDao.selectByUserId(requestOrder.getUserId());
        //订单项不为空 处理订单项
        if(requestOrder.getItems()!=null&&requestOrder.getItems().size()>0){
            //订单处理
            TOrder order = new TOrder();
            order.setUserId(user.getId().intValue());
            order.setPhone(requestOrder.getPhone());
            order.setDetail(requestOrder.getDetail());
            //省市区
            order.setProvince(requestOrder.getProvince());
            order.setCity(requestOrder.getCity());
            order.setDistrict(requestOrder.getDistrict());

            order.setContactUser(requestOrder.getName());
            //支付类型 默认线下支付
            order.setPaymentType("STORE");
            //默认状态 已发货
            order.setStatus(TOrderStatus.DELIVERED_CONFIRM_PENDING);
            //订单类型 线下订单
            order.setType("STORE_ORDER");

            order.setCreatedDate(requestOrder.getCreateDate());
            //计算日期

            if (order.getCreatedDate()!=null ) {
                Long time=order.getCreatedDate().getTime() - new Date().getTime();
                if(time>0){
                    throw new BusinessException(BusinessCode.BadRequest, "请选择今天或之前的日期");
                }

            }

            order.setCreatedDate(requestOrder.getCreateDate());
            String oderNumber = IdWorker.getIdStr();
            order.setOrderNumber(oderNumber);

            //获取订单数据//循环遍历
            List<OrderItemRecord> productList= requestOrder.getItems();
            //总价
            BigDecimal finalPrice=new BigDecimal(0);
            for (OrderItemRecord orderItem:productList) {

                //FrontProduct allianceProduct = queryMomentsFriendDao.queryProductById(product.getId());
                FrontProduct product=frontProductMapper.selectById(orderItem.getProductId());
                orderItem.setPrice(product.getPrice());
                orderItem.setCover(product.getCover());
                orderItem.setCostPrice(product.getCostPrice());

                Long productId = orderItem.getId();
                //设置订单总价
                //处理产品总价
                orderItem.setTotalPrice(orderItem.getPrice().multiply(new BigDecimal(orderItem.getQuantity())));
                finalPrice=orderItem.getTotalPrice().add(finalPrice);
                //查找库存
              // Integer stockBalance = queryMomentsFriendDao.queryStockBalance(productId);
                Integer stockBalance =product.getStockBalance();
                //更改后的库存量
                stockBalance = stockBalance - orderItem.getQuantity();
                if (stockBalance < 0) { throw new BusinessException(BusinessCode.BadRequest, "商品库存不足"); }
                BigDecimal balance = queryOrderDao.queryWalletBalance(user.getId());
                if (balance == null || balance.compareTo(new BigDecimal(0.00)) <= 0) {
                    throw new BusinessException(BusinessCode.BadRequest, "该用户余额不足");
                } else {
                    balance = balance.subtract(orderItem.getTotalPrice());
                    if (balance.compareTo(new BigDecimal(0.00)) < 0) {
                        throw new BusinessException(BusinessCode.BadRequest, "该用户余额不足");
                    } else {
                        //更新用户余额
                        queryOrderDao.upWallet(user.getId(), balance);
                    }
                }
                //更新产品库存
                queryOrderDao.upProduct(productId, stockBalance);
            }

            //封面处理
          /* if( requestOrder.getImges()!=null&& requestOrder.getImges().size()>0){
               order.setCover(requestOrder.getImges().get(0).getUrl()) ;
           }*/
            order.setCover(requestOrder.getItems().get(0).getCover());

            //插入订单
            order.setTotalPrice(finalPrice);
            orderMapper.insert(order);

            String note = "线下订单";
            //插入钱包记录数据
            orderWelletService.insertWelletHistoryByUserId(order.getTotalPrice(),order.getUserId().longValue(), OrderRechargeType.PAYMENT,note);


            for (OrderItemRecord product:productList) {

                product.setOrderId(order.getId().intValue());
              orderItemMapper.insert(product);
            }
        }
        //订单项为空则抛出
        else{ throw new BusinessException(BusinessCode.BadRequest, "请添加产品");}
        return res;
    }





    @Override
    public Integer closeConfirmedOrder(Long id) {

        Integer i=queryOrderDao.closeProduct(id);
        /*    SettlementCenterService.settlementOrder(id);*/

        return null;
    }

    @Override
    public Integer cancelCloseConfirmedOrder(Long id) {

        Integer i=queryOrderDao.cancelcloseProduct(id);
     /*   SettlementCenterService.cancelSettlementOrder(id);
        //改状态 已发货 DELIVERED_CONFIRM_PENDING
        //设置 未结算 0
        */
        return i;
    }


    @Override
    @Transactional
    public Integer cancelOrder(Long id) throws ServerException {
        TOrder order = orderMapper.selectById(id);
        Integer res=0;
        //状态 已取消
        order.setStatus(TOrderStatus.CLOSED_CANCELED);
        //获取订单数据//循环遍历
        List<OrderItem> friendOrderItemList=
                orderItemMapper.selectList(new EntityWrapper<OrderItem>().eq("order_id",order.getId()));
        //总价
        BigDecimal finalPrice=new BigDecimal(0);
        for (OrderItem product:friendOrderItemList) {

            BigDecimal TotalPrice = product.getPrice().multiply(new BigDecimal(product.getQuantity()));
            finalPrice=TotalPrice.add(finalPrice);
            //还原库存
            Integer stockBalance = queryOrderDao.upStockBalance(product.getProductId(),product.getQuantity());

        }
        BigDecimal balance = queryOrderDao.queryWalletBalance(order.getUserId().longValue());
        //更新用户余额
        queryOrderDao.upWallet(order.getUserId().longValue(), order.getTotalPrice().add(balance));

        String note = "取消订单 订单号："+order.getOrderNumber();
        //插入钱包记录数据
        orderWelletService.insertWelletHistoryByUserId(order.getTotalPrice(),order.getUserId().longValue(), OrderRechargeType.PAYMENT,note);

        //更新订单
        queryOrderDao.updateById(order);
        return res;
    }







}
