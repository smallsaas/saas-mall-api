package com.jfeat.am.module.order.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.order.definition.OrderPermission;
import com.jfeat.am.module.order.definition.OrderStatus;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderDao;
import com.jfeat.am.module.order.services.domain.model.OrderRecord;
import com.jfeat.am.module.order.services.domain.model.OrderRequest;
import com.jfeat.am.module.order.services.domain.service.OrderService;
import com.jfeat.am.module.order.services.gen.persistence.model.TOrder;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.rmi.ServerException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-31
 */
@RestController

@Api("Order")
@RequestMapping("/api/crud/order/orders")
public class OrderEndpoint {


    @Resource
    OrderService orderService;

    @Resource
    QueryOrderDao queryOrderDao;

    @BusinessLog(name = "订单", value = "新增线上订单")
    @PostMapping
    @ApiOperation(value = "新建 Order", response = TOrder.class)
    @Permission(OrderPermission.ORDER_ADD)
    public Tip createOrder(@RequestBody TOrder entity) {

        Integer affected = 0;
        try {
            affected = orderService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @BusinessLog(name = "订单", value = "新增线下订单")
    @PostMapping("/storeOrder")
    @ApiOperation(value = "新建 线下订单", response = TOrder.class)
    @Permission(OrderPermission.ORDER_ADD)
    public Tip createStoreOrder(@RequestBody OrderRequest entity) throws ServerException {

        Integer affected = 0;
        try {
            /*    entity.setType("STORE_ORDER");
            affected = orderService.createMaster(entity);
            */

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Order", response = TOrder.class)
    @Permission(OrderPermission.ORDER_VIEW)
    public Tip getOrder(@PathVariable Long id) {

        return SuccessTip.create(orderService.getOrder(id));
    }

    @GetMapping("/allianceOrder/{id}")
    @ApiOperation(value = "查看 团队订单", response = TOrder.class)
    @Permission(OrderPermission.ORDER_VIEW)
    public Tip getAllianceOrder(Page<OrderRecord> page,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                @RequestParam(name = "search", required = false) String search,
                                @PathVariable Long id) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page.setRecords(queryOrderDao.getAllianceOrder(page,id));
        return SuccessTip.create(page);
    }


    @BusinessLog(name = "订单", value = "修改订单")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Order", response = TOrder.class)
    public Tip updateOrder(@PathVariable Long id, @RequestBody TOrder entity) {
        entity.setId(id);
        return SuccessTip.create(orderService.updateMaster(entity));
    }


    @BusinessLog(name = "订单", value = "取消订单")
    @PostMapping("/{id}/{orderStatus}")
    @ApiOperation(value = "取消 Order", response = TOrder.class)
    public Tip updateOrderStatus(@PathVariable Long id, @PathVariable String orderStatus) {
        try {
            //不报错，orderStatus参数正确
            OrderStatus.valueOf(orderStatus);
            return SuccessTip.create(orderService.updateOrderStatus(id,orderStatus));
        }catch (Exception e){
            throw new BusinessException(BusinessCode.BadRequest);
        }
    }

    @BusinessLog(name = "订单", value = "删除订单")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Order")
    @Permission(OrderPermission.ORDER_DEL)
    public Tip deleteOrder(@PathVariable Long id) {
        return SuccessTip.create(orderService.deleteMaster(id));
    }

    @ApiOperation(value = "Order 列表信息", response = OrderRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "userId", dataType = "Integer"),
            @ApiImplicitParam(name = "orderNumber", dataType = "String"),
            @ApiImplicitParam(name = "tradeNumber", dataType = "String"),
            @ApiImplicitParam(name = "paymentType", dataType = "String"),
            @ApiImplicitParam(name = "createdDate", dataType = "Date"),
            @ApiImplicitParam(name = "payDate", dataType = "Date"),
            @ApiImplicitParam(name = "confirmDate", dataType = "Date"),
            @ApiImplicitParam(name = "deliverDate", dataType = "Date"),
            @ApiImplicitParam(name = "deliveredDate", dataType = "Date"),
            @ApiImplicitParam(name = "dealDate", dataType = "Date"),
            @ApiImplicitParam(name = "deliverOrderNumber", dataType = "String"),
            @ApiImplicitParam(name = "status", dataType = "String"),
            @ApiImplicitParam(name = "totalPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "freight", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "description", dataType = "String"),
            @ApiImplicitParam(name = "remark", dataType = "String"),
            @ApiImplicitParam(name = "invoice", dataType = "Integer"),
            @ApiImplicitParam(name = "invoiceTitle", dataType = "String"),
            @ApiImplicitParam(name = "receivingTime", dataType = "String"),
            @ApiImplicitParam(name = "zip", dataType = "String"),
            @ApiImplicitParam(name = "contactUser", dataType = "String"),
            @ApiImplicitParam(name = "phone", dataType = "String"),
            @ApiImplicitParam(name = "province", dataType = "String"),
            @ApiImplicitParam(name = "city", dataType = "String"),
            @ApiImplicitParam(name = "district", dataType = "String"),
            @ApiImplicitParam(name = "street", dataType = "String"),
            @ApiImplicitParam(name = "detail", dataType = "String"),
            @ApiImplicitParam(name = "cover", dataType = "String"),
            @ApiImplicitParam(name = "expressNumber", dataType = "String"),
            @ApiImplicitParam(name = "expressCompany", dataType = "String"),
            @ApiImplicitParam(name = "expressCode", dataType = "String"),
            @ApiImplicitParam(name = "settled", dataType = "Integer"),
            @ApiImplicitParam(name = "previousStatus", dataType = "String"),
            @ApiImplicitParam(name = "isDeliverReminder", dataType = "Integer"),
            @ApiImplicitParam(name = "isDeleted", dataType = "Integer"),
            @ApiImplicitParam(name = "pointExchangeRate", dataType = "Integer"),
            @ApiImplicitParam(name = "couponInfo", dataType = "String"),
            @ApiImplicitParam(name = "marketing", dataType = "String"),
            @ApiImplicitParam(name = "marketingId", dataType = "Integer"),
            @ApiImplicitParam(name = "marketingDescription", dataType = "String"),
            @ApiImplicitParam(name = "mid", dataType = "Integer"),
            @ApiImplicitParam(name = "mname", dataType = "String"),
            @ApiImplicitParam(name = "storeId", dataType = "String"),
            @ApiImplicitParam(name = "storeName", dataType = "String"),
            @ApiImplicitParam(name = "storeUserId", dataType = "String"),
            @ApiImplicitParam(name = "storeUserName", dataType = "String"),
            @ApiImplicitParam(name = "type", dataType = "String"),
            @ApiImplicitParam(name = "payCredit", dataType = "Integer"),
            @ApiImplicitParam(name = "deliveryType", dataType = "String"),
            @ApiImplicitParam(name = "origin", dataType = "String"),
            @ApiImplicitParam(name = "storeUserCode", dataType = "String"),
            @ApiImplicitParam(name = "storeCode", dataType = "String"),
            @ApiImplicitParam(name = "storeCover", dataType = "String"),
            @ApiImplicitParam(name = "store_guideUserId", dataType = "String"),
            @ApiImplicitParam(name = "store_guideUserCode", dataType = "String"),
            @ApiImplicitParam(name = "store_guideUserName", dataType = "String"),
            @ApiImplicitParam(name = "inviterUserId", dataType = "String"),
            @ApiImplicitParam(name = "inviterUserName", dataType = "String"),
            @ApiImplicitParam(name = "followedStoreId", dataType = "String"),
            @ApiImplicitParam(name = "followedStoreCode", dataType = "String"),
            @ApiImplicitParam(name = "followedStoreName", dataType = "String"),
            @ApiImplicitParam(name = "followedStoreCover", dataType = "String"),
            @ApiImplicitParam(name = "commentId", dataType = "String"),
            @ApiImplicitParam(name = "bindingStoreId", dataType = "String"),
            @ApiImplicitParam(name = "bindingStoreCode", dataType = "String"),
            @ApiImplicitParam(name = "bindingStoreName", dataType = "String"),
            @ApiImplicitParam(name = "bindingStoreCover", dataType = "String"),
            @ApiImplicitParam(name = "refundFee", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "storeAddress", dataType = "String"),
            @ApiImplicitParam(name = "supplementaryFee", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "originPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "couponPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "creditPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "extCouponId", dataType = "String"),
            @ApiImplicitParam(name = "extUserType", dataType = "String"),
            @ApiImplicitParam(name = "extCouponType", dataType = "String"),
            @ApiImplicitParam(name = "extDiscount", dataType = "Integer"),
            @ApiImplicitParam(name = "extCuts", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    @Permission(OrderPermission.ORDER_VIEW)
    public Tip queryOrders(Page<OrderRecord> page,
                           @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                           @RequestParam(name = "search", required = false) String search,
                           @RequestParam(name = "id", required = false) Long id,
                           @RequestParam(name = "userId", required = false) Integer userId,
                           @RequestParam(name = "orderNumber", required = false) String orderNumber,
                           @RequestParam(name = "tradeNumber", required = false) String tradeNumber,
                           @RequestParam(name = "paymentType", required = false) String paymentType,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date createdDate,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date payDate,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date confirmDate,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date deliverDate,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date deliveredDate,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dealDate,
                           @RequestParam(name = "deliverOrderNumber", required = false) String deliverOrderNumber,
                           @RequestParam(name = "status", required = false) String status,
                           @RequestParam(name = "totalPrice", required = false) BigDecimal totalPrice,
                           @RequestParam(name = "freight", required = false) BigDecimal freight,
                           @RequestParam(name = "description", required = false) String description,
                           @RequestParam(name = "remark", required = false) String remark,
                           @RequestParam(name = "invoice", required = false) Integer invoice,
                           @RequestParam(name = "invoiceTitle", required = false) String invoiceTitle,
                           @RequestParam(name = "receivingTime", required = false) String receivingTime,
                           @RequestParam(name = "zip", required = false) String zip,
                           @RequestParam(name = "contactUser", required = false) String contactUser,
                           @RequestParam(name = "phone", required = false) String phone,
                           @RequestParam(name = "province", required = false) String province,
                           @RequestParam(name = "city", required = false) String city,
                           @RequestParam(name = "district", required = false) String district,
                           @RequestParam(name = "street", required = false) String street,
                           @RequestParam(name = "detail", required = false) String detail,
                           @RequestParam(name = "cover", required = false) String cover,
                           @RequestParam(name = "expressNumber", required = false) String expressNumber,
                           @RequestParam(name = "expressCompany", required = false) String expressCompany,
                           @RequestParam(name = "expressCode", required = false) String expressCode,
                           @RequestParam(name = "settled", required = false) Integer settled,
                           @RequestParam(name = "previousStatus", required = false) String previousStatus,
                           @RequestParam(name = "isDeliverReminder", required = false) Integer isDeliverReminder,
                           @RequestParam(name = "isDeleted", required = false) Integer isDeleted,
                           @RequestParam(name = "pointExchangeRate", required = false) Integer pointExchangeRate,
                           @RequestParam(name = "couponInfo", required = false) String couponInfo,
                           @RequestParam(name = "marketing", required = false) String marketing,
                           @RequestParam(name = "marketingId", required = false) Integer marketingId,
                           @RequestParam(name = "marketingDescription", required = false) String marketingDescription,
                           @RequestParam(name = "mid", required = false) Integer mid,
                           @RequestParam(name = "mname", required = false) String mname,
                           @RequestParam(name = "storeId", required = false) String storeId,
                           @RequestParam(name = "storeName", required = false) String storeName,
                           @RequestParam(name = "storeUserId", required = false) String storeUserId,
                           @RequestParam(name = "storeUserName", required = false) String storeUserName,
                           @RequestParam(name = "type", required = false) String type,
                           @RequestParam(name = "payCredit", required = false) Integer payCredit,
                           @RequestParam(name = "deliveryType", required = false) String deliveryType,
                           @RequestParam(name = "origin", required = false) String origin,
                           @RequestParam(name = "storeUserCode", required = false) String storeUserCode,
                           @RequestParam(name = "storeCode", required = false) String storeCode,
                           @RequestParam(name = "storeCover", required = false) String storeCover,
                           @RequestParam(name = "storeGuideUserId", required = false) String storeGuideUserId,
                           @RequestParam(name = "storeGuideUserCode", required = false) String storeGuideUserCode,
                           @RequestParam(name = "storeGuideUserName", required = false) String storeGuideUserName,
                           @RequestParam(name = "inviterUserId", required = false) String inviterUserId,
                           @RequestParam(name = "inviterUserName", required = false) String inviterUserName,
                           @RequestParam(name = "followedStoreId", required = false) String followedStoreId,
                           @RequestParam(name = "followedStoreCode", required = false) String followedStoreCode,
                           @RequestParam(name = "followedStoreName", required = false) String followedStoreName,
                           @RequestParam(name = "followedStoreCover", required = false) String followedStoreCover,
                           @RequestParam(name = "commentId", required = false) String commentId,
                           @RequestParam(name = "bindingStoreId", required = false) String bindingStoreId,
                           @RequestParam(name = "bindingStoreCode", required = false) String bindingStoreCode,
                           @RequestParam(name = "bindingStoreName", required = false) String bindingStoreName,
                           @RequestParam(name = "bindingStoreCover", required = false) String bindingStoreCover,
                           @RequestParam(name = "refundFee", required = false) BigDecimal refundFee,
                           @RequestParam(name = "storeAddress", required = false) String storeAddress,
                           @RequestParam(name = "supplementaryFee", required = false) BigDecimal supplementaryFee,
                           @RequestParam(name = "originPrice", required = false) BigDecimal originPrice,
                           @RequestParam(name = "couponPrice", required = false) BigDecimal couponPrice,
                           @RequestParam(name = "creditPrice", required = false) BigDecimal creditPrice,
                           @RequestParam(name = "extCouponId", required = false) String extCouponId,
                           @RequestParam(name = "extUserType", required = false) String extUserType,
                           @RequestParam(name = "extCouponType", required = false) String extCouponType,
                           @RequestParam(name = "extDiscount", required = false) Integer extDiscount,
                           @RequestParam(name = "extCuts", required = false) Integer extCuts,
                           @RequestParam(name = "orgId", required = false) Long orgId,
                           @RequestParam(name = "allianceId", required = false) Long allianceId,
                           @RequestParam(name = "orderBy", required = false) String orderBy,
                           @RequestParam(name = "sort", required = false) String sort,
                           @RequestParam(name = "pName", required = false) String pName,
                           @RequestParam(name = "barcode", required = false) String barcode,
                           @RequestParam(name = "thisMonth", required = false) String thisMonth,
                           @RequestParam(name = "searchMoney", required = false) BigDecimal searchMoney[],
     @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date time[] )
                           {
        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        Date startTime = time!=null? (time.length > 0?time[0]:null) : null;
        Date endTime = time!=null ? (time.length==2?time[1]:(time.length==1?time[0]:null)) : null;

        BigDecimal leftMoney = searchMoney!=null? (searchMoney.length > 0?searchMoney[0]:null) : null;
        BigDecimal rightMoney = searchMoney!=null ? (searchMoney.length==2?searchMoney[1]:(searchMoney.length==1?searchMoney[0]:null)) : null;



        Date startEndTime=null;
       //设置当月1号
        /*if(allianceId!=null&&thisMonth!=null&&thisMonth!=""){

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);

            startTime=calendar.getTime();
            calendar.add(Calendar.MONTH, 1);
            startEndTime=calendar.getTime();

        }*/


        OrderRecord record = new OrderRecord();
        record.setBarcode(barcode);
        record.setpName(pName);
        record.setId(id);
        record.setUserId(userId);
        record.setOrderNumber(orderNumber);
        record.setTradeNumber(tradeNumber);
        record.setPaymentType(paymentType);
        record.setCreatedDate(createdDate);
        record.setPayDate(payDate);
        record.setConfirmDate(confirmDate);
        record.setDeliverDate(deliverDate);
        record.setDeliveredDate(deliveredDate);
        record.setDealDate(dealDate);
        record.setDeliverOrderNumber(deliverOrderNumber);


        record.setStatus(status);

        record.setTotalPrice(totalPrice);
        record.setFreight(freight);
        record.setDescription(description);
        record.setRemark(remark);
        record.setInvoice(invoice);
        record.setInvoiceTitle(invoiceTitle);
        record.setReceivingTime(receivingTime);
        record.setZip(zip);
        record.setContactUser(contactUser);
        record.setPhone(phone);
        record.setProvince(province);
        record.setCity(city);
        record.setDistrict(district);
        record.setStreet(street);
        record.setDetail(detail);
        record.setCover(cover);
        record.setExpressNumber(expressNumber);
        record.setExpressCompany(expressCompany);
        record.setExpressCode(expressCode);
        record.setSettled(settled);
        record.setPreviousStatus(previousStatus);
        record.setIsDeliverReminder(isDeliverReminder);
        record.setIsDeleted(isDeleted);
        record.setPointExchangeRate(pointExchangeRate);
        record.setCouponInfo(couponInfo);
        record.setMarketing(marketing);
        record.setMarketingId(marketingId);
        record.setMarketingDescription(marketingDescription);
        record.setMid(mid);
        record.setMname(mname);
        record.setStoreId(storeId);
        record.setStoreName(storeName);
        record.setStoreUserId(storeUserId);
        record.setStoreUserName(storeUserName);
        record.setType(type);
        record.setPayCredit(payCredit);
        record.setDeliveryType(deliveryType);
        record.setOrigin(origin);
        record.setStoreUserCode(storeUserCode);
        record.setStoreCode(storeCode);
        record.setStoreCover(storeCover);
        record.setStoreGuideUserId(storeGuideUserId);
        record.setStoreGuideUserCode(storeGuideUserCode);
        record.setStoreGuideUserName(storeGuideUserName);
        record.setInviterUserId(inviterUserId);
        record.setInviterUserName(inviterUserName);
        record.setFollowedStoreId(followedStoreId);
        record.setFollowedStoreCode(followedStoreCode);
        record.setFollowedStoreName(followedStoreName);
        record.setFollowedStoreCover(followedStoreCover);
        record.setCommentId(commentId);
        record.setBindingStoreId(bindingStoreId);
        record.setBindingStoreCode(bindingStoreCode);
        record.setBindingStoreName(bindingStoreName);
        record.setBindingStoreCover(bindingStoreCover);
        record.setRefundFee(refundFee);
        record.setStoreAddress(storeAddress);
        record.setSupplementaryFee(supplementaryFee);
        record.setOriginPrice(originPrice);
        record.setCouponPrice(couponPrice);
        record.setCreditPrice(creditPrice);
        record.setExtCouponId(extCouponId);
        record.setExtUserType(extUserType);
        record.setExtCouponType(extCouponType);
        record.setExtDiscount(extDiscount);
        record.setExtCuts(extCuts);
        record.setOrgId(orgId);

        page.setRecords(queryOrderDao.findOrderPage(
                page, record, search, orderBy, startTime,startEndTime, endTime,allianceId
        ,leftMoney,rightMoney));

        return SuccessTip.create(page);
    }



    @ApiOperation(value = "订单结算", response = OrderRecord.class)
    @GetMapping("/settlement")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "userId", dataType = "Integer"),
            @ApiImplicitParam(name = "orderNumber", dataType = "String"),
            @ApiImplicitParam(name = "tradeNumber", dataType = "String"),
            @ApiImplicitParam(name = "paymentType", dataType = "String"),
            @ApiImplicitParam(name = "createdDate", dataType = "Date"),
            @ApiImplicitParam(name = "payDate", dataType = "Date"),
            @ApiImplicitParam(name = "confirmDate", dataType = "Date"),
            @ApiImplicitParam(name = "deliverDate", dataType = "Date"),
            @ApiImplicitParam(name = "deliveredDate", dataType = "Date"),
            @ApiImplicitParam(name = "dealDate", dataType = "Date"),
            @ApiImplicitParam(name = "deliverOrderNumber", dataType = "String"),
            @ApiImplicitParam(name = "status", dataType = "String"),
            @ApiImplicitParam(name = "totalPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "freight", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "description", dataType = "String"),
            @ApiImplicitParam(name = "remark", dataType = "String"),
            @ApiImplicitParam(name = "invoice", dataType = "Integer"),
            @ApiImplicitParam(name = "invoiceTitle", dataType = "String"),
            @ApiImplicitParam(name = "receivingTime", dataType = "String"),
            @ApiImplicitParam(name = "zip", dataType = "String"),
            @ApiImplicitParam(name = "contactUser", dataType = "String"),
            @ApiImplicitParam(name = "phone", dataType = "String"),
            @ApiImplicitParam(name = "province", dataType = "String"),
            @ApiImplicitParam(name = "city", dataType = "String"),
            @ApiImplicitParam(name = "district", dataType = "String"),
            @ApiImplicitParam(name = "street", dataType = "String"),
            @ApiImplicitParam(name = "detail", dataType = "String"),
            @ApiImplicitParam(name = "cover", dataType = "String"),
            @ApiImplicitParam(name = "expressNumber", dataType = "String"),
            @ApiImplicitParam(name = "expressCompany", dataType = "String"),
            @ApiImplicitParam(name = "expressCode", dataType = "String"),
            @ApiImplicitParam(name = "settled", dataType = "Integer"),
            @ApiImplicitParam(name = "previousStatus", dataType = "String"),
            @ApiImplicitParam(name = "isDeliverReminder", dataType = "Integer"),
            @ApiImplicitParam(name = "isDeleted", dataType = "Integer"),
            @ApiImplicitParam(name = "pointExchangeRate", dataType = "Integer"),
            @ApiImplicitParam(name = "couponInfo", dataType = "String"),
            @ApiImplicitParam(name = "marketing", dataType = "String"),
            @ApiImplicitParam(name = "marketingId", dataType = "Integer"),
            @ApiImplicitParam(name = "marketingDescription", dataType = "String"),
            @ApiImplicitParam(name = "mid", dataType = "Integer"),
            @ApiImplicitParam(name = "mname", dataType = "String"),
            @ApiImplicitParam(name = "storeId", dataType = "String"),
            @ApiImplicitParam(name = "storeName", dataType = "String"),
            @ApiImplicitParam(name = "storeUserId", dataType = "String"),
            @ApiImplicitParam(name = "storeUserName", dataType = "String"),
            @ApiImplicitParam(name = "type", dataType = "String"),
            @ApiImplicitParam(name = "payCredit", dataType = "Integer"),
            @ApiImplicitParam(name = "deliveryType", dataType = "String"),
            @ApiImplicitParam(name = "origin", dataType = "String"),
            @ApiImplicitParam(name = "storeUserCode", dataType = "String"),
            @ApiImplicitParam(name = "storeCode", dataType = "String"),
            @ApiImplicitParam(name = "storeCover", dataType = "String"),
            @ApiImplicitParam(name = "store_guideUserId", dataType = "String"),
            @ApiImplicitParam(name = "store_guideUserCode", dataType = "String"),
            @ApiImplicitParam(name = "store_guideUserName", dataType = "String"),
            @ApiImplicitParam(name = "inviterUserId", dataType = "String"),
            @ApiImplicitParam(name = "inviterUserName", dataType = "String"),
            @ApiImplicitParam(name = "followedStoreId", dataType = "String"),
            @ApiImplicitParam(name = "followedStoreCode", dataType = "String"),
            @ApiImplicitParam(name = "followedStoreName", dataType = "String"),
            @ApiImplicitParam(name = "followedStoreCover", dataType = "String"),
            @ApiImplicitParam(name = "commentId", dataType = "String"),
            @ApiImplicitParam(name = "bindingStoreId", dataType = "String"),
            @ApiImplicitParam(name = "bindingStoreCode", dataType = "String"),
            @ApiImplicitParam(name = "bindingStoreName", dataType = "String"),
            @ApiImplicitParam(name = "bindingStoreCover", dataType = "String"),
            @ApiImplicitParam(name = "refundFee", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "storeAddress", dataType = "String"),
            @ApiImplicitParam(name = "supplementaryFee", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "originPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "couponPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "creditPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "extCouponId", dataType = "String"),
            @ApiImplicitParam(name = "extUserType", dataType = "String"),
            @ApiImplicitParam(name = "extCouponType", dataType = "String"),
            @ApiImplicitParam(name = "extDiscount", dataType = "Integer"),
            @ApiImplicitParam(name = "extCuts", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    @Permission(OrderPermission.ORDER_VIEW)
    public Tip settlementOrder(Page<OrderRecord> page,
                           @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                           @RequestParam(name = "search", required = false) String search,
                           @RequestParam(name = "id", required = false) Long id,
                           @RequestParam(name = "userId", required = false) Integer userId,
                           @RequestParam(name = "orderNumber", required = false) String orderNumber,
                           @RequestParam(name = "tradeNumber", required = false) String tradeNumber,
                           @RequestParam(name = "paymentType", required = false) String paymentType,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date createdDate,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date payDate,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date confirmDate,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date deliverDate,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date deliveredDate,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dealDate,
                           @RequestParam(name = "deliverOrderNumber", required = false) String deliverOrderNumber,
                           @RequestParam(name = "status", required = false) String status,
                           @RequestParam(name = "totalPrice", required = false) BigDecimal totalPrice,
                           @RequestParam(name = "freight", required = false) BigDecimal freight,
                           @RequestParam(name = "description", required = false) String description,
                           @RequestParam(name = "remark", required = false) String remark,
                           @RequestParam(name = "invoice", required = false) Integer invoice,
                           @RequestParam(name = "invoiceTitle", required = false) String invoiceTitle,
                           @RequestParam(name = "receivingTime", required = false) String receivingTime,
                           @RequestParam(name = "zip", required = false) String zip,
                           @RequestParam(name = "contactUser", required = false) String contactUser,
                           @RequestParam(name = "phone", required = false) String phone,
                           @RequestParam(name = "province", required = false) String province,
                           @RequestParam(name = "city", required = false) String city,
                           @RequestParam(name = "district", required = false) String district,
                           @RequestParam(name = "street", required = false) String street,
                           @RequestParam(name = "detail", required = false) String detail,
                           @RequestParam(name = "cover", required = false) String cover,
                           @RequestParam(name = "expressNumber", required = false) String expressNumber,
                           @RequestParam(name = "expressCompany", required = false) String expressCompany,
                           @RequestParam(name = "expressCode", required = false) String expressCode,
                           @RequestParam(name = "settled", required = false) Integer settled,
                           @RequestParam(name = "previousStatus", required = false) String previousStatus,
                           @RequestParam(name = "isDeliverReminder", required = false) Integer isDeliverReminder,
                           @RequestParam(name = "isDeleted", required = false) Integer isDeleted,
                           @RequestParam(name = "pointExchangeRate", required = false) Integer pointExchangeRate,
                           @RequestParam(name = "couponInfo", required = false) String couponInfo,
                           @RequestParam(name = "marketing", required = false) String marketing,
                           @RequestParam(name = "marketingId", required = false) Integer marketingId,
                           @RequestParam(name = "marketingDescription", required = false) String marketingDescription,
                           @RequestParam(name = "mid", required = false) Integer mid,
                           @RequestParam(name = "mname", required = false) String mname,
                           @RequestParam(name = "storeId", required = false) String storeId,
                           @RequestParam(name = "storeName", required = false) String storeName,
                           @RequestParam(name = "storeUserId", required = false) String storeUserId,
                           @RequestParam(name = "storeUserName", required = false) String storeUserName,
                           @RequestParam(name = "type", required = false) String type,
                           @RequestParam(name = "payCredit", required = false) Integer payCredit,
                           @RequestParam(name = "deliveryType", required = false) String deliveryType,
                           @RequestParam(name = "origin", required = false) String origin,
                           @RequestParam(name = "storeUserCode", required = false) String storeUserCode,
                           @RequestParam(name = "storeCode", required = false) String storeCode,
                           @RequestParam(name = "storeCover", required = false) String storeCover,
                           @RequestParam(name = "storeGuideUserId", required = false) String storeGuideUserId,
                           @RequestParam(name = "storeGuideUserCode", required = false) String storeGuideUserCode,
                           @RequestParam(name = "storeGuideUserName", required = false) String storeGuideUserName,
                           @RequestParam(name = "inviterUserId", required = false) String inviterUserId,
                           @RequestParam(name = "inviterUserName", required = false) String inviterUserName,
                           @RequestParam(name = "followedStoreId", required = false) String followedStoreId,
                           @RequestParam(name = "followedStoreCode", required = false) String followedStoreCode,
                           @RequestParam(name = "followedStoreName", required = false) String followedStoreName,
                           @RequestParam(name = "followedStoreCover", required = false) String followedStoreCover,
                           @RequestParam(name = "commentId", required = false) String commentId,
                           @RequestParam(name = "bindingStoreId", required = false) String bindingStoreId,
                           @RequestParam(name = "bindingStoreCode", required = false) String bindingStoreCode,
                           @RequestParam(name = "bindingStoreName", required = false) String bindingStoreName,
                           @RequestParam(name = "bindingStoreCover", required = false) String bindingStoreCover,
                           @RequestParam(name = "refundFee", required = false) BigDecimal refundFee,
                           @RequestParam(name = "storeAddress", required = false) String storeAddress,
                           @RequestParam(name = "supplementaryFee", required = false) BigDecimal supplementaryFee,
                           @RequestParam(name = "originPrice", required = false) BigDecimal originPrice,
                           @RequestParam(name = "couponPrice", required = false) BigDecimal couponPrice,
                           @RequestParam(name = "creditPrice", required = false) BigDecimal creditPrice,
                           @RequestParam(name = "extCouponId", required = false) String extCouponId,
                           @RequestParam(name = "extUserType", required = false) String extUserType,
                           @RequestParam(name = "extCouponType", required = false) String extCouponType,
                           @RequestParam(name = "extDiscount", required = false) Integer extDiscount,
                           @RequestParam(name = "extCuts", required = false) Integer extCuts,
                           @RequestParam(name = "orgId", required = false) Long orgId,
                           @RequestParam(name = "allianceId", required = false) Long allianceId,
                           @RequestParam(name = "orderBy", required = false) String orderBy,
                           @RequestParam(name = "sort", required = false) String sort,
                           @RequestParam(name = "pName", required = false) String pName,
                           @RequestParam(name = "barcode", required = false) String barcode,
                           @RequestParam(name = "thisMonth", required = false) String thisMonth,
                           @RequestParam(name = "settlementStatus", required = false) Integer settlementStatus,
                               @RequestParam(name = "userName", required = false) String userName,
                               @RequestParam(name = "searchMoney", required = false) BigDecimal searchMoney[],
                           @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date time[]


    )
    {
        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        Date startTime = time!=null? (time.length > 0?time[0]:null) : null;
        Date endTime = time!=null ? (time.length==2?time[1]:(time.length==1?time[0]:null)) : null;

        BigDecimal leftMoney = searchMoney!=null? (searchMoney.length > 0?searchMoney[0]:null) : null;
        BigDecimal rightMoney = searchMoney!=null ? (searchMoney.length==2?searchMoney[1]:(searchMoney.length==1?searchMoney[0]:null)) : null;


        Date startEndTime=null;
        //设置当月1号
       /* if(userId!=null&&thisMonth!=null&&thisMonth!=""){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            startTime=calendar.getTime();
            //+1月 放入结束时间
            calendar.add(Calendar.MONTH, 1);
            startEndTime=calendar.getTime(); }*/

        status="CLOSED_CONFIRMED";

        OrderRecord record = new OrderRecord();
        record.setBarcode(barcode);
        record.setpName(pName);
        record.setId(id);
        record.setUserId(userId);
        record.setOrderNumber(orderNumber);
        record.setTradeNumber(tradeNumber);
        record.setPaymentType(paymentType);
        record.setCreatedDate(createdDate);
        record.setPayDate(payDate);
        record.setConfirmDate(confirmDate);
        record.setDeliverDate(deliverDate);
        record.setDeliveredDate(deliveredDate);
        record.setDealDate(dealDate);
        record.setDeliverOrderNumber(deliverOrderNumber);
        record.setStatus(status);
        record.setTotalPrice(totalPrice);
        record.setFreight(freight);
        record.setDescription(description);
        record.setRemark(remark);
        record.setInvoice(invoice);
        record.setInvoiceTitle(invoiceTitle);
        record.setReceivingTime(receivingTime);
        record.setZip(zip);
        record.setContactUser(contactUser);
        record.setPhone(phone);
        record.setProvince(province);
        record.setCity(city);
        record.setDistrict(district);
        record.setStreet(street);
        record.setDetail(detail);
        record.setCover(cover);
        record.setExpressNumber(expressNumber);
        record.setExpressCompany(expressCompany);
        record.setExpressCode(expressCode);
        record.setSettled(settled);
        record.setPreviousStatus(previousStatus);
        record.setIsDeliverReminder(isDeliverReminder);
        record.setIsDeleted(isDeleted);
        record.setPointExchangeRate(pointExchangeRate);
        record.setCouponInfo(couponInfo);
        record.setMarketing(marketing);
        record.setMarketingId(marketingId);
        record.setMarketingDescription(marketingDescription);
        record.setMid(mid);
        record.setMname(mname);
        record.setStoreId(storeId);
        record.setStoreName(storeName);
        record.setStoreUserId(storeUserId);
        record.setStoreUserName(storeUserName);
        record.setType(type);
        record.setPayCredit(payCredit);
        record.setDeliveryType(deliveryType);
        record.setOrigin(origin);
        record.setStoreUserCode(storeUserCode);
        record.setStoreCode(storeCode);
        record.setStoreCover(storeCover);
        record.setStoreGuideUserId(storeGuideUserId);
        record.setStoreGuideUserCode(storeGuideUserCode);
        record.setStoreGuideUserName(storeGuideUserName);
        record.setInviterUserId(inviterUserId);
        record.setInviterUserName(inviterUserName);
        record.setFollowedStoreId(followedStoreId);
        record.setFollowedStoreCode(followedStoreCode);
        record.setFollowedStoreName(followedStoreName);
        record.setFollowedStoreCover(followedStoreCover);
        record.setCommentId(commentId);
        record.setBindingStoreId(bindingStoreId);
        record.setBindingStoreCode(bindingStoreCode);
        record.setBindingStoreName(bindingStoreName);
        record.setBindingStoreCover(bindingStoreCover);
        record.setRefundFee(refundFee);
        record.setStoreAddress(storeAddress);
        record.setSupplementaryFee(supplementaryFee);
        record.setOriginPrice(originPrice);
        record.setCouponPrice(couponPrice);
        record.setCreditPrice(creditPrice);
        record.setExtCouponId(extCouponId);
        record.setExtUserType(extUserType);
        record.setExtCouponType(extCouponType);
        record.setExtDiscount(extDiscount);
        record.setExtCuts(extCuts);
        record.setOrgId(orgId);
        record.setSettlementStatus(settlementStatus);

        List<OrderRecord> orderRecordList=queryOrderDao
                .settlementOrder(page, record, search, orderBy, startTime,startEndTime,
                        endTime,allianceId,userName,leftMoney,rightMoney);

        page.setRecords(orderRecordList);

        return SuccessTip.create(page);
    }





    @ApiOperation(value = "退货 列表信息", response = OrderRecord.class)
    @GetMapping("/refunds")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "status", dataType = "String"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    @Permission(OrderPermission.ORDER_VIEW)
    public Tip queryOrders(Page<OrderRecord> page,
                           @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                           @RequestParam(name = "search", required = false) String search,
                           @RequestParam(name = "orderBy", required = false) String orderBy,
                           @RequestParam(name = "status", required = false) String status,
                           @RequestParam(name = "sort", required = false) String sort,
                           @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date time[]
    )
    {
        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        Date startTime = time!=null? (time.length > 0?time[0]:null) : null;
        Date endTime = time!=null ? (time.length==2?time[1]:(time.length==1?time[0]:null)) : null;


        page.setRecords(queryOrderDao.refundOrderPage(page, status, search, orderBy, startTime, endTime));

        return SuccessTip.create(page);
    }

    public static void main(String[] args) {
        String orderStatus = "CREATED_PAY_PENDING";

        OrderStatus existOrderStatus = OrderStatus.valueOf(orderStatus);
        System.out.println(existOrderStatus);
    }
}
