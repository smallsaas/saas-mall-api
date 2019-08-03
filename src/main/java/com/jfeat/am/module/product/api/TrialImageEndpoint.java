package com.jfeat.am.module.product.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.TrialImageRecord;
import com.jfeat.am.module.product.services.domain.service.TrialImageService;
import com.jfeat.am.module.product.services.gen.persistence.model.TrialImage;
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
 * @since 2019-08-02
 */
@RestController

@Api("TrialImage")
@RequestMapping("/api/crud/product/trialImages")
public class TrialImageEndpoint {


    @Resource
    TrialImageService trialImageService;

    @PostMapping
    @ApiOperation(value = "新建 TrialImage", response = TrialImage.class)
    public Tip createTrialImage(@RequestBody TrialImage entity) {

        Integer affected = 0;
        try {
            affected = trialImageService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 TrialImage", response = TrialImage.class)
    public Tip getTrialImage(@PathVariable Long id) {
        return SuccessTip.create(trialImageService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 TrialImage", response = TrialImage.class)
    public Tip updateTrialImage(@PathVariable Long id, @RequestBody TrialImage entity) {
        entity.setId(id);
        return SuccessTip.create(trialImageService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 TrialImage")
    public Tip deleteTrialImage(@PathVariable Long id) {
        return SuccessTip.create(trialImageService.deleteMaster(id));
    }

    @ApiOperation(value = "TrialImage 列表信息", response = TrialImageRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "trialId", dataType = "Integer"),
            @ApiImplicitParam(name = "url", dataType = "String"),
            @ApiImplicitParam(name = "sortOrder", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryTrialImages(Page<TrialImageRecord> page,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                @RequestParam(name = "search", required = false) String search,
                                @RequestParam(name = "id", required = false) Long id,
                                @RequestParam(name = "trialId", required = false) Integer trialId,
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

        TrialImageRecord record = new TrialImageRecord();
        record.setId(id);
        record.setTrialId(trialId);
        record.setUrl(url);
        record.setSortOrder(sortOrder);
        page.setRecords(this.trialImageService.findTrialImagePage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
