package com.jfeat.am.module.order.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.model.OrderCustomerServiceItemRecord;
import com.jfeat.am.module.order.services.domain.service.OrderCustomerServiceItemService;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderCustomerServiceItem;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-31
 */
@RestController

@Api("OrderCustomerServiceItem")
@RequestMapping("/api/crud/order/orderCustomerServiceItems")
public class OrderCustomerServiceItemEndpoint {


    @Resource
    OrderCustomerServiceItemService orderCustomerServiceItemService;

    @PostMapping
    @ApiOperation(value = "新建 OrderCustomerServiceItem", response = OrderCustomerServiceItem.class)
    public Tip createOrderCustomerServiceItem(@RequestBody OrderCustomerServiceItem entity) {

        Integer affected = 0;
        try {
            affected = orderCustomerServiceItemService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 OrderCustomerServiceItem", response = OrderCustomerServiceItem.class)
    public Tip getOrderCustomerServiceItem(@PathVariable Long id) {
        return SuccessTip.create(orderCustomerServiceItemService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 OrderCustomerServiceItem", response = OrderCustomerServiceItem.class)
    public Tip updateOrderCustomerServiceItem(@PathVariable Long id, @RequestBody OrderCustomerServiceItem entity) {
        entity.setId(id);
        return SuccessTip.create(orderCustomerServiceItemService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 OrderCustomerServiceItem")
    public Tip deleteOrderCustomerServiceItem(@PathVariable Long id) {
        return SuccessTip.create(orderCustomerServiceItemService.deleteMaster(id));
    }

    @ApiOperation(value = "OrderCustomerServiceItem 列表信息", response = OrderCustomerServiceItemRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "order_customerServiceId", dataType = "Integer"),
            @ApiImplicitParam(name = "refundFee", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "type", dataType = "String"),
            @ApiImplicitParam(name = "productId", dataType = "Integer"),
            @ApiImplicitParam(name = "productName", dataType = "String"),
            @ApiImplicitParam(name = "quantity", dataType = "Integer"),
            @ApiImplicitParam(name = "price", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "finalPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "costPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "cover", dataType = "String"),
            @ApiImplicitParam(name = "productSpecificationName", dataType = "String"),
            @ApiImplicitParam(name = "productSpecificationId", dataType = "Integer"),
            @ApiImplicitParam(name = "weight", dataType = "Integer"),
            @ApiImplicitParam(name = "marketing", dataType = "String"),
            @ApiImplicitParam(name = "marketingId", dataType = "Integer"),
            @ApiImplicitParam(name = "marketingDescription", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryOrderCustomerServiceItems(Page<OrderCustomerServiceItemRecord> page,
                                              @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                              @RequestParam(name = "search", required = false) String search,
                                              @RequestParam(name = "id", required = false) Long id,
                                              @RequestParam(name = "orderCustomerServiceId", required = false) Integer orderCustomerServiceId,
                                              @RequestParam(name = "refundFee", required = false) BigDecimal refundFee,
                                              @RequestParam(name = "type", required = false) String type,
                                              @RequestParam(name = "productId", required = false) Integer productId,
                                              @RequestParam(name = "productName", required = false) String productName,
                                              @RequestParam(name = "quantity", required = false) Integer quantity,
                                              @RequestParam(name = "price", required = false) BigDecimal price,
                                              @RequestParam(name = "finalPrice", required = false) BigDecimal finalPrice,
                                              @RequestParam(name = "costPrice", required = false) BigDecimal costPrice,
                                              @RequestParam(name = "cover", required = false) String cover,
                                              @RequestParam(name = "productSpecificationName", required = false) String productSpecificationName,
                                              @RequestParam(name = "productSpecificationId", required = false) Integer productSpecificationId,
                                              @RequestParam(name = "weight", required = false) Integer weight,
                                              @RequestParam(name = "marketing", required = false) String marketing,
                                              @RequestParam(name = "marketingId", required = false) Integer marketingId,
                                              @RequestParam(name = "marketingDescription", required = false) String marketingDescription,
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

        OrderCustomerServiceItemRecord record = new OrderCustomerServiceItemRecord();
        record.setId(id);
        record.setOrderCustomerServiceId(orderCustomerServiceId);
        record.setRefundFee(refundFee);
        record.setType(type);
        record.setProductId(productId);
        record.setProductName(productName);
        record.setQuantity(quantity);
        record.setPrice(price);
        record.setFinalPrice(finalPrice);
        record.setCostPrice(costPrice);
        record.setCover(cover);
        record.setProductSpecificationName(productSpecificationName);
        record.setProductSpecificationId(productSpecificationId);
        record.setWeight(weight);
        record.setMarketing(marketing);
        record.setMarketingId(marketingId);
        record.setMarketingDescription(marketingDescription);
        page.setRecords(this.orderCustomerServiceItemService.findOrderCustomerServiceItemPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
