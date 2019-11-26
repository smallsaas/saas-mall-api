package com.jfeat.am.module.frontproduct.patch;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductService;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hero
 * @date 18:05
 */
@Deprecated
@RestController
@Api("FrontProduct")
@RequestMapping("/api/pub/product/products")
public class ProductPatchEndpoint {

    @Resource
    FrontProductService frontProductService;

    @ApiOperation(value = "FrontProduct 列表信息", response = FrontProductRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "categoryId", dataType = "Integer"),
            @ApiImplicitParam(name = "brandId", dataType = "Integer"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "shortName", dataType = "String"),
            @ApiImplicitParam(name = "cover", dataType = "String"),
            @ApiImplicitParam(name = "stockBalance", dataType = "Integer"),
            @ApiImplicitParam(name = "sales", dataType = "Integer"),
            @ApiImplicitParam(name = "createdDate", dataType = "Date"),
            @ApiImplicitParam(name = "lastModifiedDate", dataType = "Date"),
            @ApiImplicitParam(name = "unit", dataType = "String"),
            @ApiImplicitParam(name = "price", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "costPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "suggestedPrice", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "promoted", dataType = "Integer"),
            @ApiImplicitParam(name = "freight", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "freeShipping", dataType = "Integer"),
            @ApiImplicitParam(name = "sortOrder", dataType = "Integer"),
            @ApiImplicitParam(name = "partnerLevelZone", dataType = "Integer"),
            @ApiImplicitParam(name = "viewCount", dataType = "Long"),
            @ApiImplicitParam(name = "fareId", dataType = "Integer"),

            @ApiImplicitParam(name = "storeLocation", dataType = "String"),
            @ApiImplicitParam(name = "weight", dataType = "Integer"),
            @ApiImplicitParam(name = "bulk", dataType = "Integer"),
            @ApiImplicitParam(name = "skuId", dataType = "String"),
            @ApiImplicitParam(name = "skuName", dataType = "String"),
            @ApiImplicitParam(name = "skuCode", dataType = "String"),
            @ApiImplicitParam(name = "barCode", dataType = "String"),
            @ApiImplicitParam(name = "mid", dataType = "Integer"),
            @ApiImplicitParam(name = "allowCoupon", dataType = "Integer"),
            @ApiImplicitParam(name = "credit", dataType = "Integer"),
            @ApiImplicitParam(name = "isVirtual", dataType = "Integer"),
            @ApiImplicitParam(name = "requiredParticipateExam", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProducts(Page<FrontProductRecord> page,
                             @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                             @RequestParam(name = "search", required = false) String search,
                             @RequestParam(name = "id", required = false) Long id,
                             @RequestParam(name = "categoryId", required = false) Integer categoryId,
                             @RequestParam(name = "brandId", required = false) Integer brandId,
                             @RequestParam(name = "name", required = false) String name,
                             @RequestParam(name = "shortName", required = false) String shortName,
                             @RequestParam(name = "cover", required = false) String cover,
                             @RequestParam(name = "stockBalance", required = false) Integer stockBalance,
                             @RequestParam(name = "sales", required = false) Integer sales,
                             @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date createdDate,
                             @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date lastModifiedDate,
                             @RequestParam(name = "unit", required = false) String unit,
                             @RequestParam(name = "price", required = false) BigDecimal price,
                             @RequestParam(name = "costPrice", required = false) BigDecimal costPrice,
                             @RequestParam(name = "suggestedPrice", required = false) BigDecimal suggestedPrice,
                             @RequestParam(name = "promoted", required = false) Integer promoted,
                             @RequestParam(name = "freight", required = false) BigDecimal freight,
                             @RequestParam(name = "freeShipping", required = false) Integer freeShipping,
                             @RequestParam(name = "sortOrder", required = false) Integer sortOrder,
                             @RequestParam(name = "partnerLevelZone", required = false) Integer partnerLevelZone,
                             @RequestParam(name = "viewCount", required = false) Long viewCount,
                             @RequestParam(name = "fareId", required = false) Integer fareId,

                             @RequestParam(name = "storeLocation", required = false) String storeLocation,
                             @RequestParam(name = "weight", required = false) Integer weight,
                             @RequestParam(name = "bulk", required = false) Integer bulk,
                             @RequestParam(name = "skuId", required = false) String skuId,
                             @RequestParam(name = "skuName", required = false) String skuName,
                             @RequestParam(name = "skuCode", required = false) String skuCode,
                             @RequestParam(name = "barcode", required = false) String barcode,
                             @RequestParam(name = "brandName", required = false) String brandName,
                             @RequestParam(name = "mid", required = false) Integer mid,
                             @RequestParam(name = "allowCoupon", required = false) Integer allowCoupon,
                             @RequestParam(name = "credit", required = false) Integer credit,
                             @RequestParam(name = "isVirtual", required = false) Integer isVirtual,
                             @RequestParam(name = "requiredParticipateExam", required = false) Integer requiredParticipateExam,
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

        FrontProductRecord record = new FrontProductRecord();
        record.setId(id);
        record.setCategoryId(categoryId);
        record.setBrandId(brandId);
        record.setName(name);
        record.setShortName(shortName);
        record.setCover(cover);
        record.setStockBalance(stockBalance);
        record.setSales(sales);
        //产品为上架
        record.setStatus("ONSELL");
        record.setCreatedDate(createdDate);
        record.setLastModifiedDate(lastModifiedDate);
        record.setUnit(unit);
        record.setPrice(price);
        record.setCostPrice(costPrice);
        record.setSuggestedPrice(suggestedPrice);
        record.setPromoted(promoted);
        record.setFreight(freight);
        record.setFreeShipping(freeShipping);
        record.setSortOrder(sortOrder);
        record.setPartnerLevelZone(partnerLevelZone);
        record.setViewCount(viewCount);
        record.setFareId(fareId);

        record.setStoreLocation(storeLocation);
        record.setWeight(weight);
        record.setBulk(bulk);
        record.setSkuId(skuId);
        record.setSkuName(skuName);
        record.setSkuCode(skuCode);
        record.setBarcode(barcode);
        record.setBrandName(brandName);
        record.setMid(mid);
        record.setAllowCoupon(allowCoupon);
        record.setCredit(credit);

        record.setIsVirtual(isVirtual);
        record.setRequiredParticipateExam(requiredParticipateExam);
        page.setRecords(this.frontProductService.findProductPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }

}
