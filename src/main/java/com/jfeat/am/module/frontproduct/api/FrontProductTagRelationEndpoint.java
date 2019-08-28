package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductTagRelationRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductTagRelationService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductTagRelation;
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

@Api("FrontProductTagRelation")
@RequestMapping("/api/crud/product/productTagRelations")
public class FrontProductTagRelationEndpoint {


    @Resource
    FrontProductTagRelationService frontProductTagRelationService;

    @PostMapping
    @ApiOperation(value = "新建 FrontProductTagRelation", response = FrontProductTagRelation.class)
    public Tip createProductTagRelation(@RequestBody FrontProductTagRelation entity) {

        Integer affected = 0;
        try {
            affected = frontProductTagRelationService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 FrontProductTagRelation", response = FrontProductTagRelation.class)
    public Tip getProductTagRelation(@PathVariable Long id) {
        return SuccessTip.create(frontProductTagRelationService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 FrontProductTagRelation", response = FrontProductTagRelation.class)
    public Tip updateProductTagRelation(@PathVariable Long id, @RequestBody FrontProductTagRelation entity) {
        entity.setId(id);
        return SuccessTip.create(frontProductTagRelationService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 FrontProductTagRelation")
    public Tip deleteProductTagRelation(@PathVariable Long id) {
        return SuccessTip.create(frontProductTagRelationService.deleteMaster(id));
    }

    @ApiOperation(value = "FrontProductTagRelation 列表信息", response = FrontProductTagRelationRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "tagId", dataType = "Integer"),
            @ApiImplicitParam(name = "productId", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProductTagRelations(Page<FrontProductTagRelationRecord> page,
                                        @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(name = "search", required = false) String search,
                                        @RequestParam(name = "id", required = false) Long id,
                                        @RequestParam(name = "tagId", required = false) Long tagId,
                                        @RequestParam(name = "productId", required = false) Long productId,
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

        FrontProductTagRelationRecord record = new FrontProductTagRelationRecord();
        record.setId(id);
        record.setTagId(tagId);
        record.setProductId(productId);
        page.setRecords(this.frontProductTagRelationService.findProductTagRelationPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
