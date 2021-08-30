package com.jfeat.am.module.order.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.module.order.definition.ExpressPermission;
import com.jfeat.am.module.order.services.domain.model.ExpressRecord;
import com.jfeat.am.module.order.services.domain.service.ExpressService;
import com.jfeat.am.module.order.services.gen.persistence.model.Express;
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
 * @since 2019-08-01
 */
@RestController

@Api("Express")
@RequestMapping("/api/crud/order/expresses")
public class ExpressEndpoint {


    @Resource
    ExpressService expressService;

    @PostMapping
    @ApiOperation(value = "新建 快递", response = Express.class)
    @Permission(ExpressPermission.EXPRESS_ADD)
    public Tip createExpress(@RequestBody Express entity) {

        Integer affected = 0;
        try {
            if(entity.getIsDefault()==1){
                expressService.updateIsDefault();
            }
            affected = expressService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 快递", response = Express.class)
    @Permission(ExpressPermission.EXPRESS_VIEW)
    public Tip getExpress(@PathVariable Long id) {
        return SuccessTip.create(expressService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Express", response = Express.class)
    @Permission(ExpressPermission.EXPRESS_EDIT)
    public Tip updateExpress(@PathVariable Long id, @RequestBody Express entity) {
        entity.setId(id);
        if(entity.getIsDefault()==1){
            expressService.updateIsDefault();
        }
        return SuccessTip.create(expressService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 Express")
    @Permission(ExpressPermission.EXPRESS_DEL)
    public Tip deleteExpress(@PathVariable Long id) {
        return SuccessTip.create(expressService.deleteMaster(id));
    }


    @ApiOperation(value = "Express 列表信息", response = ExpressRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "code", dataType = "String"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "enabled", dataType = "Integer"),
            @ApiImplicitParam(name = "isDefault", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    @Permission(ExpressPermission.EXPRESS_VIEW)
    public Tip queryExpresses(Page<ExpressRecord> page,
                              @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(name = "search", required = false) String search,
                              @RequestParam(name = "id", required = false) Long id,
                              @RequestParam(name = "code", required = false) String code,
                              @RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "enabled", required = false) Integer enabled,
                              @RequestParam(name = "isDefault", required = false) Integer isDefault,
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

        ExpressRecord record = new ExpressRecord();
        record.setId(id);
        record.setCode(code);
        record.setName(name);
        record.setEnabled(enabled);
        record.setIsDefault(isDefault);
        record.setOrgId(orgId);
        page.setRecords(this.expressService.findExpressPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
