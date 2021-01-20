package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.annotation.BusinessLog;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductPurchaseStrategyRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductPurchaseStrategyService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductPurchaseStrategy;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-25
 */
@RestController

@Api("ProductPurchaseStrategy")
@RequestMapping("/api/crud/product/productPurchaseStrategyies")
public class ProductPurchaseStrategyEndpoint {


    @Resource
    ProductPurchaseStrategyService productPurchaseStrategyService;

    @BusinessLog(name = "产品采购策略", value = "新建产品采购策略")
    @PostMapping
    @ApiOperation(value = "新建 ProductPurchaseStrategy", response = ProductPurchaseStrategy.class)
    public Tip createProductPurchaseStrategy(@RequestBody ProductPurchaseStrategy entity) {

        Integer affected = 0;
        try {
            affected = productPurchaseStrategyService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ProductPurchaseStrategy", response = ProductPurchaseStrategy.class)
    public Tip getProductPurchaseStrategy(@PathVariable Long id) {
        return SuccessTip.create(productPurchaseStrategyService.retrieveMaster(id));
    }

    @BusinessLog(name = "产品采购策略", value = "修改产品采购策略")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ProductPurchaseStrategy", response = ProductPurchaseStrategy.class)
    public Tip updateProductPurchaseStrategy(@PathVariable Long id, @RequestBody ProductPurchaseStrategy entity) {
        entity.setId(id);
        return SuccessTip.create(productPurchaseStrategyService.updateMaster(entity));
    }

    @BusinessLog(name = "产品采购策略", value = "删除产品采购策略")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 ProductPurchaseStrategy")
    public Tip deleteProductPurchaseStrategy(@PathVariable Long id) {
        return SuccessTip.create(productPurchaseStrategyService.deleteMaster(id));
    }

    @ApiOperation(value = "ProductPurchaseStrategy 列表信息", response = ProductPurchaseStrategyRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "description", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProductPurchaseStrategyies(Page<ProductPurchaseStrategyRecord> page,
                                               @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                               @RequestParam(name = "search", required = false) String search,
                                               @RequestParam(name = "id", required = false) Long id,
                                               @RequestParam(name = "name", required = false) String name,
                                               @RequestParam(name = "description", required = false) String description,
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

        ProductPurchaseStrategyRecord record = new ProductPurchaseStrategyRecord();
        record.setId(id);
        record.setName(name);
        record.setDescription(description);
        page.setRecords(this.productPurchaseStrategyService.findProductPurchaseStrategyPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
