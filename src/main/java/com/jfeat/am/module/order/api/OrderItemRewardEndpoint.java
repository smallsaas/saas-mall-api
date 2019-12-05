package com.jfeat.am.module.order.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.model.OrderItemRewardRecord;
import com.jfeat.am.module.order.services.domain.service.OrderItemRewardService;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItemReward;
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
import java.util.Date;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-31
 */
@RestController

@Api("OrderItemReward")
@RequestMapping("/api/crud/order/orderItemRewards")
public class OrderItemRewardEndpoint {


    @Resource
    OrderItemRewardService orderItemRewardService;

    @PostMapping
    @ApiOperation(value = "新建 OrderItemReward", response = OrderItemReward.class)
    public Tip createOrderItemReward(@RequestBody OrderItemReward entity) {

        Integer affected = 0;
        try {
            affected = orderItemRewardService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 OrderItemReward", response = OrderItemReward.class)
    public Tip getOrderItemReward(@PathVariable Long id) {
        return SuccessTip.create(orderItemRewardService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 OrderItemReward", response = OrderItemReward.class)
    public Tip updateOrderItemReward(@PathVariable Long id, @RequestBody OrderItemReward entity) {
        entity.setId(id);
        return SuccessTip.create(orderItemRewardService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 OrderItemReward")
    public Tip deleteOrderItemReward(@PathVariable Long id) {
        return SuccessTip.create(orderItemRewardService.deleteMaster(id));
    }

    @ApiOperation(value = "OrderItemReward 列表信息", response = OrderItemRewardRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", dataType = "Integer"),
            @ApiImplicitParam(name = "orderNumber", dataType = "String"),
            @ApiImplicitParam(name = "orderTotalPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "orderCreatedTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderPaidTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderItemId", dataType = "Integer"),
            @ApiImplicitParam(name = "orderProfit", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "percent", dataType = "Integer"),
            @ApiImplicitParam(name = "reward", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "ownerId", dataType = "Integer"),
            @ApiImplicitParam(name = "level", dataType = "Integer"),
            @ApiImplicitParam(name = "state", dataType = "String"),
            @ApiImplicitParam(name = "type", dataType = "String"),
            @ApiImplicitParam(name = "createdTime", dataType = "Date"),
            @ApiImplicitParam(name = "settledTime", dataType = "Date"),
            @ApiImplicitParam(name = "withdrawnTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderUserName", dataType = "String"),
            @ApiImplicitParam(name = "paymentType", dataType = "String"),
            @ApiImplicitParam(name = "pointExchangeRate", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryOrderItemRewards(Page<OrderItemRewardRecord> page,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(name = "search", required = false) String search,
                                     @RequestParam(name = "id", required = false) Long id,
                                     @RequestParam(name = "orderId", required = false) Integer orderId,
                                     @RequestParam(name = "orderNumber", required = false) String orderNumber,
                                     @RequestParam(name = "orderTotalPrice", required = false) BigDecimal orderTotalPrice,
                                     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date orderCreatedTime,
                                     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date orderPaidTime,
                                     @RequestParam(name = "orderItemId", required = false) Integer orderItemId,
                                     @RequestParam(name = "orderProfit", required = false) BigDecimal orderProfit,
                                     @RequestParam(name = "percent", required = false) Integer percent,
                                     @RequestParam(name = "reward", required = false) BigDecimal reward,
                                     @RequestParam(name = "ownerId", required = false) Integer ownerId,
                                     @RequestParam(name = "level", required = false) Integer level,
                                     @RequestParam(name = "state", required = false) String state,
                                     @RequestParam(name = "type", required = false) String type,
                                     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date createdTime,
                                     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date settledTime,
                                     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date withdrawnTime,

                                     @RequestParam(name = "orderUserName", required = false) String orderUserName,
                                     @RequestParam(name = "paymentType", required = false) String paymentType,
                                     @RequestParam(name = "pointExchangeRate", required = false) Integer pointExchangeRate,
                                     @RequestParam(name = "orderBy", required = false) String orderBy,
                                     @RequestParam(name = "sort", required = false) String sort,
                                     @RequestParam(name = "allianceName", required = false) String allianceName,
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") Date time[]

                                         ) {
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

        OrderItemRewardRecord record = new OrderItemRewardRecord();
        record.setAllianceName(allianceName);
        record.setId(id);
        record.setOrderId(orderId);
        record.setOrderNumber(orderNumber);
        record.setOrderTotalPrice(orderTotalPrice);
        record.setOrderCreatedTime(orderCreatedTime);
        record.setOrderPaidTime(orderPaidTime);
        record.setOrderItemId(orderItemId);
        record.setOrderProfit(orderProfit);
        record.setPercent(percent);
        record.setReward(reward);
        record.setOwnerId(ownerId);
        record.setLevel(level);
        record.setState(state);
        record.setType(type);
        record.setCreatedTime(createdTime);
        record.setSettledTime(settledTime);
        record.setWithdrawnTime(withdrawnTime);
        record.setOrderUserName(orderUserName);
        record.setPaymentType(paymentType);
        record.setPointExchangeRate(pointExchangeRate);
        page.setRecords(this.orderItemRewardService.findOrderItemRewardPage(page, record, search, orderBy, startTime, endTime));

        return SuccessTip.create(page);
    }
}
