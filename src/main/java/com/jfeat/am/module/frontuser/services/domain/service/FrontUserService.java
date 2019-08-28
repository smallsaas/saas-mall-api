package com.jfeat.am.module.frontuser.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontuser.services.domain.model.FrontUserRecord;
import com.jfeat.am.module.frontuser.services.gen.crud.service.CRUDFrontUserService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface FrontUserService extends CRUDFrontUserService {
    List findUserPage(Page<FrontUserRecord> page, FrontUserRecord record, String search,
                      String orderBy, Date startTime, Date endTime);
}