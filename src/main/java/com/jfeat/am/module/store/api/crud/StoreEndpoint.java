package com.jfeat.am.module.store.api.crud;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.constant.tips.ErrorTip;
import com.jfeat.am.common.constant.tips.Ids;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.appointment.services.domain.service.AppointmentTypeService;
import com.jfeat.am.module.appointment.services.persistence.model.AppointmentType;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.store.services.domain.dao.QueryStoreDao;
import com.jfeat.am.module.store.services.domain.model.StoreModel;
import com.jfeat.am.module.store.services.domain.model.StoreRecord;
import com.jfeat.am.module.store.services.domain.service.StoreService;
import com.jfeat.am.module.store.services.persistence.model.Store;
import com.jfeat.images.services.domain.service.StockImagesService;
import com.jfeat.images.services.persistence.model.StockImages;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2018-06-09
 */
@Api("店铺api")
@RestController
@RequestMapping("/api/store")
public class StoreEndpoint extends BaseController {

    @Resource
    StoreService storeService;

    @Resource
    QueryStoreDao queryStoreDao;
    @Resource
    StockImagesService stockImagesService;
    @Resource
    AppointmentTypeService appointmentTypeService;

    /*@Resource
    StoreDeleteSender storeDeleteSender;*/

    @ApiOperation(value = "新增店铺", response = Store.class)
    @BusinessLog(name = "Store", value = "create Store")
    @PostMapping("/stores")
    public Tip createStore(@RequestBody StoreModel entity) {
        Integer result = storeService.createStore(entity);

        return SuccessTip.create(result);
    }

    @ApiOperation("店铺详情")
    @GetMapping("/stores/{id}")
    public Tip getStore(@PathVariable Long id,
                        @RequestParam(name = "longitude", required = false) BigDecimal longitude,
                        @RequestParam(name = "latitude", required = false) BigDecimal latitude) {
        StoreRecord store = storeService.findStoreInfo(id,latitude, longitude);

        if (store == null) {
            return ErrorTip.create(404, "商店不存在");
        }
        JSONObject object = JSON.parseObject(JSON.toJSONString(store));
        List<StockImages> images = stockImagesService.findOwnerImages(id,store.getType());
        List<AppointmentType> types = appointmentTypeService.findAppointmentType(id);
        object.put("appointmentTypes",types);
        object.put("images",images);
        //TODO
        return SuccessTip.create(object);
    }

    @PostMapping("/stores/{id}/action/business")   //BUSINESS | CLOSED | REST
    @ApiOperation("店铺状态改为business")
    public Tip toBusiness(@PathVariable("id") Long id) {
        return SuccessTip.create(queryStoreDao.toBusiness(id));
    }

    @PostMapping("/stores/{id}/action/closed")   //BUSINESS | CLOSED | REST
    @ApiOperation("店铺状态改为closed")
    public Tip toClosed(@PathVariable("id") Long id) {
        return SuccessTip.create(queryStoreDao.toClosed(id));
    }

    @PostMapping("/stores/{id}/action/rest")   //BUSINESS | CLOSED | REST
    @ApiOperation("店铺状态改为rest")
    public Tip toRest(@PathVariable("id") Long id) {
        return SuccessTip.create(queryStoreDao.toRest(id));
    }

    @ApiOperation(value = "修改店铺", response = Store.class)
    @BusinessLog(name = "Store", value = "update Store")
    @PutMapping("/stores/{id}")
    public Tip updateStore(@PathVariable Long id, @RequestBody StoreModel entity) {
        Integer result = storeService.updateStore(id,entity);

        return SuccessTip.create(result);
    }

    @ApiOperation("删除店铺")
    @BusinessLog(name = "Store", value = "delete Store")
    @DeleteMapping("/stores/{id}")
    public Tip deleteStore(@PathVariable Long id) {
        //delete images
        Integer affacted = 0;
        Store store = storeService.retrieveMaster(id);
        if(store != null) {
            affacted += stockImagesService.updateImage(id,"Store",null);
            affacted += storeService.deleteMaster(id);

            /*storeDeleteSender.sendDeleteMessage(Arrays.asList(store.getCode()));*/
        }

        return SuccessTip.create(affacted);
    }

    @ApiOperation("店铺列表-如需附近的店铺，需获取用户的经纬度，使用longitude/latitude去接收值，以问号的形式挂参数查询 status=BUSINESS | CLOSED | REST")
    @GetMapping("/stores")
    public Tip queryAllStores(Page<StoreRecord> page,
                              @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(name = "id", required = false) Long id,
                              @RequestParam(name = "warehouseId", required = false) Long warehouseId,
                              @RequestParam(name = "type", required = false) String[] type,
                              @RequestParam(name = "code", required = false) String code,
                              @RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "avatar", required = false) String avatar,
                              @RequestParam(name = "director", required = false) String director,
                              @RequestParam(name = "longitude", required = false) BigDecimal longitude,
                              @RequestParam(name = "latitude", required = false) BigDecimal latitude,
                              @RequestParam(name = "address", required = false) String address,
                              @RequestParam(name = "pcd", required = false) String pcd,
                              @RequestParam(name = "province", required = false) String province,
                              @RequestParam(name = "city", required = false) String city,
                              @RequestParam(name = "district", required = false) String district,
                              @RequestParam(name = "introduce", required = false) String introduce,
                              @RequestParam(name = "telephone", required = false) String telephone,
                              @RequestParam(name = "createTime", required = false)
                                  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date[] createTime,
                              @RequestParam(name = "orderBy", required = false) String orderBy,
                              @RequestParam(name = "sort", required = false) String sort,
                              @RequestParam(name = "status", required = false) String[] status,
                              @RequestParam(name = "search", required = false) String search,
                              @RequestParam(name = "exact", required = false) boolean exact
    ) {
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

        StoreRecord record = new StoreRecord();
        record.setId(id);
        record.setWarehouseId(warehouseId);
        record.setCode(code);
        record.setName(name);
        record.setAvatar(avatar);
        record.setPcd(pcd);
        record.setProvince(province);
        record.setCity(city);
        record.setDistrict(district);
        record.setDirector(director);
        record.setAddress(address);
        record.setIntroduce(introduce);
        record.setTelephone(telephone);
        record.setExact(exact);
        //record.setCreateTime(createTime);
        //record.setStatus(status);   //BUSINESS | CLOSED | REST
        Date startTime = (createTime!=null && createTime.length == 2)? createTime[0] : null;
        Date endTime = (createTime!=null && createTime.length == 2)? createTime[1] : null;
        page.setRecords(queryStoreDao.findStorePage(page, record, orderBy, latitude, longitude, search,startTime,endTime, type, status));
        return SuccessTip.create(page);
    }


    @ApiOperation("批量删除")
    @PostMapping("/bulk/delete")
    public Tip deleteList(@RequestBody Ids ids) {
        return SuccessTip.create(storeService.bulkDelete(ids));
    }

}
