package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductCategoryPropertyRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductCategoryPropertyService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductCategoryProperty;
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

@Api("ProductCategoryProperty")
@RequestMapping("/api/crud/product/productCategoryPropertyies")
public class ProductCategoryPropertyEndpoint {


    @Resource
    ProductCategoryPropertyService productCategoryPropertyService;

    @PostMapping
    @ApiOperation(value = "新建 ProductCategoryProperty", response = ProductCategoryProperty.class)
    public Tip createProductCategoryProperty(@RequestBody ProductCategoryProperty entity) {

        Integer affected = 0;
        try {
            affected = productCategoryPropertyService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ProductCategoryProperty", response = ProductCategoryProperty.class)
    public Tip getProductCategoryProperty(@PathVariable Long id) {
        return SuccessTip.create(productCategoryPropertyService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ProductCategoryProperty", response = ProductCategoryProperty.class)
    public Tip updateProductCategoryProperty(@PathVariable Long id, @RequestBody ProductCategoryProperty entity) {
        entity.setId(id);
        return SuccessTip.create(productCategoryPropertyService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 ProductCategoryProperty")
    public Tip deleteProductCategoryProperty(@PathVariable Long id) {
        return SuccessTip.create(productCategoryPropertyService.deleteMaster(id));
    }

    @ApiOperation(value = "ProductCategoryProperty 列表信息", response = ProductCategoryPropertyRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "categoryId", dataType = "Integer"),
            @ApiImplicitParam(name = "displayName", dataType = "String"),
            @ApiImplicitParam(name = "valueType", dataType = "String"),
            @ApiImplicitParam(name = "inputType", dataType = "String"),
            @ApiImplicitParam(name = "candidateValues", dataType = "String"),
            @ApiImplicitParam(name = "defaultValue", dataType = "String"),
            @ApiImplicitParam(name = "isRequired", dataType = "Integer"),
            @ApiImplicitParam(name = "sortNum", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProductCategoryPropertyies(Page<ProductCategoryPropertyRecord> page,
                                               @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                               @RequestParam(name = "search", required = false) String search,
                                               @RequestParam(name = "id", required = false) Long id,
                                               @RequestParam(name = "categoryId", required = false) Long categoryId,
                                               @RequestParam(name = "displayName", required = false) String displayName,
                                               @RequestParam(name = "valueType", required = false) String valueType,
                                               @RequestParam(name = "inputType", required = false) String inputType,
                                               @RequestParam(name = "candidateValues", required = false) String candidateValues,
                                               @RequestParam(name = "defaultValue", required = false) String defaultValue,
                                               @RequestParam(name = "isRequired", required = false) Integer isRequired,
                                               @RequestParam(name = "sortNum", required = false) Integer sortNum,
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

        ProductCategoryPropertyRecord record = new ProductCategoryPropertyRecord();
        record.setId(id);
        record.setCategoryId(categoryId);
        record.setDisplayName(displayName);
        record.setValueType(valueType);
        record.setInputType(inputType);
        record.setCandidateValues(candidateValues);
        record.setDefaultValue(defaultValue);
        record.setIsRequired(isRequired);
        record.setSortNum(sortNum);
        page.setRecords(this.productCategoryPropertyService.findProductCategoryPropertyPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
