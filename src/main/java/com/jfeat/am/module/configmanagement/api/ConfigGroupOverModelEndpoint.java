package com.jfeat.am.module.configmanagement.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.configmanagement.services.domain.model.ConfigGroupRecord;
import com.jfeat.am.module.configmanagement.services.domain.service.ConfigGroupOverModelService;
import com.jfeat.am.module.configmanagement.services.gen.crud.model.ConfigGroupModel;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.plus.CRUDObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * @since 2019-08-13
 */
@RestController

@Api("ConfigGroup")
@RequestMapping("/api/crud/configmanagement/configGroups")
public class ConfigGroupOverModelEndpoint {


    @Resource
    ConfigGroupOverModelService configGroupOverModelService;

    @BusinessLog(name = "ConfigGroup", value = "create ConfigGroup")
    @PostMapping
    @ApiOperation(value = "新建 ConfigGroup", response = ConfigGroupModel.class)
    public Tip createConfigGroup(@RequestBody ConfigGroupModel entity) {

        Integer affected = 0;
        try {
            affected = configGroupOverModelService.createMaster(entity, null, null, null);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @BusinessLog(name = "ConfigGroup", value = "查看 ConfigGroupModel")
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ConfigGroup", response = ConfigGroupModel.class)
    public Tip getConfigGroup(@PathVariable Long id) {
        CRUDObject<ConfigGroupModel> entity = configGroupOverModelService.retrieveMaster(id, null, null, null);
        if (entity != null) {
            return SuccessTip.create(entity.toJSONObject());
        } else {
            return SuccessTip.create();
        }
    }

    @BusinessLog(name = "ConfigGroup", value = "查看所有 ConfigGroupModel")
    @GetMapping("/all")
    @ApiOperation(value = "查看所有 ConfigGroup", response = ConfigGroupModel.class)
    public Tip getAllConfigGroup() {
        List<ConfigGroupModel> configGroupModelList = configGroupOverModelService.getAllConfigGroup();
        return SuccessTip.create(configGroupModelList);
    }

    @BusinessLog(name = "ConfigGroup", value = "update ConfigGroup")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ConfigGroup", response = ConfigGroupModel.class)
    public Tip updateConfigGroup(@PathVariable Integer id, @RequestBody ConfigGroupModel entity) {
        entity.setId(id);
        return SuccessTip.create(configGroupOverModelService.updateMaster(entity, null, null, null));
    }

    @BusinessLog(name = "ConfigGroup", value = "delete ConfigGroup")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 ConfigGroup")
    public Tip deleteConfigGroup(@PathVariable Long id) {
        return SuccessTip.create(configGroupOverModelService.deleteMaster(id));
    }

    @BusinessLog(name = "ConfigGroup", value = "delete ConfigGroup")
    @ApiOperation(value = "ConfigGroup 列表信息", response = ConfigGroupRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "protected", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryConfigGroups(Page<ConfigGroupRecord> page,
                                 @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(name = "search", required = false) String search,
                                 @RequestParam(name = "id", required = false) Integer id,
                                 @RequestParam(name = "name", required = false) String name,
                                 @RequestParam(name = "protecte", required = false)Integer protecte,
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

        ConfigGroupRecord record = new ConfigGroupRecord();
        record.setId(id);
        record.setName(name);
        record.setProtected(protecte);
        record.setOrgId(JWTKit.getOrgId());
        page.setRecords(this.configGroupOverModelService.findConfigGroupPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
