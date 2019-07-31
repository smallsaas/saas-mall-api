package com.jfeat.am.module.order.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.model.OrderCustomerServiceRecord;
import com.jfeat.am.module.order.services.domain.service.OrderCustomerServiceService;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderCustomerService;
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

@Api("OrderCustomerService")
@RequestMapping("/api/crud/order/orderCustomerServices")
public class OrderCustomerServiceEndpoint {


    @Resource
    OrderCustomerServiceService orderCustomerServiceService;

    @PostMapping
    @ApiOperation(value = "新建 OrderCustomerService", response = OrderCustomerService.class)
    public Tip createOrderCustomerService(@RequestBody OrderCustomerService entity) {

        Integer affected = 0;
        try {
            affected = orderCustomerServiceService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 OrderCustomerService", response = OrderCustomerService.class)
    public Tip getOrderCustomerService(@PathVariable Long id) {
        return SuccessTip.create(orderCustomerServiceService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 OrderCustomerService", response = OrderCustomerService.class)
    public Tip updateOrderCustomerService(@PathVariable Integer id, @RequestBody OrderCustomerService entity) {
        entity.setId(id);
        return SuccessTip.create(orderCustomerServiceService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 OrderCustomerService")
    public Tip deleteOrderCustomerService(@PathVariable Long id) {
        return SuccessTip.create(orderCustomerServiceService.deleteMaster(id));
    }

    @ApiOperation(value = "OrderCustomerService 列表信息", response = OrderCustomerServiceRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", dataType = "Integer"),
            @ApiImplicitParam(name = "createdDate", dataType = "Date"),
            @ApiImplicitParam(name = "expressNumber", dataType = "String"),
            @ApiImplicitParam(name = "expressCompany", dataType = "String"),
            @ApiImplicitParam(name = "expressCode", dataType = "String"),
            @ApiImplicitParam(name = "reason", dataType = "String"),
            @ApiImplicitParam(name = "serviceType", dataType = "String"),
            @ApiImplicitParam(name = "status", dataType = "String"),
            @ApiImplicitParam(name = "log", dataType = "String"),
            @ApiImplicitParam(name = "images", dataType = "String"),
            @ApiImplicitParam(name = "refundFee", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "supplementaryFee", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "storeId", dataType = "String"),
            @ApiImplicitParam(name = "storeName", dataType = "String"),
            @ApiImplicitParam(name = "storeUserId", dataType = "String"),
            @ApiImplicitParam(name = "storeUserName", dataType = "String"),
            @ApiImplicitParam(name = "serviceNumber", dataType = "String"),
            @ApiImplicitParam(name = "result", dataType = "String"),
            @ApiImplicitParam(name = "refundWay", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryOrderCustomerServices(Page<OrderCustomerServiceRecord> page,
                                          @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(name = "search", required = false) String search,
                                          @RequestParam(name = "id", required = false) Integer id,
                                          @RequestParam(name = "orderId", required = false) Integer orderId,
                                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date createdDate,
                                          @RequestParam(name = "expressNumber", required = false) String expressNumber,
                                          @RequestParam(name = "expressCompany", required = false) String expressCompany,
                                          @RequestParam(name = "expressCode", required = false) String expressCode,
                                          @RequestParam(name = "reason", required = false) String reason,
                                          @RequestParam(name = "serviceType", required = false) String serviceType,
                                          @RequestParam(name = "status", required = false) String status,
                                          @RequestParam(name = "log", required = false) String log,
                                          @RequestParam(name = "images", required = false) String images,
                                          @RequestParam(name = "refundFee", required = false) BigDecimal refundFee,
                                          @RequestParam(name = "supplementaryFee", required = false) BigDecimal supplementaryFee,
                                          @RequestParam(name = "storeId", required = false) String storeId,
                                          @RequestParam(name = "storeName", required = false) String storeName,
                                          @RequestParam(name = "storeUserId", required = false) String storeUserId,
                                          @RequestParam(name = "storeUserName", required = false) String storeUserName,
                                          @RequestParam(name = "serviceNumber", required = false) String serviceNumber,
                                          @RequestParam(name = "result", required = false) String result,
                                          @RequestParam(name = "refundWay", required = false) String refundWay,
                                          @RequestParam(name = "orderBy", required = false) String orderBy,
                                          @RequestParam(name = "sort", required = false) String sort) {
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

        OrderCustomerServiceRecord record = new OrderCustomerServiceRecord();
        record.setId(id);
        record.setOrderId(orderId);
        record.setCreatedDate(createdDate);
        record.setExpressNumber(expressNumber);
        record.setExpressCompany(expressCompany);
        record.setExpressCode(expressCode);
        record.setReason(reason);
        record.setServiceType(serviceType);
        record.setStatus(status);
        record.setLog(log);
        record.setImages(images);
        record.setRefundFee(refundFee);
        record.setSupplementaryFee(supplementaryFee);
        record.setStoreId(storeId);
        record.setStoreName(storeName);
        record.setStoreUserId(storeUserId);
        record.setStoreUserName(storeUserName);
        record.setServiceNumber(serviceNumber);
        record.setResult(result);
        record.setRefundWay(refundWay);
        page.setRecords(this.orderCustomerServiceService.findOrderCustomerServicePage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
