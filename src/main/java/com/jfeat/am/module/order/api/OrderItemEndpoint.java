package com.jfeat.am.module.order.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.model.OrderItemRecord;
import com.jfeat.am.module.order.services.domain.service.OrderItemService;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;
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

@Api("OrderItem")
@RequestMapping("/api/crud/order/orderItems")
public class OrderItemEndpoint {


    @Resource
    OrderItemService orderItemService;

    @PostMapping
    @ApiOperation(value = "新建 OrderItem", response = OrderItem.class)
    public Tip createOrderItem(@RequestBody OrderItem entity) {

        Integer affected = 0;
        try {
            affected = orderItemService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 OrderItem", response = OrderItem.class)
    public Tip getOrderItem(@PathVariable Long id) {
        return SuccessTip.create(orderItemService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 OrderItem", response = OrderItem.class)
    public Tip updateOrderItem(@PathVariable Integer id, @RequestBody OrderItem entity) {
        entity.setId(id);
        return SuccessTip.create(orderItemService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 OrderItem")
    public Tip deleteOrderItem(@PathVariable Long id) {
        return SuccessTip.create(orderItemService.deleteMaster(id));
    }

    @ApiOperation(value = "OrderItem 列表信息", response = OrderItemRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", dataType = "Integer"),
            @ApiImplicitParam(name = "productId", dataType = "Integer"),
            @ApiImplicitParam(name = "productName", dataType = "String"),
            @ApiImplicitParam(name = "quantity", dataType = "Integer"),
            @ApiImplicitParam(name = "price", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "finalPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "status", dataType = "String"),
            @ApiImplicitParam(name = "costPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "cover", dataType = "String"),
            @ApiImplicitParam(name = "partnerLevelZone", dataType = "Integer"),
            @ApiImplicitParam(name = "productSpecificationName", dataType = "String"),
            @ApiImplicitParam(name = "productSpecificationId", dataType = "Integer"),
            @ApiImplicitParam(name = "weight", dataType = "Integer"),
            @ApiImplicitParam(name = "bulk", dataType = "Integer"),
            @ApiImplicitParam(name = "barcode", dataType = "String"),
            @ApiImplicitParam(name = "storeLocation", dataType = "String"),
            @ApiImplicitParam(name = "marketing", dataType = "String"),
            @ApiImplicitParam(name = "marketingId", dataType = "Integer"),
            @ApiImplicitParam(name = "marketingDescription", dataType = "String"),
            @ApiImplicitParam(name = "skuId", dataType = "String"),
            @ApiImplicitParam(name = "warehouseId", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryOrderItems(Page<OrderItemRecord> page,
                               @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(name = "search", required = false) String search,
                               @RequestParam(name = "id", required = false) Integer id,
                               @RequestParam(name = "orderId", required = false) Integer orderId,
                               @RequestParam(name = "productId", required = false) Integer productId,
                               @RequestParam(name = "productName", required = false) String productName,
                               @RequestParam(name = "quantity", required = false) Integer quantity,
                               @RequestParam(name = "price", required = false) BigDecimal price,
                               @RequestParam(name = "finalPrice", required = false) BigDecimal finalPrice,
                               @RequestParam(name = "status", required = false) String status,
                               @RequestParam(name = "costPrice", required = false) BigDecimal costPrice,
                               @RequestParam(name = "cover", required = false) String cover,
                               @RequestParam(name = "partnerLevelZone", required = false) Integer partnerLevelZone,
                               @RequestParam(name = "productSpecificationName", required = false) String productSpecificationName,
                               @RequestParam(name = "productSpecificationId", required = false) Integer productSpecificationId,
                               @RequestParam(name = "weight", required = false) Integer weight,
                               @RequestParam(name = "bulk", required = false) Integer bulk,
                               @RequestParam(name = "barcode", required = false) String barcode,
                               @RequestParam(name = "storeLocation", required = false) String storeLocation,
                               @RequestParam(name = "marketing", required = false) String marketing,
                               @RequestParam(name = "marketingId", required = false) Integer marketingId,
                               @RequestParam(name = "marketingDescription", required = false) String marketingDescription,
                               @RequestParam(name = "skuId", required = false) String skuId,
                               @RequestParam(name = "warehouseId", required = false) String warehouseId,
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

        OrderItemRecord record = new OrderItemRecord();
        record.setId(id);
        record.setOrderId(orderId);
        record.setProductId(productId);
        record.setProductName(productName);
        record.setQuantity(quantity);
        record.setPrice(price);
        record.setFinalPrice(finalPrice);
        record.setStatus(status);
        record.setCostPrice(costPrice);
        record.setCover(cover);
        record.setPartnerLevelZone(partnerLevelZone);
        record.setProductSpecificationName(productSpecificationName);
        record.setProductSpecificationId(productSpecificationId);
        record.setWeight(weight);
        record.setBulk(bulk);
        record.setBarcode(barcode);
        record.setStoreLocation(storeLocation);
        record.setMarketing(marketing);
        record.setMarketingId(marketingId);
        record.setMarketingDescription(marketingDescription);
        record.setSkuId(skuId);
        record.setWarehouseId(warehouseId);
        page.setRecords(this.orderItemService.findOrderItemPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
