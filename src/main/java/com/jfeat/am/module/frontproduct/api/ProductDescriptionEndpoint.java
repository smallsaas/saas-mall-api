package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductDescriptionRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductDescriptionService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductDescription;
import com.jfeat.crud.base.annotation.BusinessLog;
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

@Api("ProductDescription")
@RequestMapping("/api/crud/product/productDescriptions")
public class ProductDescriptionEndpoint {


    @Resource
    ProductDescriptionService productDescriptionService;


    @PostMapping
    @ApiOperation(value = "新建 ProductDescription", response = ProductDescription.class)
    public Tip createProductDescription(@RequestBody ProductDescription entity) {

        Integer affected = 0;
        try {
            affected = productDescriptionService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ProductDescription", response = ProductDescription.class)
    public Tip getProductDescription(@PathVariable Long id) {
        return SuccessTip.create(productDescriptionService.retrieveMaster(id));
    }

    @BusinessLog(name = "产品描述", value = "修改产品描述")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ProductDescription", response = ProductDescription.class)
    public Tip updateProductDescription(@PathVariable Long id, @RequestBody ProductDescription entity) {
        entity.setId(id);
        return SuccessTip.create(productDescriptionService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 ProductDescription")
    public Tip deleteProductDescription(@PathVariable Long id) {
        return SuccessTip.create(productDescriptionService.deleteMaster(id));
    }

    @ApiOperation(value = "ProductDescription 列表信息", response = ProductDescriptionRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "productId", dataType = "Integer"),
            @ApiImplicitParam(name = "description", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProductDescriptions(Page<ProductDescriptionRecord> page,
                                        @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(name = "search", required = false) String search,
                                        @RequestParam(name = "id", required = false) Long id,
                                        @RequestParam(name = "productId", required = false) Long productId,
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

        ProductDescriptionRecord record = new ProductDescriptionRecord();
        record.setId(id);
        record.setProductId(productId);
        record.setDescription(description);
        page.setRecords(this.productDescriptionService.findProductDescriptionPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
