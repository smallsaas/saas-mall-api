package com.jfeat.am.module.order.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.model.ExpressRecord;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDExpressService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ExpressService extends CRUDExpressService{
    List findExpressPage(Page<ExpressRecord> page, ExpressRecord record, String search,
                           String orderBy, Date startTime, Date endTime);

    Integer updateIsDefault();
}