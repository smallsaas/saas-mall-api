package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductImageRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductImageService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductImage;
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


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-25
 */
@RestController

@Api("ProductImage")
@RequestMapping("/api/crud/product/productImages")
public class ProductImageEndpoint {


    @Resource
    ProductImageService productImageService;

    @PostMapping
    @ApiOperation(value = "新建 ProductImage", response = ProductImage.class)
    public Tip createProductImage(@RequestBody ProductImage entity) {

        Integer affected = 0;
        try {
            affected = productImageService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ProductImage", response = ProductImage.class)
    public Tip getProductImage(@PathVariable Long id) {
        return SuccessTip.create(productImageService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ProductImage", response = ProductImage.class)
    public Tip updateProductImage(@PathVariable Long id, @RequestBody ProductImage entity) {
        entity.setId(id);
        return SuccessTip.create(productImageService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 ProductImage")
    public Tip deleteProductImage(@PathVariable Long id) {
        return SuccessTip.create(productImageService.deleteMaster(id));
    }

    @ApiOperation(value = "ProductImage 列表信息", response = ProductImageRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "productId", dataType = "Integer"),
            @ApiImplicitParam(name = "type", dataType = "Integer"),
            @ApiImplicitParam(name = "url", dataType = "String"),
            @ApiImplicitParam(name = "sortOrder", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProductImages(Page<ProductImageRecord> page,
                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(name = "search", required = false) String search,
                                  @RequestParam(name = "id", required = false) Long id,
                                  @RequestParam(name = "productId", required = false) Long productId,
                                  @RequestParam(name = "type", required = false) Integer type,
                                  @RequestParam(name = "url", required = false) String url,
                                  @RequestParam(name = "sortOrder", required = false) Integer sortOrder,
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

        ProductImageRecord record = new ProductImageRecord();
        record.setId(id);
        record.setProductId(productId);
        record.setType(type);
        record.setUrl(url);
        record.setSortOrder(sortOrder);
        page.setRecords(this.productImageService.findProductImagePage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
