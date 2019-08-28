package com.jfeat.am.module.frontproduct.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductTagRecord;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFrontProductTagService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface FrontProductTagService extends CRUDFrontProductTagService {
    List findProductTagPage(Page<FrontProductTagRecord> page, FrontProductTagRecord record, String search,
                            String orderBy, Date startTime, Date endTime);
}