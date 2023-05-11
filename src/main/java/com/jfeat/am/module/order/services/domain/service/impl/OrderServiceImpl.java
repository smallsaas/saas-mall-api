package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FrontProductMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.am.module.frontuser.services.gen.persistence.model.FrontUser;
import com.jfeat.am.module.order.api.OrderRechargeType;
import com.jfeat.am.module.order.definition.OrderStatus;
import com.jfeat.am.module.order.definition.OrderType;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderDao;

import com.jfeat.am.module.order.services.domain.dao.QueryOrderWalletDao;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderWalletHistoryDao;
import com.jfeat.am.module.order.services.domain.model.*;
import com.jfeat.am.module.order.services.domain.service.ExpressService;
import com.jfeat.am.module.order.services.domain.service.OrderItemService;
import com.jfeat.am.module.order.services.domain.service.OrderService;
import com.jfeat.am.module.order.services.domain.service.OrderWelletService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDOrderServiceImpl;
import com.jfeat.am.module.order.services.gen.persistence.dao.ExpressMapper;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderItemMapper;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderMapper;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderProcessLogMapper;
import com.jfeat.am.module.order.services.gen.persistence.model.*;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUD;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.rmi.ServerException;
import java.util.*;
import java.util.stream.Collectors;

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

    @Resource
    ExpressMapper expressMapper;

    @Resource
    ExpressService expressService;

    @Resource
    QueryOrderWalletDao queryOrderWalletDao;

    @Resource
    OrderItemService orderItemService;



    @Override
    public List findOrderPage(QueryWrapper queryWrapper, Page<OrderRecord> page, OrderRecord record,
                              String search, String orderBy, Date startTime, Date startEndTime, Date endTime, Long allianceId, BigDecimal leftMoney, BigDecimal rigthMoney) {
        List recordList = this.queryOrderDao.findOrderPage(queryWrapper,page, record, search, orderBy, startTime,startEndTime, endTime,allianceId,leftMoney,rigthMoney);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }



    @Override
    public OrderModel getOrder(Long id) {
        TOrder tOrder = orderMapper.selectById(id);
        //TOrder TOrder = this.retrieveMaster(id);
        OrderModel orderModel = CRUD.castObject(tOrder, OrderModel.class);
        //拼接省市区
        String detail;
        if(orderModel.getProvince()!=null &&orderModel.getCity()!=null &&orderModel.getDistrict()!=null){
            detail =orderModel.getProvince()+"\n"+orderModel.getCity()+"\n"+orderModel.getDistrict()+"\n"+
                    orderModel.getDetail();
            detail.replaceAll("null","");

        }else{
        detail=orderModel.getDetail();}


        orderModel.setDetail(detail);

        //List<OrderItem> orderItemList = orderItemMapper.selectList(new QueryWrapper<OrderItem>().eq("order_id", id));
        List<OrderItem> orderItemList = orderItemMapper.selectItemList(id);
        orderModel.setOrderItemList(orderItemList);
        List<OrderProcessLog> orderProcessLogList = orderProcessLogMapper.selectList(new QueryWrapper<OrderProcessLog>().eq("order_id", id));
        orderModel.setOrderProcessLogList(orderProcessLogList);

        orderModel.setUserName(queryOrderDao.getUserName(tOrder.getUserId().longValue()));


        //快递单信息
        OrderExpress orderExpress = expressMapper.getOrderExpressByOrderId(id);
        if(orderExpress!=null){
            orderModel.setExpressCode(orderExpress.getExpressCode());
            orderModel.setExpressCompany(orderExpress.getExpressCompany());
            orderModel.setExpressNumber(orderExpress.getExpressNumber());
        }

        return orderModel;
    }

    /**
     * 根据id列表获取多个订单
     * @param ids
     * @return
     */
    @Override
    public List<OrderRecord> listOrder(List<Integer> ids) {
        return queryOrderDao.listOrders(ids);
    }

    //修改订单状态
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

    //新建订单前 划分各个供应商信息 订单信息处理
    @Override
    @Transactional
    public Integer  createOrder(RequestOrder requestOrder) throws ServerException {
        Integer effect = 0;

        List<RequestOrder> orderList = new ArrayList<>();
        Map<Long,List<OrderItemRecord>> itemMap = new HashMap<>();
        if(requestOrder.getItems() != null  &&requestOrder.getItems().size()>0){

            //获取产品信息
            QueryWrapper<FrontProduct> productWrapper = new QueryWrapper<FrontProduct>();
           List<Integer> productIds = new ArrayList();
            for(OrderItemRecord item:requestOrder.getItems()){
                Integer productId = item.getProductId();
                productIds.add(productId);
            }
            List<FrontProduct> productList = frontProductMapper.selectList(productWrapper.in("id", productIds));
            Map<Long, FrontProduct> productMap = productList.stream().collect(Collectors.toMap(i -> i.getId(), j -> j));

            //获取组织信息 初始化map
            for(FrontProduct frontProduct:productList){
                Long orgId = frontProduct.getOrgId();
                List<OrderItemRecord> orderItemRecords = itemMap.get(orgId);
                if(orderItemRecords == null){
                    itemMap.put(orgId,new ArrayList<>());
                }
            }

            //填充map
            for(OrderItemRecord item:requestOrder.getItems()){
                FrontProduct frontProduct = productMap.get(item.getProductId().longValue());
                List<OrderItemRecord> orderItemRecords = itemMap.get(frontProduct.getOrgId());
                orderItemRecords.add(item);
            }

            for(Long key:itemMap.keySet()){
                requestOrder.setOrgId(key);
                //类型转换
                TOrder order = getTOrderBy(requestOrder);
                //设置总价 库存
                setTotal(order,itemMap.get(key),productMap);
                //数据库处理
                effect += createOrderEndless(order, requestOrder.getItems());

                requestOrder.setId(order.getId());
                requestOrder.setOrderNumber(order.getOrderNumber());
            }
                return effect;
        }else{
            throw new BusinessException(BusinessCode.BadRequest,"订单项为空");
        }

    }



    public Integer createOrderEndless(TOrder order,List<OrderItemRecord> productList) throws ServerException {
        Integer res=0;
        //之前是获取名字 现在更改为获取id
        //FrontUser user = queryOrderDao.selectByUserId(userId);
        //订单项不为空 处理订单项
        order.setCreatedDate(new Date());
        if(order.getOrigin() == null){
            order.setOrigin(OrderOriginSetting.DEFAULT_ORIGIN);
        }
        orderMapper.insert(order);
/*            String note = "线上订单";
            if(order.getType()!=null && order.getType().equals(OrderType.ORDER.name())){
                note = "线下订单"   ;
            }*/
        //插入钱包记录数据
        // orderWelletService.insertWelletHistoryByUserId(order.getTotalPrice(),order.getUserId().longValue(), OrderRechargeType.PAYMENT,note);
        // List<OrderItemRecord> productList = requestOrder.getItems();
        for (OrderItemRecord product:productList) {
            product.setOrderId(order.getId().intValue());
            orderItemMapper.insert(product);
        }
        //订单项为空则抛出
        return res;

    }

    @Transactional
   void setTotal(TOrder order,List<OrderItemRecord> productList,Map<Long, FrontProduct> productMap){

        //总价
        BigDecimal finalPrice=new BigDecimal(0);
        for (OrderItemRecord orderItem:productList) {
            FrontProduct frontProduct = productMap.get(orderItem.getProductId().longValue());
            finalPrice = setItemAndProductInfo(orderItem, frontProduct);

        }

        //插入订单
        order.setTotalPrice(finalPrice);
    }

    @Transactional
    TOrder getTOrderBy(RequestOrder requestOrder){
        Long userId = JWTKit.getUserId();
        //订单处理
        TOrder order = new TOrder();
        order.setUserId(userId.intValue());
        order.setPhone(requestOrder.getPhone());
        order.setDetail(requestOrder.getDetail());
        //省市区
        order.setProvince(requestOrder.getProvince());
        order.setCity(requestOrder.getCity());
        order.setDistrict(requestOrder.getDistrict());
        order.setContactUser(requestOrder.getName());
        //支付类型 默认线下支付
        order.setPaymentType("STORE");
        //默认状态 待发货
        order.setStatus(TOrderStatus.CONFIRMED_DELIVER_PENDING);
        //订单类型
        order.setType(requestOrder.getType());
        order.setCreatedDate(requestOrder.getCreateDate());
        order.setCover(requestOrder.getItems().get(0).getCover());
        order.setOrgId(requestOrder.getOrgId());
        Long tenantId = queryOrderDao.getTenantIdByOrgId(requestOrder.getOrgId());
        order.setTenantId(tenantId);
        order.setCategory(requestOrder.getCategory());
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
        return order;
    }

    @Transactional
    BigDecimal setItemAndProductInfo(OrderItemRecord orderItem, FrontProduct product){
        //FrontProduct allianceProduct = queryMomentsFriendDao.queryProductById(product.getId());

        orderItem.setPrice(product.getPrice());
        orderItem.setCover(product.getCover());
        orderItem.setCostPrice(product.getCostPrice());

        Long productId = orderItem.getProductId().longValue();
        //设置订单总价
        //处理产品总价
        if(orderItem.getQuantity() == null){ throw new BusinessException(BusinessCode.BadRequest,"数量不能为空");}
        BigDecimal finalPrice = orderItem.getPrice().multiply(new BigDecimal(orderItem.getQuantity()));
        orderItem.setFinalPrice(finalPrice);
        orderItem.setTotalPrice(finalPrice);
        //finalPrice=orderItem.getTotalPrice().add(finalPrice);
        //查找库存
        // Integer stockBalance = queryMomentsFriendDao.queryStockBalance(productId);
        Integer stockBalance =product.getStockBalance();
        //更改后的库存量
        stockBalance = stockBalance - orderItem.getQuantity();
        if (stockBalance < 0) { throw new BusinessException(BusinessCode.BadRequest, "商品库存不足"); }
        //更新产品库存
        Integer integer = queryOrderDao.upProduct(productId, stockBalance);
        return orderItem.getTotalPrice();
    };



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
                orderItemMapper.selectList(new QueryWrapper<OrderItem>().eq("order_id",order.getId()));
        //总价
        BigDecimal finalPrice=new BigDecimal(0);
        for (OrderItem product:friendOrderItemList) {

            BigDecimal TotalPrice = product.getPrice().multiply(new BigDecimal(product.getQuantity()));
            finalPrice=TotalPrice.add(finalPrice);
            //还原库存
            Integer stockBalance = queryOrderDao.upStockBalance(product.getProductId(),product.getQuantity());

        }

        OrderWallet orderWallet = queryOrderWalletDao.selectWalletByUserId(order.getUserId().longValue());

        if (orderWallet!=null){
            BigDecimal balance = queryOrderDao.queryWalletBalance(order.getUserId().longValue());

            if (balance==null){
                balance=new BigDecimal(0);
            }
            //更新用户余额
            res+=queryOrderDao.upWallet(order.getUserId().longValue(), order.getTotalPrice().add(balance));

            String note = "取消订单 订单号："+order.getOrderNumber();
            //插入钱包记录数据
            res+=orderWelletService.insertWelletHistoryByUserId(order.getTotalPrice(),order.getUserId().longValue(), OrderRechargeType.PAYMENT,note);


        }
        //更新订单
        res+=queryOrderDao.updateById(order);
        return res;
    }


    @Transactional
    @Override
    public Integer deliver(OrderDeliver orderDeliver){
        Integer i = 0;
        //快递公司信息
        Express express = expressMapper.selectById(orderDeliver.getExpressId());
        OrderExpress orderExpress = new OrderExpress();
        orderExpress.setCreateDate(new Date());
        orderExpress.setExpressCode(express.getCode());
        orderExpress.setExpressCompany(express.getName());
        orderExpress.setExpressNumber(orderDeliver.getExpressNumber());
        orderExpress.setMid(1);
        orderExpress.setOrderId(orderDeliver.getId());
        orderExpress.setOrderItems("");

        //插入快递数据
        i += expressMapper.createOrderExpress(orderExpress);
        //更改状态
        i += updateOrderStatus(Long.parseLong(orderDeliver.getId().toString()), OrderStatus.DELIVERED_CONFIRM_PENDING.toString());

        return i;
    }

    @Transactional
    @Override
    public ExpressInfo expressInfo(Long id){
        OrderExpress orderExpress = expressMapper.getOrderExpressByOrderId(id);
        TOrder order = orderMapper.selectById(id);

        if (orderExpress == null) {
           throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE,"快递不存在");
        }

        ExpressInfo expressInfo = expressService.queryExpress(orderExpress.getExpressCode(), orderExpress.getExpressNumber());
        //ExpressInfo expressInfo = ExpressServiceHolder.me().getExpressService().queryExpress();
        if (expressInfo.isSucceed()) {
            return expressInfo;
        }
        throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE,"cannot.find.express.info");

    }


    @Override
    public void setItemsByPages(Page<OrderRecord> page){
        List<OrderRecord> records = page.getRecords();
        List<Long> orderIds = records.stream().map(i -> i.getId()).collect(Collectors.toList());

        if(orderIds != null && orderIds.size()>0){
            QueryWrapper<OrderItem> orderItemWrapper = new QueryWrapper<>();
            List<OrderItem> orderItems = orderItemMapper.selectList(orderItemWrapper.in("order_id",orderIds));

            //组装订单项和订单的关联
            Map<Integer,List<OrderItem>> orderItemMap = new HashMap<>();
            for(OrderItem orderItem:orderItems){
                List<OrderItem> orderItemList = orderItemMap.get(orderItem.getOrderId());
                if(orderItemList == null){
                    orderItemList = new ArrayList<>();
                    orderItemMap.put(orderItem.getOrderId(),orderItemList);
                };

                orderItemList.add(orderItem);
            }


            for(OrderRecord order:records){
                List<OrderItem> orderItems1 = orderItemMap.get(order.getId().intValue());
                order.setOrderItemRecordList(orderItems1);
            }
            
        }

    }

    /**
     * 获取商品已团总数
     *
     * @param productId 商品id
     * @return 已团总数
     */
    @Override
    public int sumQuantityByProductId(Long productId) {
        return queryOrderDao.sumOrderByProductId(productId);
    }

    /**
     * 大匠小程序团购 - 取消订单
     *
     * @param productId
     * @return
     */
    @Transactional
    @Override
    public int cancelOrderByProductId(Long productId) {

        Long userId = JWTKit.getUserId();
        if (userId == null) throw new BusinessException(BusinessCode.UserNotExisted,"未注册");

        return queryOrderDao.updateState(Integer.parseInt(userId.toString()),productId);
    }

    /**
     * 删除订单，order联合order_item一起删除
     *
     * @param id
     * @return 删除总数
     */
    @Transactional
    @Override
    public int deleteOrder(Long id) {
        // 影响行数
        int affected = 0;

        affected += queryOrderDao.deleteById(id);
        if (affected < 1) throw new BusinessException(BusinessCode.DatabaseDeleteError,"删除失败，请确认该记录是否存在");
        return affected;
    }

    /**
     * 查询供应商旗下产品的订单
     *
     * @param page
     * @param supplierId 供应商id
     * @return
     */
    @Override
    public Page<TOrder> listOrdersBySupplier(Page<TOrder> page, Long supplierId) {
        return queryOrderDao.listOrdersBySupplier(page,supplierId);
    }


}
