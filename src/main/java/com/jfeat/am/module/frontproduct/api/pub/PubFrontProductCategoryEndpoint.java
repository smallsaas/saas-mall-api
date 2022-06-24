package com.jfeat.am.module.frontproduct.api.pub;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.module.frontproduct.definition.FrontProductPermission;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductCategoryService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FrontProductMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
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

@Api("PubFrontProductCategory")
@RequestMapping("/api/pub/product/productCategoryies")
public class PubFrontProductCategoryEndpoint {


    @Resource
    FrontProductCategoryService frontProductCategoryService;

    @Resource
    FrontProductMapper frontProductMapper;


    @GetMapping("/{id}")
    @ApiOperation(value = "查看 FrontProductCategory", response = FrontProductCategory.class)
    @Permission(FrontProductPermission.PRODUCTCATEGORY_VIEW)
    public Tip getProductCategory(@PathVariable Long id) {
        return SuccessTip.create(frontProductCategoryService.getProductCategoryById(id));
    }


    @ApiOperation(value = "FrontProductCategory 列表信息", response = FrontProductCategoryRecord.class)
    @GetMapping
    public Tip queryProductCategoryies(Page<FrontProductCategoryRecord> page,
                                       @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                       @RequestParam(name = "search", required = false) String search,
                                       @RequestParam(name = "id", required = false) Long id,
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
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        FrontProductCategoryRecord record = new FrontProductCategoryRecord();
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
/*        if(META.enabledSaas()) {
            record.setOrgId(JWTKit.getTenantOrgId());
        }*/
        //record.setOrgId(orgId);
        page.setRecords(this.frontProductCategoryService.findProductCategoryPage(page, record, search, orderBy, null, null));
        return SuccessTip.create(page);
    }
/*
    @ApiOperation(value = "返回所有ProductCategory", response = FrontProductCategoryRecord.class)
    @GetMapping
    @Permission(FrontProductPermission.PRODUCTCATEGORY_VIEW)
    public Tip queryProductCategoryies(@RequestParam(name = "name", required = false)  String name){
        List<FrontProductCategoryRecord> frontProductCategoryRecordList =  frontProductCategoryService.queryProductCategoryies(name);
        return SuccessTip.create(frontProductCategoryRecordList);
    }
    */


}
