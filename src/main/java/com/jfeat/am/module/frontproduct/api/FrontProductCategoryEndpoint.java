package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FrontProductMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.module.frontproduct.definition.FrontProductPermission;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductCategoryService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;

import com.jfeat.crud.plus.META;
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

import java.util.List;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
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

@Api("FrontProductCategory")
@RequestMapping("/api/crud/product/productCategoryies")
public class FrontProductCategoryEndpoint {


    @Resource
    FrontProductCategoryService frontProductCategoryService;

    @Resource
    FrontProductMapper frontProductMapper;


    @BusinessLog(name = "产品分类", value = "新建产品分类")
    @PostMapping
    @ApiOperation(value = "新建 FrontProductCategory", response = FrontProductCategory.class)
    @Permission(FrontProductPermission.PRODUCTCATEGORY_ADD)
    public Tip createProductCategory(@RequestBody FrontProductCategoryModel entity) {

        Integer affected = 0;
        try {
            if(entity.getImages()!=null&&entity.getImages().size()>0){
                entity.setCover( entity.getImages().get(0).getUrl());
            }

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
        if(entity.getImages()!=null&&entity.getImages().size()>0){
            entity.setCover( entity.getImages().get(0).getUrl());
        }

        return SuccessTip.create(frontProductCategoryService.updateProductCategoryById(entity));
    }

    @BusinessLog(name = "产品分类", value = "删除产品分类")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 FrontProductCategory")
    @Permission(FrontProductPermission.PRODUCTCATEGORY_DEL)
    public Tip deleteProductCategory(@PathVariable Long id) {
        FrontProduct queryer = new FrontProduct();
        queryer.setCategoryId(Integer.valueOf(id.intValue()));
        var result = frontProductMapper.selectList(new LambdaQueryWrapper<FrontProduct>(queryer));
        if(result.size()>0){
            throw new BusinessException(BusinessCode.BadRequest,"该类别下包含产品");
        }

        return SuccessTip.create(frontProductCategoryService.deleteMaster(id));
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
