package com.jfeat.am.module.store.api.crud;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.constant.tips.Ids;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.store.services.domain.dao.QueryStoreAssistantDao;
import com.jfeat.am.module.store.services.domain.model.StoreAssistantRecord;
import com.jfeat.am.module.store.services.domain.service.StoreAssistantService;
import com.jfeat.am.module.store.services.persistence.model.StoreAssistant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2018-06-09
 */
@Api("店员api")
@RestController
@RequestMapping("/api/store")
public class StoreAssistantEndpoint extends BaseController {

    @Resource
    StoreAssistantService storeAssistantService;

    @Resource
    QueryStoreAssistantDao queryStoreAssistantDao;

    @ApiOperation(value = "新增店员", response = StoreAssistant.class)
    @BusinessLog(name = "StoreAssistant", value = "create StoreAssistant")
    @PostMapping("/assistants")
    public Tip createStoreAssistant(@RequestBody StoreAssistant entity) {

        Integer affected = 0;
        try {
            affected = storeAssistantService.addStoreAssistant(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @ApiOperation("店员详情")
    @GetMapping("/assistants/{id}")
    public Tip getStoreAssistant(@PathVariable Long id) {
        return SuccessTip.create(storeAssistantService.assistantDetails(id));
    }

    @ApiOperation(value = "修改店员", response = StoreAssistant.class)
    @BusinessLog(name = "StoreAssistant", value = "update StoreAssistant")
    @PutMapping("/assistants/{id}")
    public Tip updateStoreAssistant(@PathVariable Long id, @RequestBody StoreAssistant entity) {
        entity.setId(id);
        return SuccessTip.create(storeAssistantService.updateMaster(entity));
    }

    @ApiOperation(value = "删除店员", response = Ids.class)
    @BusinessLog(name = "StoreAssistant", value = "delete StoreAssistant")
    @PostMapping("/{storeId}/assistants")
    public Tip deleteStoreAssistant(@PathVariable Long storeId,@RequestBody Ids ids) {
        return SuccessTip.create(storeAssistantService.deleteStoreAssistant(storeId,ids));
    }

    @ApiOperation("店员列表")
    @GetMapping("/assistants")
    public Tip queryStoreAssistants(Page<StoreAssistantRecord> page,
                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                    @RequestParam(name = "id", required = false) Long id,
                                    @RequestParam(name = "code", required = false) String code,
                                    @RequestParam(name = "name", required = false) String name,
                                    @RequestParam(name = "avatar", required = false) String avatar,
                                    @RequestParam(name = "position", required = false) String position,
                                    @RequestParam(name = "telephone", required = false) String telephone,
                                    @RequestParam(name = "wechat", required = false) String wechat,
                                    @RequestParam(name = "qq", required = false) String qq,
                                    @RequestParam(name = "status", required = false) String status,
                                    @RequestParam(name = "isDirector", required = false) Integer isDirector,
                                    @RequestParam(name = "directorId", required = false) Long directorId,
                                    @RequestParam(name = "storeId", required = false) Long storeId,
                                    @RequestParam(name = "userId", required = false) Long userId,
                                    @RequestParam(name = "orderBy", required = false) String orderBy,
                                    @RequestParam(name = "sort", required = false) String sort,
                                    @RequestParam(name = "exact", required = false) boolean exact) {
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

        StoreAssistantRecord record = new StoreAssistantRecord();
        record.setId(id);
        record.setCode(code);
        record.setName(name);
        record.setAvatar(avatar);
        record.setPosition(position);
        record.setTelephone(telephone);
        record.setWechat(wechat);
        record.setQq(qq);
        record.setStatus(status);
        record.setIsDirector(isDirector);
        record.setDirectorId(directorId);
        record.setStoreId(storeId);
        record.setUserId(userId);

        page.setRecords(queryStoreAssistantDao.findStoreAssistantPage(page, record, orderBy, exact));

        return SuccessTip.create(page);
    }

    @ApiOperation(value = "批量删除店员", response = Ids.class)
    @PostMapping("/assistants/bulk/delete")
    public Tip deleteList(@RequestBody Ids ids) {
        return SuccessTip.create(storeAssistantService.bulkDelete(ids));
    }

    @ApiOperation("设定某个店员为店长")
    @PutMapping("/{storeId}/assistants/{userId}/action/shopkeeper")
    public Tip assignShopkeeper(@PathVariable Long storeId,@PathVariable Long userId){
        return SuccessTip.create(storeAssistantService.assignShopkeeper(storeId,userId));
    }

    @ApiOperation("删除某个店员")
    @DeleteMapping("/{storeId}/assistants/{assistantId}/action/delete")
    public Tip deleteAssistant(@PathVariable Long storeId,@PathVariable Long assistantId){
        return SuccessTip.create(storeAssistantService.deleteAssistant(storeId,assistantId));
    }

    @ApiOperation("所有的店长")
    @GetMapping("/action/shopkeeper")
    public Tip allShopkeeper(){
        return SuccessTip.create(storeAssistantService.allStoreKeeper());
    }

}
