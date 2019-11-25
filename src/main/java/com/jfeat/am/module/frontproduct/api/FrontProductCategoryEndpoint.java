package com.jfeat.am.module.frontproduct.api;


import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.frontproduct.definition.FrontProductPermission;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductCategoryService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-25
 */
@RestController

@Api("FrontProductCategory")
@RequestMapping("/api/crud/product/productCategoryies")
public class FrontProductCategoryEndpoint {


    @Resource
    FrontProductCategoryService frontProductCategoryService;





    @BusinessLog(name = "产品分类", value = "新建产品分类")
    @PostMapping
    @ApiOperation(value = "新建 FrontProductCategory", response = FrontProductCategory.class)
    @Permission(FrontProductPermission.PRODUCTCATEGORY_ADD)
    public Tip createProductCategory(@RequestBody FrontProductCategoryModel entity) {

        Integer affected = 0;
        try {
            affected = frontProductCategoryService.createProductCategory(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }
        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 FrontProductCategory", response = FrontProductCategory.class)
    @Permission(FrontProductPermission.PRODUCTCATEGORY_VIEW)
    public Tip getProductCategory(@PathVariable Long id) {
        return SuccessTip.create(frontProductCategoryService.getProductCategoryById(id));
    }

    @BusinessLog(name = "产品分类", value = "修改产品分类")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 FrontProductCategory", response = FrontProductCategory.class)
    @Permission(FrontProductPermission.PRODUCTCATEGORY_EDIT)
    public Tip updateProductCategory(@PathVariable Long id, @RequestBody FrontProductCategoryModel entity) {
        entity.setId(id);
        return SuccessTip.create(frontProductCategoryService.updateProductCategoryById(entity));
    }

    @BusinessLog(name = "产品分类", value = "删除产品分类")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 FrontProductCategory")
    @Permission(FrontProductPermission.PRODUCTCATEGORY_DEL)
    public Tip deleteProductCategory(@PathVariable Long id) {
        return SuccessTip.create(frontProductCategoryService.deleteMaster(id));
    }

    /*@ApiOperation(value = "FrontProductCategory 列表信息", response = FrontProductCategoryRecord.class)
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
            @ApiImplicitParam(name = "sortNum", dataType = "Integer"),
            @ApiImplicitParam(name = "promoted", dataType = "Integer"),
            @ApiImplicitParam(name = "visible", dataType = "Integer"),
            @ApiImplicitParam(name = "promotedProductCount", dataType = "Integer"),
            @ApiImplicitParam(name = "wholesale", dataType = "Integer"),
            @ApiImplicitParam(name = "isShowProducts", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProductCategoryies(Page<FrontProductCategoryRecord> page,
                                       @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                       @RequestParam(name = "search", required = false) String search,
                                       @RequestParam(name = "id", required = false) Long id,
                                       @RequestParam(name = "parentId", required = false) Integer parentId,
                                       @RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "description", required = false) String description,
                                       @RequestParam(name = "cover", required = false) String cover,
                                       @RequestParam(name = "sortNum", required = false) Integer sortNum,
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

        FrontProductCategoryRecord record = new FrontProductCategoryRecord();
        record.setId(id);
        record.setParentId(parentId);
        record.setName(name);
        record.setDescription(description);
        record.setCover(cover);
        record.setSortNum(sortNum);
        record.setPromoted(promoted);
        record.setVisible(visible);
        record.setPromotedProductCount(promotedProductCount);
        record.setWholesale(wholesale);
        record.setIsShowProducts(isShowProducts);
        record.setOrgId(orgId);
        page.setRecords(this.frontProductCategoryService.findProductCategoryPage(page, record, search, orderBy, null, null));
        return SuccessTip.create(page);
    }*/

    @ApiOperation(value = "返回所有ProductCategory", response = FrontProductCategoryRecord.class)
    @GetMapping
    @Permission(FrontProductPermission.PRODUCTCATEGORY_VIEW)
    public Tip queryProductCategoryies(@RequestParam(name = "name", required = false)  String name){
        List<FrontProductCategoryRecord> frontProductCategoryRecordList =  frontProductCategoryService.queryProductCategoryies(name);
        return SuccessTip.create(frontProductCategoryRecordList);
    }

}
