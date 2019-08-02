package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.TrialRecord;
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
    Integer updateTrialStatus(Integer id, Integer status);
}