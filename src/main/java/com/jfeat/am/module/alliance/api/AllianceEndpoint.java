package com.jfeat.am.module.alliance.api;


import com.jfeat.crud.plus.META;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.dao.DuplicateKeyException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.am.core.jwt.JWTKit;

import java.math.BigDecimal;

import com.jfeat.am.module.alliance.services.domain.service.AllianceService;
import com.jfeat.am.module.alliance.services.domain.model.AllianceRecord;
import com.jfeat.am.module.alliance.services.gen.persistence.model.Alliance;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.rmi.ServerException;
import java.util.Date;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-10-12
 */
@RestController

@Api("Alliance")
@RequestMapping("/api/alliance/alliances")
public class AllianceEndpoint {


    @Resource
    AllianceService allianceService;

    @BusinessLog(name = "Alliance", value = "update Alliance Status")
    @PutMapping("/changStatus/{id}")
    @ApiOperation(value = "修改 Alliance 状态 0：禁用，1：正常", response = Alliance.class)
    public Tip updateAllianceStatus(@PathVariable Long id) {

        return SuccessTip.create(allianceService.changeStatus(id));
    }

    @BusinessLog(name = "Alliance", value = "update Alliance allianceStoreAmount")
    @PutMapping("/changAmount/{id}")
    @ApiOperation(value = "修改 Alliance 入库金额", response = Alliance.class)
    public Tip updateAllianceStoreAmount(@PathVariable Long id,@RequestParam BigDecimal allianceStoreAmount) {

        return SuccessTip.create(allianceService.changAmount(id,allianceStoreAmount));
    }

    @BusinessLog(name = "Alliance", value = "update Alliance allianceStoreAmount")
    @GetMapping("/findAllianceTags/{id}")
    @ApiOperation(value = "特征标记（库存金额不足） Alliance ", response = Alliance.class)
    public Tip findAllianceTags(@PathVariable Long id) throws ServerException {
        Alliance alliance = allianceService.retrieveMaster(id);
        if((alliance.getAllianceStoreAmount().compareTo(BigDecimal.ZERO))!=1){
            throw new ServerException("库存金额不足");
        }
        return SuccessTip.create();
    }
    @BusinessLog(name = "Alliance", value = "推荐关系图")
    @GetMapping("/findAllianceRecommendationDiagram/{id}")
    @ApiOperation(value = "推荐关系图 Alliance ", response = Alliance.class)
    public Tip findAllianceRecommendationDiagram(@PathVariable Long id) {

        return SuccessTip.create(allianceService.findAllianceRecommendationDiagram(id));
    }
}
