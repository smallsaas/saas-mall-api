package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductTagRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductTagService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductTag;
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

@Api("FrontProductTag")
@RequestMapping("/api/crud/product/productTags")
public class FrontProductTagEndpoint {


    @Resource
    FrontProductTagService frontProductTagService;

    @PostMapping
    @ApiOperation(value = "新建 FrontProductTag", response = FrontProductTag.class)
    public Tip createProductTag(@RequestBody FrontProductTag entity) {

        Integer affected = 0;
        try {
            affected = frontProductTagService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 FrontProductTag", response = FrontProductTag.class)
    public Tip getProductTag(@PathVariable Long id) {
        return SuccessTip.create(frontProductTagService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 FrontProductTag", response = FrontProductTag.class)
    public Tip updateProductTag(@PathVariable Long id, @RequestBody FrontProductTag entity) {
        entity.setId(id);
        return SuccessTip.create(frontProductTagService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 FrontProductTag")
    public Tip deleteProductTag(@PathVariable Long id) {
        return SuccessTip.create(frontProductTagService.deleteMaster(id));
    }

    @ApiOperation(value = "FrontProductTag 列表信息", response = FrontProductTagRecord.class)
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
    public Tip queryProductTags(Page<FrontProductTagRecord> page,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                @RequestParam(name = "search", required = false) String search,
                                @RequestParam(name = "id", required = false) Long id,
                                @RequestParam(name = "identifier", required = false) String identifier,
                                @RequestParam(name = "name", required = false) String name,
                                @RequestParam(name = "sortOrder", required = false) Integer sortOrder,
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

        FrontProductTagRecord record = new FrontProductTagRecord();
        record.setId(id);
        record.setIdentifier(identifier);
        record.setName(name);
        record.setSortOrder(sortOrder);
        record.setOrgId(orgId);
        page.setRecords(this.frontProductTagService.findProductTagPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
