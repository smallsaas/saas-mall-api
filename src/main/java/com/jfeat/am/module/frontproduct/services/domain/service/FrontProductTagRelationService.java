package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductTagRelationRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFrontProductTagRelationService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface FrontProductTagRelationService extends CRUDFrontProductTagRelationService {
    List findProductTagRelationPage(Page<FrontProductTagRelationRecord> page, FrontProductTagRelationRecord record, String search,
                                    String orderBy, Date startTime, Date endTime);
}