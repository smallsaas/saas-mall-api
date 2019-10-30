package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.frontproduct.services.domain.model.TrialRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.TrialOverModelService;
import com.jfeat.am.module.frontproduct.services.gen.crud.model.TrialModel;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-08-02
 */
@RestController

@Api("Trial")
@RequestMapping("/api/crud/product/trials")
public class TrialEndpoint {


    @Resource
    TrialOverModelService trialOverModelService;

    @PostMapping
    @ApiOperation(value = "新建 Trial", response = TrialModel.class)
    public Tip createTrial(@RequestBody TrialModel entity) {

       //JWTKit.getOrgId()
        if(entity.getOrgId()==null){
            entity.setOrgId(JWTKit.getOrgId());
        }
        Integer affected = 0;
        try {

            affected = trialOverModelService.createTrial(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Trial", response = TrialModel.class)
    public Tip getTrial(@PathVariable Long id) {
        TrialModel entity = trialOverModelService.getTrial(id);
        return SuccessTip.create(entity);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Trial", response = TrialModel.class)
    public Tip updateTrial(@PathVariable Long id, @RequestBody TrialModel entity) {
        entity.setId(id);
        return SuccessTip.create(trialOverModelService.updateMaster(entity, null, null, null));
    }

    @PostMapping("/{id}/{status}")
    @ApiOperation(value = "修改 Trial", response = TrialModel.class)
    public Tip updateTrialStatus(@PathVariable Long id, @PathVariable Integer status) {
        return SuccessTip.create(trialOverModelService.updateTrialStatus(id,status));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 Trial")
    public Tip deleteTrial(@PathVariable Long id) {
        return SuccessTip.create(trialOverModelService.deleteMaster(id));
    }

    @ApiOperation(value = "Trial 列表信息", response = TrialRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "productId", dataType = "Integer"),
            @ApiImplicitParam(name = "price", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "shortNote", dataType = "String"),
            @ApiImplicitParam(name = "enabled", dataType = "Integer"),
            @ApiImplicitParam(name = "startTime", dataType = "Date"),
            @ApiImplicitParam(name = "endTime", dataType = "Date"),
            @ApiImplicitParam(name = "cover", dataType = "String"),
            @ApiImplicitParam(name = "note", dataType = "String"),
            @ApiImplicitParam(name = "index", dataType = "Integer"),
            @ApiImplicitParam(name = "shippingType", dataType = "Integer"),
            @ApiImplicitParam(name = "paymentType", dataType = "String"),
            @ApiImplicitParam(name = "version", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryTrials(Page<TrialRecord> page,
                           @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                           @RequestParam(name = "search", required = false) String search,
                           @RequestParam(name = "id", required = false) Long id,
                           @RequestParam(name = "productId", required = false) Integer productId,
                           @RequestParam(name = "price", required = false) BigDecimal price,
                           @RequestParam(name = "name", required = false) String name,
                           @RequestParam(name = "shortNote", required = false) String shortNote,
                           @RequestParam(name = "enabled", required = false) Integer enabled,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime,
                           @RequestParam(name = "cover", required = false) String cover,
                           @RequestParam(name = "note", required = false) String note,
                           @RequestParam(name = "sortNum", required = false) Integer sortNum,
                           @RequestParam(name = "shippingType", required = false) Integer shippingType,
                           @RequestParam(name = "paymentType", required = false) String paymentType,
                           @RequestParam(name = "version", required = false) Integer version,
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

        TrialRecord record = new TrialRecord();
        record.setId(id);
        record.setProductId(productId);
        record.setPrice(price);
        record.setName(name);
        record.setShortNote(shortNote);
        record.setEnabled(enabled);
        record.setStartTime(startTime);
        record.setEndTime(endTime);
        record.setCover(cover);
        record.setNote(note);
        record.setSortNum(sortNum);
        record.setShippingType(shippingType);
        record.setPaymentType(paymentType);
        record.setVersion(version);
        record.setOrgId(orgId);
        page.setRecords(this.trialOverModelService.findTrialPage(page, record, search, orderBy, null, null));
        SuccessTip tip=SuccessTip.create(page);

        return tip;
    }

}
