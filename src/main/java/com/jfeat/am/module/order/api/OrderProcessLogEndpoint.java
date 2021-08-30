package com.jfeat.am.module.order.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.model.OrderProcessLogRecord;
import com.jfeat.am.module.order.services.domain.service.OrderProcessLogService;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderProcessLog;
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

@Api("OrderProcessLog")
@RequestMapping("/api/crud/order/orderProcessLogs")
public class OrderProcessLogEndpoint {


    @Resource
    OrderProcessLogService orderProcessLogService;

    @PostMapping
    @ApiOperation(value = "新建 OrderProcessLog", response = OrderProcessLog.class)
    public Tip createOrderProcessLog(@RequestBody OrderProcessLog entity) {

        Integer affected = 0;
        try {
            affected = orderProcessLogService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 OrderProcessLog", response = OrderProcessLog.class)
    public Tip getOrderProcessLog(@PathVariable Long id) {
        return SuccessTip.create(orderProcessLogService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 OrderProcessLog", response = OrderProcessLog.class)
    public Tip updateOrderProcessLog(@PathVariable Long id, @RequestBody OrderProcessLog entity) {
        entity.setId(id);
        return SuccessTip.create(orderProcessLogService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 OrderProcessLog")
    public Tip deleteOrderProcessLog(@PathVariable Long id) {
        return SuccessTip.create(orderProcessLogService.deleteMaster(id));
    }

    @ApiOperation(value = "OrderProcessLog 列表信息", response = OrderProcessLogRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", dataType = "Integer"),
            @ApiImplicitParam(name = "processDate", dataType = "Date"),
            @ApiImplicitParam(name = "content", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryOrderProcessLogs(Page<OrderProcessLogRecord> page,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(name = "search", required = false) String search,
                                     @RequestParam(name = "id", required = false) Long id,
                                     @RequestParam(name = "orderId", required = false) Integer orderId,
                                     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date processDate,
                                     @RequestParam(name = "content", required = false) String content,
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

        OrderProcessLogRecord record = new OrderProcessLogRecord();
        record.setId(id);
        record.setOrderId(orderId);
        record.setProcessDate(processDate);
        record.setContent(content);
        page.setRecords(this.orderProcessLogService.findOrderProcessLogPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
