package com.jfeat.am.module.sku.api.crud;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.sku.services.crud.model.SkuTagModel;
import com.jfeat.am.module.sku.services.domain.dao.QuerySkuTagDao;
import com.jfeat.am.module.sku.services.domain.model.SkuTagRecord;
import com.jfeat.am.module.sku.services.domain.service.SkuTagService;
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
 * @since 2018-07-18
 */
@RestController
@Api("sku-标签")
@RequestMapping("/api/wms/sku/tags")
public class SkuTagEndpoint extends BaseController {


    @Resource
    SkuTagService skuTagService;

    @Resource
    QuerySkuTagDao querySkuTagDao;

    @BusinessLog(name = "SkuTag", value = "create SkuTag")
    @PostMapping
    @ApiOperation("添加标签")
    public Tip createSkuTag(@PathVariable long skuId, @RequestBody SkuTagModel entity) {

        Integer affected = 0;
        try {
            affected = skuTagService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation("获取标签")
    public Tip getSkuTag(@PathVariable Long id) {
        return SuccessTip.create(skuTagService.retrieveMaster(id));
    }

    @BusinessLog(name = "SkuTag", value = "update SkuTag")
    @PutMapping("/{id}")
    @ApiOperation("修改标签")
    public Tip updateSkuTag(@PathVariable Long id, @RequestBody SkuTagModel entity) {
        entity.setId(id);
        return SuccessTip.create(skuTagService.updateMaster(entity));
    }

    @BusinessLog(name = "SkuTag", value = "delete SkuTag")
    @DeleteMapping("/{id}")
    @ApiOperation("删除标签")
    public Tip deleteSkuTag(@PathVariable Long id) {
        return SuccessTip.create(skuTagService.deleteMaster(id));
    }

    @GetMapping
    @ApiOperation("所有标签")
    public Tip querySkuTags(Page<SkuTagRecord> page,
                            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                            @RequestParam(name = "id", required = false) Long id,
                            @RequestParam(name = "tagName", required = false) String tagName,
                            @RequestParam(name = "tagDescription", required = false) String tagDescription,
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

        SkuTagRecord record = new SkuTagRecord();
        record.setId(id);
        record.setTagName(tagName);
        record.setTagDescription(tagDescription);

        page.setRecords(querySkuTagDao.findSkuTagPage(page, record, orderBy));

        return SuccessTip.create(page);
    }


}
