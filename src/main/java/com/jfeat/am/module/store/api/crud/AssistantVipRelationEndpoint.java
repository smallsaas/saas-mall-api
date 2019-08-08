package com.jfeat.am.module.store.api.crud;

import com.jfeat.am.common.constant.tips.Ids;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.store.services.domain.service.AssistantVipRelationService;
import com.jfeat.am.module.store.services.persistence.model.AssistantVipRelation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2018-08-17
 */
@RestController
@Api("Store-店员与会员的关联")
@RequestMapping("/api/store/assistants/vip/relations")
public class AssistantVipRelationEndpoint extends BaseController {


    @Resource
    AssistantVipRelationService assistantVipRelationService;


    @BusinessLog(name = "AssistantVipRelation", value = "create AssistantVipRelation")
    @PostMapping
    @ApiOperation("添加店员与会员的关联")
    public Tip createAssistantVipRelation(@RequestBody AssistantVipRelation entity) {

        Integer affected = 0;
        try {
            affected = assistantVipRelationService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @BusinessLog(name = "AssistantVipRelation", value = "delete AssistantVipRelation")
    @PostMapping("/delete")
    @ApiOperation("删除店员与会员的关联")
    public Tip deleteAssistantVipRelation(@RequestBody AssistantVipRelation entity) {
        return SuccessTip.create(assistantVipRelationService.deleteRelation(entity));
    }


    @Deprecated
    @PostMapping("/bulk/delete")
    public Tip deleteList(@RequestBody Ids ids) {
        return SuccessTip.create(assistantVipRelationService.bulkDelete(ids));
    }

}
