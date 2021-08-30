package com.jfeat.am.module.order.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.model.OrderStatisticRecord;
import com.jfeat.am.module.order.services.domain.service.OrderStatisticService;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderStatistic;
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

@Api("OrderStatistic")
@RequestMapping("/api/crud/order/orderStatistics")
public class OrderStatisticEndpoint {


    @Resource
    OrderStatisticService orderStatisticService;

    @PostMapping
    @ApiOperation(value = "新建 OrderStatistic", response = OrderStatistic.class)
    public Tip createOrderStatistic(@RequestBody OrderStatistic entity) {

        Integer affected = 0;
        try {
            affected = orderStatisticService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 OrderStatistic", response = OrderStatistic.class)
    public Tip getOrderStatistic(@PathVariable Long id) {
        return SuccessTip.create(orderStatisticService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 OrderStatistic", response = OrderStatistic.class)
    public Tip updateOrderStatistic(@PathVariable Long id, @RequestBody OrderStatistic entity) {
        entity.setId(id);
        return SuccessTip.create(orderStatisticService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 OrderStatistic")
    public Tip deleteOrderStatistic(@PathVariable Long id) {
        return SuccessTip.create(orderStatisticService.deleteMaster(id));
    }

    @ApiOperation(value = "OrderStatistic 列表信息", response = OrderStatisticRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "createdDate", dataType = "Date"),
            @ApiImplicitParam(name = "salesAmount", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryOrderStatistics(Page<OrderStatisticRecord> page,
                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                    @RequestParam(name = "search", required = false) String search,
                                    @RequestParam(name = "id", required = false) Long id,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date createdDate,
                                    @RequestParam(name = "salesAmount", required = false) BigDecimal salesAmount,
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

        OrderStatisticRecord record = new OrderStatisticRecord();
        record.setId(id);
        record.setCreatedDate(createdDate);
        record.setSalesAmount(salesAmount);
        page.setRecords(this.orderStatisticService.findOrderStatisticPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
