package com.jfeat.am.module.advertisement.services.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.advertisement.services.domain.model.record.AdRecord;
import com.jfeat.am.module.advertisement.services.persistence.model.Ad;
import com.jfeat.crud.plus.CRUDServiceOnly;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2017-09-20
 */
public interface AdService extends CRUDServiceOnly<Ad> {

    Integer createMaster(Ad ad);

    Integer updateMaster(Ad ad);

    List findAdPage(Page<AdRecord> page, AdRecord record, String search,
                    String orderBy, Date startTime, Date endTime);
}

