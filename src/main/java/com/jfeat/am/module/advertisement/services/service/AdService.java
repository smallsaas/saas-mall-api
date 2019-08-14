package com.jfeat.am.module.advertisement.services.service;

import com.jfeat.am.common.crud.CRUDServiceOnly;
import com.jfeat.am.module.advertisement.services.persistence.model.Ad;
import com.jfeat.am.module.advertisement.services.persistence.model.AdGroupedModel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2017-09-20
 */
public interface AdService extends CRUDServiceOnly<Ad> {
    /**
     * 依据组标识为前端提供 广告组
     * @param group
     * @return
     */
    AdGroupedModel getAdRecordsByGroup(String group, Integer enabled);

    Integer createMaster(Ad ad);

    Integer updateMaster(Ad ad);
    AdGroupedModel getAdRecordsByGroup(String group);
}

