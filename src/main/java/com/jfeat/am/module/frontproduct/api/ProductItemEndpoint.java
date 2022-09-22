
package com.jfeat.am.module.frontproduct.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductItemDao;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductItemRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductItemService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductItem;
import com.jfeat.crud.base.annotation.BusinessLog;
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
 * @author Code generator
 * @since 2022-09-20
 */
@RestController
@Api("ProductItem")
@RequestMapping("/api/crud/frontproduct/productItem/productItems")
public class ProductItemEndpoint {

    @Resource
    ProductItemService productItemService;

    @Resource
    QueryProductItemDao queryProductItemDao;


    @BusinessLog(name = "ProductItem", value = "create ProductItem")
    @PostMapping
    @ApiOperation(value = "新建 ProductItem", response = ProductItem.class)
    public Tip createProductItem(@RequestBody ProductItem entity) {
        Integer affected = 0;
        try {
            affected = productItemService.createMaster(entity);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ProductItem", response = ProductItem.class)
    public Tip getProductItem(@PathVariable Long id) {
        return SuccessTip.create(productItemService.queryMasterModel(queryProductItemDao, id));
    }

    @BusinessLog(name = "ProductItem", value = "update ProductItem")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ProductItem", response = ProductItem.class)
    public Tip updateProductItem(@PathVariable Long id, @RequestBody ProductItem entity) {
        entity.setId(id);
        return SuccessTip.create(productItemService.updateMaster(entity));
    }

    @BusinessLog(name = "ProductItem", value = "delete ProductItem")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 ProductItem")
    public Tip deleteProductItem(@PathVariable Long id) {
        return SuccessTip.create(productItemService.deleteMaster(id));
    }

    @ApiOperation(value = "ProductItem 列表信息", response = ProductItemRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "parentId", dataType = "Long"),
            @ApiImplicitParam(name = "childId", dataType = "Long"),
            @ApiImplicitParam(name = "note", dataType = "String"),
            @ApiImplicitParam(name = "createTime", dataType = "Date"),
            @ApiImplicitParam(name = "updateTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryProductItemPage(Page<ProductItemRecord> page,
                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                    // for tag feature query
                                    @RequestParam(name = "tag", required = false) String tag,
                                    // end tag
                                    @RequestParam(name = "search", required = false) String search,

                                    @RequestParam(name = "parentId", required = false) Long parentId,

                                    @RequestParam(name = "childId", required = false) Long childId,

                                    @RequestParam(name = "note", required = false) String note,

                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                    @RequestParam(name = "createTime", required = false) Date createTime,

                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                    @RequestParam(name = "updateTime", required = false) Date updateTime,
                                    @RequestParam(name = "orderBy", required = false) String orderBy,
                                    @RequestParam(name = "sort", required = false) String sort) {

        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String sortPattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(sortPattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        ProductItemRecord record = new ProductItemRecord();
        record.setParentId(parentId);
        record.setChildId(childId);
        record.setNote(note);
        record.setCreateTime(createTime);
        record.setUpdateTime(updateTime);


        List<ProductItemRecord> productItemPage = queryProductItemDao.findProductItemPage(page, record, tag, search, orderBy, null, null);


        page.setRecords(productItemPage);

        return SuccessTip.create(page);
    }
}

