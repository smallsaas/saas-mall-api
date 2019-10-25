package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductBrandRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductBrandService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductBrand;
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

@Api("ProductBrand")
@RequestMapping("/api/crud/product/productBrands")
public class ProductBrandEndpoint {


    @Resource
    ProductBrandService productBrandService;

    @PostMapping
    @ApiOperation(value = "新建 ProductBrand", response = ProductBrand.class)
    public Tip createProductBrand(@RequestBody ProductBrand entity) {
        Integer affected = 0;
        try {
            affected = productBrandService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ProductBrand", response = ProductBrand.class)
    public Tip getProductBrand(@PathVariable Long id) {
        return SuccessTip.create(productBrandService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ProductBrand", response = ProductBrand.class)
    public Tip updateProductBrand(@PathVariable Long id, @RequestBody ProductBrand entity) {
        entity.setId(id);
        return SuccessTip.create(productBrandService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 ProductBrand")
    public Tip deleteProductBrand(@PathVariable Long id) {
        return SuccessTip.create(productBrandService.deleteMaster(id));
    }

    @ApiOperation(value = "ProductBrand 列表信息", response = ProductBrandRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "description", dataType = "String"),
            @ApiImplicitParam(name = "logo", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProductBrands(Page<ProductBrandRecord> page,
                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(name = "search", required = false) String search,
                                  @RequestParam(name = "id", required = false) Long id,
                                  @RequestParam(name = "name", required = false) String name,
                                  @RequestParam(name = "description", required = false) String description,
                                  @RequestParam(name = "logo", required = false) String logo,
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

        ProductBrandRecord record = new ProductBrandRecord();
        record.setId(id);
        record.setName(name);
        record.setDescription(description);
        record.setLogo(logo);
        page.setRecords(this.productBrandService.findProductBrandPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
