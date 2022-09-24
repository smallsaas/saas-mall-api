package com.jfeat.am.module.supplier.api.app;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.supplier.api.permission.SupplierPermission;
import com.jfeat.am.module.supplier.services.domain.dao.QuerySupplierDao;
import com.jfeat.am.module.supplier.services.domain.model.SupplierBindModel;
import com.jfeat.am.module.supplier.services.domain.model.SupplierModel;
import com.jfeat.am.module.supplier.services.domain.model.SupplierRecord;
import com.jfeat.am.module.supplier.services.domain.service.SupplierService;
import com.jfeat.am.module.supplier.services.gen.persistence.model.Supplier;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.plus.META;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api("UserSupplierEndpoint")
@RequestMapping("/api/u/supplier")
public class UserSupplierEndpoint {


    @Resource
    SupplierService supplierService;


    @Resource
    QuerySupplierDao querySupplierDao;

    @BusinessLog(name = "Supplier", value = "create Supplier")
    @Permission(SupplierPermission.SUPPLIER_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Supplier", response = Supplier.class)
    public Tip createSupplier(@RequestBody SupplierModel entity) {
        Supplier one = null;
        try {

            one = supplierService.createOne(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(one);
    }

    @Permission(SupplierPermission.SUPPLIER_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Supplier", response = SupplierRecord.class)
    public Tip getSupplier(@PathVariable Long id) {
        return SuccessTip.create(supplierService.getOne(id));
    }


    @GetMapping("/genAccountTest")
    @ApiOperation(value = "", response = Supplier.class)
    public Tip getSupplier(@RequestParam(value = "account") String account) {
        return SuccessTip.create(supplierService.genAccountName(account));
    }


    @BusinessLog(name = "Supplier", value = "update Supplier")
    @Permission(SupplierPermission.SUPPLIER_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Supplier", response = Supplier.class)
    public Tip updateSupplier(@PathVariable Long id, @RequestBody Supplier entity) {
        entity.setId(id);
        return SuccessTip.create(supplierService.updateMaster(entity));
    }

    @BusinessLog(name = "Supplier", value = "delete Supplier")
    @Permission(SupplierPermission.SUPPLIER_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Supplier")
    public Tip deleteSupplier(@PathVariable Long id) {
        return SuccessTip.create(supplierService.deleteOne(id));
    }

    @ApiOperation(value = "Supplier 列表信息", response = SupplierRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "note", dataType = "String"),
            @ApiImplicitParam(name = "type", dataType = "Integer"),
            @ApiImplicitParam(name = "url", dataType = "String"),
            @ApiImplicitParam(name = "address", dataType = "String"),
            @ApiImplicitParam(name = "orgId", dataType = "Long"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip querySuppliers(Page<SupplierRecord> page,
                              @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(name = "search", required = false) String search,
                              @RequestParam(name = "id", required = false) Long id,

                              @RequestParam(name = "name", required = false) String name,

                              @RequestParam(name = "note", required = false) String note,

                              @RequestParam(name = "type", required = false) Integer type,

                              @RequestParam(name = "url", required = false) String url,

                              @RequestParam(name = "address", required = false) String address,

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

        SupplierRecord record = new SupplierRecord();
        record.setId(id);
        record.setName(name);
        record.setNote(note);
        record.setType(type);
        record.setUrl(url);
        record.setAddress(address);
        if (META.enabledSaas()) {
            record.setOrgId(JWTKit.getOrgId());
        }


        List<SupplierRecord> supplierPage = querySupplierDao.findSupplierPage(page, record, search, orderBy, null, null);

        page.setRecords(supplierPage);

        return SuccessTip.create(page);
    }

    @PutMapping("/bind/{id}")
    public Tip BindSupplier(@PathVariable Long id,@RequestBody SupplierBindModel supplierBindModel){
        supplierBindModel.setSupplierId(id);
        Integer integer = supplierService.bindSupplier(supplierBindModel);
        return SuccessTip.create(integer);
    }

    @PutMapping("/unBind/{id}")
    public Tip UnBindSupplier(@PathVariable Long id,@RequestBody SupplierBindModel supplierBindModel){
        supplierBindModel.setSupplierId(id);
        Integer integer = supplierService.unBind(supplierBindModel);
        return SuccessTip.create(integer);
    }
}
