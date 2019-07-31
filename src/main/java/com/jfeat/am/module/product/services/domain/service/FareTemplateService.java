package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.FareTemplateModel;
import com.jfeat.am.module.product.services.domain.model.FareTemplateRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDFareTemplateService;

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
}