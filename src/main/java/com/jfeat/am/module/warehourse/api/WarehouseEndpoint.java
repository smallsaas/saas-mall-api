package com.jfeat.am.module.warehourse.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.warehourse.services.domain.model.WarehouseRecord;
import com.jfeat.am.module.warehourse.services.domain.service.WarehouseService;
import com.jfeat.am.module.warehourse.services.gen.persistence.model.Warehouse;
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
 * @since 2019-08-08
 */
@RestController

@Api("Warehouse")
@RequestMapping("/api/crud/store/warehouses")
public class WarehouseEndpoint {


    @Resource
    WarehouseService warehouseService;

    @BusinessLog(name = "Warehouse", value = "create Warehouse")
    @PostMapping
    @ApiOperation(value = "新建 Warehouse", response = Warehouse.class)
    public Tip createWarehouse(@RequestBody Warehouse entity) {

        Integer affected = 0;
        try {
            affected = warehouseService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @BusinessLog(name = "Warehouse", value = "查看 Warehouse")
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Warehouse", response = Warehouse.class)
    public Tip getWarehouse(@PathVariable Long id) {
        return SuccessTip.create(warehouseService.retrieveMaster(id));
    }

    @BusinessLog(name = "Warehouse", value = "update Warehouse")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Warehouse", response = Warehouse.class)
    public Tip updateWarehouse(@PathVariable Long id, @RequestBody Warehouse entity) {
        entity.setId(id);
        return SuccessTip.create(warehouseService.updateMaster(entity));
    }

    @BusinessLog(name = "Warehouse", value = "delete Warehouse")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Warehouse")
    public Tip deleteWarehouse(@PathVariable Long id) {
        return SuccessTip.create(warehouseService.deleteMaster(id));
    }

    @BusinessLog(name = "Warehouse", value = "delete Warehouse")
    @ApiOperation(value = "Warehouse 列表信息", response = WarehouseRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "warehouseCode", dataType = "String"),
            @ApiImplicitParam(name = "warehouseName", dataType = "String"),
            @ApiImplicitParam(name = "warehousePCD", dataType = "String"),
            @ApiImplicitParam(name = "warehouseAddress", dataType = "String"),
            @ApiImplicitParam(name = "warehouseCharger", dataType = "Long"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryWarehouses(Page<WarehouseRecord> page,
                               @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(name = "search", required = false) String search,
                               @RequestParam(name = "id", required = false) Long id,
                               @RequestParam(name = "warehouseCode", required = false) String warehouseCode,
                               @RequestParam(name = "warehouseName", required = false) String warehouseName,
                               @RequestParam(name = "warehousePCD", required = false) String warehousePCD,
                               @RequestParam(name = "warehouseAddress", required = false) String warehouseAddress,
                               @RequestParam(name = "warehouseCharger", required = false) Long warehouseCharger,
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

        WarehouseRecord record = new WarehouseRecord();
        record.setId(id);
        record.setWarehouseCode(warehouseCode);
        record.setWarehouseName(warehouseName);
        record.setWarehousePCD(warehousePCD);
        record.setWarehouseAddress(warehouseAddress);
        record.setWarehouseCharger(warehouseCharger);
        record.setOrgId(JWTKit.getOrgId());
        page.setRecords(this.warehouseService.findWarehousePage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
