package com.jfeat.am.module.wxTemplateMessage.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.wxTemplateMessage.services.domain.model.WechatTemplateMessageRecord;
import com.jfeat.am.module.wxTemplateMessage.services.domain.service.WechatTemplateMessageOverModelService;
import com.jfeat.am.module.wxTemplateMessage.services.gen.crud.model.WechatTemplateMessageModel;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.dao.WechatTemplateMessageMapper;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model.WechatTemplateMessage;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.plus.CRUDObject;

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

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-08-21
 */
@RestController

@Api("WechatTemplateMessage")
@RequestMapping("/api/crud/wxTemplateMessage/wechatTemplateMessages")
public class WechatTemplateMessageOverModelEndpoint {


    @Resource
    WechatTemplateMessageOverModelService wechatTemplateMessageOverModelService;
    @Resource
    private WechatTemplateMessageMapper wechatTemplateMessageMapper;

    @BusinessLog(name = "WechatTemplateMessage", value = "create WechatTemplateMessage")
    @PostMapping
    @ApiOperation(value = "新建 WechatTemplateMessage", response = WechatTemplateMessageModel.class)
    public Tip createWechatTemplateMessage(@RequestBody WechatTemplateMessageModel entity) {
        entity.setOrgId(JWTKit.getOrgId());
        Integer affected = 0;
        try {
            affected = wechatTemplateMessageOverModelService.createMaster(entity, null, null, null);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @BusinessLog(name = "WechatTemplateMessage", value = "查看 WechatTemplateMessageModel")
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 WechatTemplateMessage", response = WechatTemplateMessageModel.class)
    public Tip getWechatTemplateMessage(@PathVariable Long id) {
        CRUDObject<WechatTemplateMessageModel> entity = wechatTemplateMessageOverModelService.retrieveMaster(id, null, null, null);
        if (entity != null) {
            return SuccessTip.create(entity.toJSONObject());
        } else {
            return SuccessTip.create();
        }
    }

    @BusinessLog(name = "WechatTemplateMessage", value = "update WechatTemplateMessage")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 WechatTemplateMessage", response = WechatTemplateMessageModel.class)
    public Tip updateWechatTemplateMessage(@PathVariable Integer id, @RequestBody WechatTemplateMessageModel entity) {
        entity.setId(id);
        return SuccessTip.create(wechatTemplateMessageOverModelService.updateMaster(entity, null, null, null));
    }

    @BusinessLog(name = "WechatTemplateMessage", value = "update status WechatTemplateMessage")
    @PostMapping("/{id}/enable")
    @ApiOperation(value = "启用 WechatTemplateMessage", response = WechatTemplateMessageModel.class)
    public Tip enableWechatTemplateMessage(@PathVariable Integer id) {
        WechatTemplateMessage entity = new WechatTemplateMessage();
        entity.setId(id);
        entity.setEnabled(1);
        return SuccessTip.create(wechatTemplateMessageOverModelService.updateMaster(entity, false));
    }

    @BusinessLog(name = "WechatTemplateMessage", value = "update status WechatTemplateMessage")
    @PostMapping("/{id}/disable")
    @ApiOperation(value = "停用 WechatTemplateMessage", response = WechatTemplateMessageModel.class)
    public Tip disableWechatTemplateMessage(@PathVariable Integer id) {
        WechatTemplateMessage entity = new WechatTemplateMessage();
        entity.setId(id);
        entity.setEnabled(0);
        return SuccessTip.create(wechatTemplateMessageOverModelService.updateMaster(entity, false));
    }

    @BusinessLog(name = "WechatTemplateMessage", value = "delete WechatTemplateMessage")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 WechatTemplateMessage")
    public Tip deleteWechatTemplateMessage(@PathVariable Integer id) {
        return SuccessTip.create(wechatTemplateMessageMapper.deleteById(id));
    }

    @BusinessLog(name = "WechatTemplateMessage", value = "delete WechatTemplateMessage")
    @ApiOperation(value = "WechatTemplateMessage 列表信息", response = WechatTemplateMessageRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "templateId", dataType = "String"),
            @ApiImplicitParam(name = "type", dataType = "String"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "enabled", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryWechatTemplateMessages(Page<WechatTemplateMessageRecord> page,
                                           @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                           @RequestParam(name = "search", required = false) String search,
                                           @RequestParam(name = "id", required = false) Integer id,
                                           @RequestParam(name = "templateId", required = false) String templateId,
                                           @RequestParam(name = "type", required = false) String type,
                                           @RequestParam(name = "name", required = false) String name,
                                           @RequestParam(name = "enabled", required = false) Integer enabled,
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

        WechatTemplateMessageRecord record = new WechatTemplateMessageRecord();
        record.setId(id);
        record.setTemplateId(templateId);
        record.setType(type);
        record.setName(name);
        record.setEnabled(enabled);
        record.setOrgId(JWTKit.getOrgId());
        page.setRecords(this.wechatTemplateMessageOverModelService.findWechatTemplateMessagePage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
