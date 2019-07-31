package com.jfeat.am.module.product.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.InclPostageProvisoRecord;
import com.jfeat.am.module.product.services.domain.service.InclPostageProvisoService;
import com.jfeat.am.module.product.services.gen.persistence.model.InclPostageProviso;
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
 * @since 2019-07-31
 */
@RestController

@Api("InclPostageProviso")
@RequestMapping("/api/crud/product/inclPostageProvisos")
public class InclPostageProvisoEndpoint {


    @Resource
    InclPostageProvisoService inclPostageProvisoService;

    @PostMapping
    @ApiOperation(value = "新建 InclPostageProviso", response = InclPostageProviso.class)
    public Tip createInclPostageProviso(@RequestBody InclPostageProviso entity) {

        Integer affected = 0;
        try {
            affected = inclPostageProvisoService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 InclPostageProviso", response = InclPostageProviso.class)
    public Tip getInclPostageProviso(@PathVariable Long id) {
        return SuccessTip.create(inclPostageProvisoService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 InclPostageProviso", response = InclPostageProviso.class)
    public Tip updateInclPostageProviso(@PathVariable Integer id, @RequestBody InclPostageProviso entity) {
        entity.setId(id);
        return SuccessTip.create(inclPostageProvisoService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 InclPostageProviso")
    public Tip deleteInclPostageProviso(@PathVariable Long id) {
        return SuccessTip.create(inclPostageProvisoService.deleteMaster(id));
    }

    @ApiOperation(value = "InclPostageProviso 列表信息", response = InclPostageProvisoRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "fareId", dataType = "Integer"),
            @ApiImplicitParam(name = "region", dataType = "String"),
            @ApiImplicitParam(name = "pieceNo", dataType = "Integer"),
            @ApiImplicitParam(name = "weightNo", dataType = "Integer"),
            @ApiImplicitParam(name = "bulkNo", dataType = "Integer"),
            @ApiImplicitParam(name = "amount", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "carryWay", dataType = "Integer"),
            @ApiImplicitParam(name = "type", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryInclPostageProvisos(Page<InclPostageProvisoRecord> page,
                                        @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(name = "search", required = false) String search,
                                        @RequestParam(name = "id", required = false) Integer id,
                                        @RequestParam(name = "fareId", required = false) Integer fareId,
                                        @RequestParam(name = "region", required = false) String region,
                                        @RequestParam(name = "pieceNo", required = false) Integer pieceNo,
                                        @RequestParam(name = "weightNo", required = false) Integer weightNo,
                                        @RequestParam(name = "bulkNo", required = false) Integer bulkNo,
                                        @RequestParam(name = "amount", required = false) BigDecimal amount,
                                        @RequestParam(name = "carryWay", required = false) Integer carryWay,
                                        @RequestParam(name = "type", required = false) Integer type,
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

        InclPostageProvisoRecord record = new InclPostageProvisoRecord();
        record.setId(id);
        record.setFareId(fareId);
        record.setRegion(region);
        record.setPieceNo(pieceNo);
        record.setWeightNo(weightNo);
        record.setBulkNo(bulkNo);
        record.setAmount(amount);
        record.setCarryWay(carryWay);
        record.setType(type);
        page.setRecords(this.inclPostageProvisoService.findInclPostageProvisoPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
