
package com.jfeat.am.module.address.api;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jfeat.crud.plus.META;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.address.services.gen.persistence.dao.AddressMapper;
import com.jfeat.am.module.address.services.properties.AddressProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.dao.DuplicateKeyException;
import com.jfeat.am.module.address.services.domain.dao.QueryAddressDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.crud.plus.DefaultFilterResult;
import com.jfeat.am.module.address.api.permission.*;
import com.jfeat.am.common.annotation.Permission;

import java.math.BigDecimal;

import com.jfeat.am.module.address.services.domain.service.*;
import com.jfeat.am.module.address.services.domain.model.AddressRecord;
import com.jfeat.am.module.address.services.gen.persistence.model.Address;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;

/**
 * <p>
 * api
 * </p>
 *
 * @author Code generator
 * @since 2022-08-13
 */
@RestController
@Api("Address")
@RequestMapping("/api/crud/address/address/addresses")
public class AddressEndpoint {

    @Resource
    AddressService addressService;

    @Resource
    QueryAddressDao queryAddressDao;

    @Resource
    AddressProperties addressProperties;

    @Resource
    AddressMapper addressMapper;


    @BusinessLog(name = "Address", value = "create Address")
    @Permission(AddressPermission.ADDRESS_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Address", response = Address.class)
    public Tip createAddress(@RequestBody Address entity) {
        Integer affected = 0;

        if(entity.getUserId()==null){
            throw new BusinessException(BusinessCode.BadRequest,"userId为必填项");
        }

        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq(Address.USER_ID,entity.getUserId());
        List<Address> addressList = addressMapper.selectList(addressQueryWrapper);

        if (addressList!=null&&addressList.size()>=addressProperties.getMaxAddressCount()){
            throw new BusinessException(BusinessCode.CodeBase,"地址数量已上限");
        }

        try {
            affected = addressService.createMaster(entity);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @Permission(AddressPermission.ADDRESS_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Address", response = Address.class)
    public Tip getAddress(@PathVariable Long id) {
        return SuccessTip.create(addressService.queryMasterModel(queryAddressDao, id));
    }

    @BusinessLog(name = "Address", value = "update Address")
    @Permission(AddressPermission.ADDRESS_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Address", response = Address.class)
    public Tip updateAddress(@PathVariable Long id, @RequestBody Address entity) {
        entity.setId(id);
        return SuccessTip.create(addressService.updateMaster(entity));
    }

    @BusinessLog(name = "Address", value = "delete Address")
    @Permission(AddressPermission.ADDRESS_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Address")
    public Tip deleteAddress(@PathVariable Long id) {
        return SuccessTip.create(addressService.deleteMaster(id));
    }

    @Permission(AddressPermission.ADDRESS_VIEW)
    @ApiOperation(value = "Address 列表信息", response = AddressRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "userId", dataType = "Long"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "phone", dataType = "String"),
            @ApiImplicitParam(name = "tel", dataType = "String"),
            @ApiImplicitParam(name = "provinceName", dataType = "String"),
            @ApiImplicitParam(name = "provinceCode", dataType = "String"),
            @ApiImplicitParam(name = "cityName", dataType = "String"),
            @ApiImplicitParam(name = "cityCode", dataType = "String"),
            @ApiImplicitParam(name = "areaName", dataType = "String"),
            @ApiImplicitParam(name = "areaCode", dataType = "String"),
            @ApiImplicitParam(name = "address", dataType = "String"),
            @ApiImplicitParam(name = "zip", dataType = "String"),
            @ApiImplicitParam(name = "defaultStatus", dataType = "Integer"),
            @ApiImplicitParam(name = "createTime", dataType = "Date"),
            @ApiImplicitParam(name = "updateTime", dataType = "Date"),
            @ApiImplicitParam(name = "note", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryAddressPage(Page<AddressRecord> page,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                // for tag feature query
                                @RequestParam(name = "tag", required = false) String tag,
                                // end tag
                                @RequestParam(name = "search", required = false) String search,

                                @RequestParam(name = "userId", required = false) Long userId,

                                @RequestParam(name = "name", required = false) String name,

                                @RequestParam(name = "phone", required = false) String phone,

                                @RequestParam(name = "tel", required = false) String tel,

                                @RequestParam(name = "provinceName", required = false) String provinceName,

                                @RequestParam(name = "provinceCode", required = false) String provinceCode,

                                @RequestParam(name = "cityName", required = false) String cityName,

                                @RequestParam(name = "cityCode", required = false) String cityCode,

                                @RequestParam(name = "areaName", required = false) String areaName,

                                @RequestParam(name = "areaCode", required = false) String areaCode,

                                @RequestParam(name = "address", required = false) String address,

                                @RequestParam(name = "zip", required = false) String zip,

                                @RequestParam(name = "defaultStatus", required = false) Integer defaultStatus,

                                @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                @RequestParam(name = "createTime", required = false) Date createTime,

                                @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                @RequestParam(name = "updateTime", required = false) Date updateTime,

                                @RequestParam(name = "note", required = false) String note,
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

        AddressRecord record = new AddressRecord();
        record.setUserId(userId);
        record.setName(name);
        record.setPhone(phone);
        record.setTel(tel);
        record.setProvinceName(provinceName);
        record.setProvinceCode(provinceCode);
        record.setCityName(cityName);
        record.setCityCode(cityCode);
        record.setAreaName(areaName);
        record.setAreaCode(areaCode);
        record.setAddress(address);
        record.setZip(zip);
        record.setDefaultStatus(defaultStatus);
        record.setCreateTime(createTime);
        record.setUpdateTime(updateTime);
        record.setNote(note);
        List<AddressRecord> addressPage = queryAddressDao.findAddressPage(page, record, tag, search, orderBy, null, null);
        page.setRecords(addressPage);

        return SuccessTip.create(page);
    }



}

