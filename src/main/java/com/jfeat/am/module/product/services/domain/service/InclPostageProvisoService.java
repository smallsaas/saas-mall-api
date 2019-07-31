package com.jfeat.am.module.product.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.InclPostageProvisoRecord;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDInclPostageProvisoService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface InclPostageProvisoService extends CRUDInclPostageProvisoService{
    List findInclPostageProvisoPage(Page<InclPostageProvisoRecord> page, InclPostageProvisoRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}