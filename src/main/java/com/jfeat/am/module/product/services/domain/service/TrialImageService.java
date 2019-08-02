package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.TrialImageRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDTrialImageService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface TrialImageService extends CRUDTrialImageService{
    List findTrialImagePage(Page<TrialImageRecord> page, TrialImageRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}