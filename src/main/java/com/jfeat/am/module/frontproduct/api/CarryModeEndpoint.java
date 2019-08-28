package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.CarryModeRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.CarryModeService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.CarryMode;
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
import java.math.BigDecimal;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-08-01
 */
@RestController

@Api("CarryMode")
@RequestMapping("/api/crud/product/carryModes")
public class CarryModeEndpoint {


    @Resource
    CarryModeService carryModeService;

    @PostMapping
    @ApiOperation(value = "新建 CarryMode", response = CarryMode.class)
    public Tip createCarryMode(@RequestBody CarryMode entity) {

        Integer affected = 0;
        try {
            affected = carryModeService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 CarryMode", response = CarryMode.class)
    public Tip getCarryMode(@PathVariable Long id) {
        return SuccessTip.create(carryModeService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 CarryMode", response = CarryMode.class)
    public Tip updateCarryMode(@PathVariable Long id, @RequestBody CarryMode entity) {
        entity.setId(id);
        return SuccessTip.create(carryModeService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 CarryMode")
    public Tip deleteCarryMode(@PathVariable Long id) {
        return SuccessTip.create(carryModeService.deleteMaster(id));
    }

    @ApiOperation(value = "CarryMode 列表信息", response = CarryModeRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "fareId", dataType = "Integer"),
            @ApiImplicitParam(name = "region", dataType = "String"),
            @ApiImplicitParam(name = "firstPiece", dataType = "Integer"),
            @ApiImplicitParam(name = "firstWeight", dataType = "Integer"),
            @ApiImplicitParam(name = "firstBulk", dataType = "Integer"),
            @ApiImplicitParam(name = "firstAmount", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "secondPiece", dataType = "Integer"),
            @ApiImplicitParam(name = "secondWeight", dataType = "Integer"),
            @ApiImplicitParam(name = "secondBulk", dataType = "Integer"),
            @ApiImplicitParam(name = "secondAmount", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "carryWay", dataType = "Integer"),
            @ApiImplicitParam(name = "isDefault", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryCarryModes(Page<CarryModeRecord> page,
                               @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(name = "search", required = false) String search,
                               @RequestParam(name = "id", required = false) Long id,
                               @RequestParam(name = "fareId", required = false) Long fareId,
                               @RequestParam(name = "region", required = false) String region,
                               @RequestParam(name = "firstPiece", required = false) Integer firstPiece,
                               @RequestParam(name = "firstWeight", required = false) Integer firstWeight,
                               @RequestParam(name = "firstBulk", required = false) Integer firstBulk,
                               @RequestParam(name = "firstAmount", required = false) BigDecimal firstAmount,
                               @RequestParam(name = "secondPiece", required = false) Integer secondPiece,
                               @RequestParam(name = "secondWeight", required = false) Integer secondWeight,
                               @RequestParam(name = "secondBulk", required = false) Integer secondBulk,
                               @RequestParam(name = "secondAmount", required = false) BigDecimal secondAmount,
                               @RequestParam(name = "carryWay", required = false) Integer carryWay,
                               @RequestParam(name = "isDefault", required = false) Integer isDefault,
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

        CarryModeRecord record = new CarryModeRecord();
        record.setId(id);
        record.setFareId(fareId);
        record.setRegion(region);
        record.setFirstPiece(firstPiece);
        record.setFirstWeight(firstWeight);
        record.setFirstBulk(firstBulk);
        record.setFirstAmount(firstAmount);
        record.setSecondPiece(secondPiece);
        record.setSecondWeight(secondWeight);
        record.setSecondBulk(secondBulk);
        record.setSecondAmount(secondAmount);
        record.setCarryWay(carryWay);
        record.setIsDefault(isDefault);
        page.setRecords(this.carryModeService.findCarryModePage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
