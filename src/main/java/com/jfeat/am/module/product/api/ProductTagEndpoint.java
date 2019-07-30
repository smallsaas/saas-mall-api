package com.jfeat.am.module.product.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductTagRecord;
import com.jfeat.am.module.product.services.domain.service.ProductTagService;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductTag;
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

@Api("ProductTag")
@RequestMapping("/api/crud/product/productTags")
public class ProductTagEndpoint {


    @Resource
    ProductTagService productTagService;

    @PostMapping
    @ApiOperation(value = "新建 ProductTag", response = ProductTag.class)
    public Tip createProductTag(@RequestBody ProductTag entity) {

        Integer affected = 0;
        try {
            affected = productTagService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ProductTag", response = ProductTag.class)
    public Tip getProductTag(@PathVariable Long id) {
        return SuccessTip.create(productTagService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ProductTag", response = ProductTag.class)
    public Tip updateProductTag(@PathVariable Integer id, @RequestBody ProductTag entity) {
        entity.setId(id);
        return SuccessTip.create(productTagService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 ProductTag")
    public Tip deleteProductTag(@PathVariable Long id) {
        return SuccessTip.create(productTagService.deleteMaster(id));
    }

    @ApiOperation(value = "ProductTag 列表信息", response = ProductTagRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "identifier", dataType = "String"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "sortOrder", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProductTags(Page<ProductTagRecord> page,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                @RequestParam(name = "search", required = false) String search,
                                @RequestParam(name = "id", required = false) Integer id,
                                @RequestParam(name = "identifier", required = false) String identifier,
                                @RequestParam(name = "name", required = false) String name,
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

        ProductTagRecord record = new ProductTagRecord();
        record.setId(id);
        record.setIdentifier(identifier);
        record.setName(name);
        record.setSortOrder(sortOrder);
        page.setRecords(this.productTagService.findProductTagPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
