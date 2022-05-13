package com.jfeat.am.module.configmanagement.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.am.module.configmanagement.services.domain.model.MallConfigGroupRecord;
import com.jfeat.am.module.configmanagement.services.domain.service.ConfigGroupOverModelService;
import com.jfeat.am.module.configmanagement.services.gen.crud.model.MallConfigGroupModel;
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

    @BusinessLog(name = "权限组", value = "新建权限组")
    @PostMapping
    @ApiOperation(value = "新建 ConfigGroup", response = MallConfigGroupModel.class)
    /*@Permission(ConfigPermission.CONFIGGROUP_ADD)*/
    public Tip createConfigGroup(@RequestBody MallConfigGroupModel entity) {

        Integer affected = 0;
        try {
            affected = configGroupOverModelService.createMaster(entity, null, null, null);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ConfigGroup", response = MallConfigGroupModel.class)
    /*@Permission(ConfigPermission.CONFIGGROUP_VIEW)*/
    public Tip getConfigGroup(@PathVariable Long id) {
        CRUDObject<MallConfigGroupModel> entity = configGroupOverModelService.retrieveMaster(id, null, null, null);
        if (entity != null) {
            return SuccessTip.create(entity.toJSONObject());
        } else {
            return SuccessTip.create();
        }
    }


    @GetMapping("/all")
    @ApiOperation(value = "查看所有 ConfigGroup", response = MallConfigGroupModel.class)
    /*@Permission(ConfigPermission.CONFIGGROUP_VIEW)*/
    public Tip getAllConfigGroup() {
        List<MallConfigGroupModel> configGroupModelList = configGroupOverModelService.getAllConfigGroup();
        return SuccessTip.create(configGroupModelList);
    }

    @BusinessLog(name = "权限组", value = "更新权限组")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 权限组", response = MallConfigGroupModel.class)
   /* @Permission(ConfigPermission.CONFIGGROUP_EDIT)*/
    public Tip updateConfigGroup(@PathVariable Integer id, @RequestBody MallConfigGroupModel entity) {
        entity.setId(id);
        return SuccessTip.create(configGroupOverModelService.updateMaster(entity, null, null, null));
    }

    @BusinessLog(name = "权限组", value = "删除权限组")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 ConfigGroup")
    /*@Permission(ConfigPermission.CONFIGGROUP_DEL)*/
    public Tip deleteConfigGroup(@PathVariable Long id) {
        return SuccessTip.create(configGroupOverModelService.deleteMaster(id));
    }


    @ApiOperation(value = "ConfigGroup 列表信息", response = MallConfigGroupRecord.class)
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
    public Tip queryConfigGroups(Page<MallConfigGroupRecord> page,
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

        MallConfigGroupRecord record = new MallConfigGroupRecord();
        record.setId(id);
        record.setName(name);
        record.setProtected(protecte);
        /*record.setOrgId(JWTKit.getOrgId());*/
        page.setRecords(this.configGroupOverModelService.findConfigGroupPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
