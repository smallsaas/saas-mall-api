package com.jfeat.am.module.order.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.model.TrialApplicationRecord;
import com.jfeat.am.module.order.services.domain.service.TrialApplicationService;
import com.jfeat.am.module.order.services.gen.persistence.model.TrialApplication;
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

@Api("TrialApplication")
@RequestMapping("/api/crud/order/trialApplications")
public class TrialApplicationEndpoint {


    @Resource
    TrialApplicationService trialApplicationService;

    @PostMapping
    @ApiOperation(value = "新建 TrialApplication", response = TrialApplication.class)
    public Tip createTrialApplication(@RequestBody TrialApplication entity) {

        Integer affected = 0;
        try {
            affected = trialApplicationService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 TrialApplication", response = TrialApplication.class)
    public Tip getTrialApplication(@PathVariable Long id) {
        return SuccessTip.create(trialApplicationService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 TrialApplication", response = TrialApplication.class)
    public Tip updateTrialApplication(@PathVariable Long id, @RequestBody TrialApplication entity) {
        entity.setId(id);
        return SuccessTip.create(trialApplicationService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 TrialApplication")
    public Tip deleteTrialApplication(@PathVariable Long id) {
        return SuccessTip.create(trialApplicationService.deleteMaster(id));
    }

    @ApiOperation(value = "TrialApplication 列表信息", response = TrialApplicationRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "trialId", dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", dataType = "Integer"),
            @ApiImplicitParam(name = "orderNumber", dataType = "String"),
            @ApiImplicitParam(name = "userId", dataType = "Integer"),
            @ApiImplicitParam(name = "createdTime", dataType = "Date"),
            @ApiImplicitParam(name = "status", dataType = "String"),
            @ApiImplicitParam(name = "shippingType", dataType = "Integer"),
            @ApiImplicitParam(name = "note", dataType = "String"),
            @ApiImplicitParam(name = "version", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryTrialApplications(Page<TrialApplicationRecord> page,
                                      @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                      @RequestParam(name = "search", required = false) String search,
                                      @RequestParam(name = "id", required = false) Long id,
                                      @RequestParam(name = "trialId", required = false) Integer trialId,
                                      @RequestParam(name = "orderId", required = false) Integer orderId,
                                      @RequestParam(name = "orderNumber", required = false) String orderNumber,
                                      @RequestParam(name = "userId", required = false) Integer userId,
                                      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date createdTime,
                                      @RequestParam(name = "status", required = false) String status,
                                      @RequestParam(name = "shippingType", required = false) Integer shippingType,
                                      @RequestParam(name = "note", required = false) String note,
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

        TrialApplicationRecord record = new TrialApplicationRecord();
        record.setId(id);
        record.setTrialId(trialId);
        record.setOrderId(orderId);
        record.setOrderNumber(orderNumber);
        record.setUserId(userId);
        record.setCreatedTime(createdTime);
        record.setStatus(status);
        record.setShippingType(shippingType);
        record.setNote(note);
        record.setVersion(version);
        record.setOrgId(orgId);
        page.setRecords(this.trialApplicationService.findTrialApplicationPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
