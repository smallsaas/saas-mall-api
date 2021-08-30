package com.jfeat.am.module.wxTemplateMessage.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.wxTemplateMessage.services.domain.model.WechatMessageTypePropRecord;
import com.jfeat.am.module.wxTemplateMessage.services.domain.service.WechatMessageTypePropService;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model.WechatMessageTypeProp;
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
 * @since 2019-08-21
 */
@RestController

@Api("WechatMessageTypeProp")
@RequestMapping("/api/crud/wxTemplateMessage/wechatMessageTypeProps")
public class WechatMessageTypePropOverModelEndpoint {

    @Resource
    WechatMessageTypePropService wechatMessageTypePropService;

    @BusinessLog(name = "WechatMessageTypeProp", value = "create WechatMessageTypeProp")
    @PostMapping
    @ApiOperation(value = "新建 WechatMessageTypeProp", response = WechatMessageTypeProp.class)
    public Tip createWechatMessageTypeProp(@RequestBody WechatMessageTypeProp entity) {

        Integer affected = 0;
        try {
            affected = wechatMessageTypePropService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @BusinessLog(name = "WechatMessageTypeProp", value = "查看 WechatMessageTypeProp")
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 WechatMessageTypeProp", response = WechatMessageTypeProp.class)
    public Tip getWechatMessageTypeProp(@PathVariable Integer id) {
        return SuccessTip.create(wechatMessageTypePropService.retrieveMaster(id));
    }

    @BusinessLog(name = "WechatMessageTypeProp", value = "update WechatMessageTypeProp")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 WechatMessageTypeProp", response = WechatMessageTypeProp.class)
    public Tip updateWechatMessageTypeProp(@PathVariable Integer id, @RequestBody WechatMessageTypeProp entity) {
        entity.setId(id);
        return SuccessTip.create(wechatMessageTypePropService.updateMaster(entity));
    }

    @BusinessLog(name = "WechatMessageTypeProp", value = "delete WechatMessageTypeProp")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 WechatMessageTypeProp")
    public Tip deleteWechatMessageTypeProp(@PathVariable Long id) {
        return SuccessTip.create(wechatMessageTypePropService.deleteMaster(id));
    }

    @BusinessLog(name = "WechatMessageTypeProp", value = "delete WechatMessageTypeProp")
    @ApiOperation(value = "WechatMessageTypeProp 列表信息", response = WechatMessageTypePropRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "messageId", dataType = "Integer"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "displayAttr", dataType = "String"),
            @ApiImplicitParam(name = "displayValue", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryWechatMessageTypeProps(Page<WechatMessageTypePropRecord> page,
                                           @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                           @RequestParam(name = "search", required = false) String search,
                                           @RequestParam(name = "id", required = false) Integer id,
                                           @RequestParam(name = "messageId", required = false) Integer messageId,
                                           @RequestParam(name = "name", required = false) String name,
                                           @RequestParam(name = "displayAttr", required = false) String displayAttr,
                                           @RequestParam(name = "displayValue", required = false) String displayValue,
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

        WechatMessageTypePropRecord record = new WechatMessageTypePropRecord();
        record.setId(id);
        record.setMessageId(messageId);
        record.setName(name);
        record.setDisplayAttr(displayAttr);
        record.setDisplayValue(displayValue);
        page.setRecords(this.wechatMessageTypePropService.findWechatMessageTypePropPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
