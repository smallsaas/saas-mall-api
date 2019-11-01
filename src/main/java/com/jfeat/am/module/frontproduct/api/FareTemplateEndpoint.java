package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.frontproduct.services.domain.model.FareTemplateModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FareTemplateRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FareTemplateService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.CarryMode;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FareTemplate;
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
import java.util.List;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-31
 */
@RestController

@Api("FareTemplate")
@RequestMapping("/api/crud/product/fareTemplates")
public class FareTemplateEndpoint {


    @Resource
    FareTemplateService fareTemplateService;

    @PostMapping
    @ApiOperation(value = "新建 FareTemplate", response = FareTemplate.class)
    public Tip createFareTemplate(
                                  @RequestBody FareTemplateModel entity) {
        Long orgId = JWTKit.getOrgId();
        if (entity.getOrgId()==null){
            entity.setOrgId(orgId);
        }


        Integer affected = 0;
        try {

            entity.setLastModifiedDate(new Date());
            affected = fareTemplateService.createFareTemplate(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 FareTemplate", response = FareTemplate.class)
    public Tip getFareTemplate(@PathVariable Long id) {
        return SuccessTip.create(fareTemplateService.getFareTemplate(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改 FareTemplate", response = FareTemplate.class)
    public Tip updateFareTemplate(@PathVariable Long id, @RequestBody FareTemplateModel entity) {
        entity.setId(id);
        entity.setLastModifiedDate(new Date());
        return SuccessTip.create(fareTemplateService.updateFareTemplate(entity));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 FareTemplate")
    public Tip deleteFareTemplate(@PathVariable Long id) {
        return SuccessTip.create(fareTemplateService.deleteMaster(id));
    }

    @ApiOperation(value = "FareTemplate 列表信息", response = FareTemplateRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "shopAddr", dataType = "String"),
            @ApiImplicitParam(name = "dispatchTime", dataType = "String"),
            @ApiImplicitParam(name = "isInclPostage", dataType = "Integer"),
            @ApiImplicitParam(name = "valuationModel", dataType = "Integer"),
            @ApiImplicitParam(name = "is_incl_postageByIf", dataType = "Integer"),
            @ApiImplicitParam(name = "lastModifiedDate", dataType = "Date"),
            @ApiImplicitParam(name = "title", dataType = "String"),
            @ApiImplicitParam(name = "content", dataType = "String"),
            @ApiImplicitParam(name = "messageFormat", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryFareTemplates(Page<FareTemplateRecord> page,
                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(name = "search", required = false) String search,
                                  @RequestParam(name = "id", required = false) Long id,
                                  @RequestParam(name = "name", required = false) String name,
                                  @RequestParam(name = "shopAddr", required = false) String shopAddr,
                                  @RequestParam(name = "dispatchTime", required = false) String dispatchTime,
                                  @RequestParam(name = "isInclPostage", required = false) Integer isInclPostage,
                                  @RequestParam(name = "valuationModel", required = false) Integer valuationModel,
                                  @RequestParam(name = "isInclPostageByIf", required = false) Integer isInclPostageByIf,
                                  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date lastModifiedDate,
                                  @RequestParam(name = "title", required = false) String title,
                                  @RequestParam(name = "content", required = false) String content,
                                  @RequestParam(name = "messageFormat", required = false) String messageFormat,
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

        FareTemplateRecord record = new FareTemplateRecord();
        record.setId(id);
        record.setName(name);
        record.setShopAddr(shopAddr);
        record.setDispatchTime(dispatchTime);
        record.setIsInclPostage(isInclPostage);
        record.setValuationModel(valuationModel);
        record.setIsInclPostageByIf(isInclPostageByIf);
        record.setLastModifiedDate(lastModifiedDate);
        record.setTitle(title);
        record.setContent(content);
        record.setOrgId(orgId);
        record.setMessageFormat(messageFormat);
        page.setRecords(this.fareTemplateService.findFareTemplatePage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
