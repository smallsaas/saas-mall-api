package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FareTemplateModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FareTemplatePcd;
import com.jfeat.am.module.frontproduct.services.domain.model.FareTemplateRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFareTemplateService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FareTemplate;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface FareTemplateService extends CRUDFareTemplateService{
    List findFareTemplatePage(Page<FareTemplateRecord> page, FareTemplateRecord record, String search,
                           String orderBy, Date startTime, Date endTime);

    /**
     * 新建运费模板
     * @param entity
     * @return 数据库受影响的行数
     */
    Integer createFareTemplate(FareTemplateModel entity);

    /**
     * 根据id获取运费模板详情
     * @param id
     * @return FareTemplateModel实体
     */
    FareTemplateModel getFareTemplate(Long id);

    /**
     * 修改运费模板
     * @param entity
     * @return 数据库受影响的行数
     */
    Integer updateFareTemplate(FareTemplateModel entity);


    //shopAddr 转换成 shopAddrList
    List<FareTemplatePcd> ShopAddrToShopAddrList(String shopAddr,String ids,Long id);

    //shopAddrList 转换成 fareTemplate对象 内部装有 shopAddr 和 addrIds
    FareTemplate ShopAddrListToShopAddr(List<FareTemplatePcd> shopAddrList);

}