package com.jfeat.am.module.product.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductCategoryModel;
import com.jfeat.am.module.product.services.domain.model.ProductCategoryRecord;
import com.jfeat.am.module.product.services.domain.service.ProductCategoryService;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductCategory;
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

@Api("ProductCategory")
@RequestMapping("/api/crud/product/productCategoryies")
public class ProductCategoryEndpoint {


    @Resource
    ProductCategoryService productCategoryService;

    @PostMapping
    @ApiOperation(value = "新建 ProductCategory", response = ProductCategory.class)
    public Tip createProductCategory(@RequestBody ProductCategoryModel entity) {

        Integer affected = 0;
        try {
            affected = productCategoryService.createProductCategory(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ProductCategory", response = ProductCategory.class)
    public Tip getProductCategory(@PathVariable Long id) {
        return SuccessTip.create(productCategoryService.getProductCategoryById(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ProductCategory", response = ProductCategory.class)
    public Tip updateProductCategory(@PathVariable Integer id, @RequestBody ProductCategoryModel entity) {
        entity.setId(id);
        return SuccessTip.create(productCategoryService.updateProductCategoryById(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 ProductCategory")
    public Tip deleteProductCategory(@PathVariable Long id) {
        return SuccessTip.create(productCategoryService.deleteMaster(id));
    }

    @ApiOperation(value = "ProductCategory 列表信息", response = ProductCategoryRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "parentId", dataType = "Integer"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "description", dataType = "String"),
            @ApiImplicitParam(name = "cover", dataType = "String"),
            @ApiImplicitParam(name = "sortOrder", dataType = "Integer"),
            @ApiImplicitParam(name = "promoted", dataType = "Integer"),
            @ApiImplicitParam(name = "visible", dataType = "Integer"),
            @ApiImplicitParam(name = "promotedProductCount", dataType = "Integer"),
            @ApiImplicitParam(name = "wholesale", dataType = "Integer"),
            @ApiImplicitParam(name = "isShowProducts", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProductCategoryies(Page<ProductCategoryRecord> page,
                                       @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                       @RequestParam(name = "search", required = false) String search,
                                       @RequestParam(name = "id", required = false) Integer id,
                                       @RequestParam(name = "parentId", required = false) Integer parentId,
                                       @RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "description", required = false) String description,
                                       @RequestParam(name = "cover", required = false) String cover,
                                       @RequestParam(name = "sortOrder", required = false) Integer sortOrder,
                                       @RequestParam(name = "promoted", required = false) Integer promoted,
                                       @RequestParam(name = "visible", required = false) Integer visible,
                                       @RequestParam(name = "promotedProductCount", required = false) Integer promotedProductCount,
                                       @RequestParam(name = "wholesale", required = false) Integer wholesale,
                                       @RequestParam(name = "isShowProducts", required = false) Integer isShowProducts,
                                       @RequestParam(name = "orgId", required = false) Long orgId,
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

        ProductCategoryRecord record = new ProductCategoryRecord();
        record.setId(id);
        record.setParentId(parentId);
        record.setName(name);
        record.setDescription(description);
        record.setCover(cover);
        record.setSortOrder(sortOrder);
        record.setPromoted(promoted);
        record.setVisible(visible);
        record.setPromotedProductCount(promotedProductCount);
        record.setWholesale(wholesale);
        record.setIsShowProducts(isShowProducts);
        record.setOrgId(orgId);
        page.setRecords(this.productCategoryService.findProductCategoryPage(page, record, search, orderBy, null, null));
        return SuccessTip.create(page);
    }

}
