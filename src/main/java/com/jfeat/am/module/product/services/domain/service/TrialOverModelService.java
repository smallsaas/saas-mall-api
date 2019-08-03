package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.TrialRecord;
import com.jfeat.am.module.product.services.gen.crud.model.TrialModel;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDTrialOverModelService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface TrialOverModelService extends CRUDTrialOverModelService{
    List findTrialPage(Page<TrialRecord> page, TrialRecord record, String search,
                           String orderBy, Date startTime, Date endTime);

    /**
     * 使用装是否启用
     * @param id
     * @param status
     * @return 数据库中受影响的行数
     */
    Integer updateTrialStatus(Long id, Integer status);

    /**
     * 根据id获取试用装,包含image子项及product关联项
     * @param id
     * @return
     */
    TrialModel getTrial(Long id);

    /**
     * 新建试用装
     * @param entity
     * @return
     */
    Integer createTrial(TrialModel entity);
}