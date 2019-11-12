package com.jfeat.am.module.configmanagement.api;


import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.module.configmanagement.definition.ConfigPermission;
import com.jfeat.am.module.configmanagement.services.definition.ConfigType;
import com.jfeat.am.module.configmanagement.services.domain.service.ConfigService;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Properties;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-08-13
 */
@RestController

@Api("Config")
@RequestMapping("/api/crud/configmanagement/configs")
public class ConfigOverModelEndpoint {


    @Resource
    ConfigService configService;

    /*@BusinessLog(name = "Config", value = "create Config")
    @PostMapping
    @ApiOperation(value = "新建 Config", response = Config.class)
    public Tip createConfig(@RequestBody Config entity) {

        Integer affected = 0;
        try {
            affected = configService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }*/


    @GetMapping("/{type}")
    @ApiOperation(value = "查看 Config", response = Config.class)
    @Permission(ConfigPermission.CONFIG_VIEW)
    public Tip getConfig(@PathVariable String type) {
        if(StringUtils.isEmpty(type)){
            throw new BusinessException(BusinessCode.BadRequest);
        }
        ConfigType[] values = ConfigType.values();
        boolean isExist = false;
        for (int i = 0; i <values.length ; i++) {
            if(values[i].toString().equals(type)){
                isExist = true;
                break;
            }
        }
        if(!isExist){
            throw new BusinessException(BusinessCode.BadRequest);
        }
        return SuccessTip.create(configService.getConfig(type));

    }

    @BusinessLog(name = "系统配置", value = "更改系统配置")
    @PostMapping("/{type}")
    @ApiOperation(value = "修改 Config", response = Config.class)
    @Permission(ConfigPermission.CONFIG_EDIT)
    public Tip updateConfig(@PathVariable String type, @RequestBody Properties entity) {
        if(StringUtils.isEmpty(type)){
            throw new BusinessException(BusinessCode.BadRequest);
        }
        ConfigType[] values = ConfigType.values();
        boolean isExist = false;
        for (int i = 0; i <values.length ; i++) {
            if(values[i].toString().equals(type)){
                isExist = true;
                break;
            }
        }
        if(!isExist){
            throw new BusinessException(BusinessCode.BadRequest);
        }

        return SuccessTip.create(configService.updateConfig(type,entity));

    }

    /*@BusinessLog(name = "Config", value = "delete Config")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Config")
    public Tip deleteConfig(@PathVariable Long id) {
        return SuccessTip.create(configService.deleteMaster(id));
    }*/

    /*@BusinessLog(name = "Config", value = "delete Config")
    @ApiOperation(value = "Config 列表信息", response = ConfigRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "userId", dataType = "Integer"),
            @ApiImplicitParam(name = "groupId", dataType = "Integer"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "keyName", dataType = "String"),
            @ApiImplicitParam(name = "valueType", dataType = "String"),
            @ApiImplicitParam(name = "value", dataType = "String"),
            @ApiImplicitParam(name = "type", dataType = "String"),
            @ApiImplicitParam(name = "visible", dataType = "Integer"),
            @ApiImplicitParam(name = "description", dataType = "String"),
            @ApiImplicitParam(name = "readonly", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryConfigs(Page<ConfigRecord> page,
                            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                            @RequestParam(name = "search", required = false) String search,
                            @RequestParam(name = "id", required = false) Integer id,
                            @RequestParam(name = "userId", required = false) Integer userId,
                            @RequestParam(name = "groupId", required = false) Integer groupId,
                            @RequestParam(name = "name", required = false) String name,
                            @RequestParam(name = "keyName", required = false) String keyName,
                            @RequestParam(name = "valueType", required = false) String valueType,
                            @RequestParam(name = "value", required = false) String value,
                            @RequestParam(name = "type", required = false) String type,
                            @RequestParam(name = "visible", required = false) Integer visible,
                            @RequestParam(name = "description", required = false) String description,
                            @RequestParam(name = "readonly", required = false) Integer readonly,
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

        ConfigRecord record = new ConfigRecord();
        record.setId(id);
        record.setUserId(userId);
        record.setGroupId(groupId);
        record.setName(name);
        record.setKeyName(keyName);
        record.setValueType(valueType);
        record.setValue(value);
        record.setType(type);
        record.setVisible(visible);
        record.setDescription(description);
        record.setReadonly(readonly);
        record.setOrgId(JWTKit.getOrgId());
        page.setRecords(this.configService.findConfigPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }*/
}
