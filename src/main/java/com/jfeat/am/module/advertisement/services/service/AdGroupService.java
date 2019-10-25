package com.jfeat.am.module.advertisement.services.service;

import com.jfeat.am.module.advertisement.services.persistence.model.AdGroup;
import com.jfeat.am.module.advertisement.services.persistence.model.AdGroupedModel;
import com.jfeat.crud.plus.CRUDServiceOnly;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2017-09-20
 */
public interface AdGroupService extends CRUDServiceOnly<AdGroup> {
    /**
     * 查看该组所有广告
     * @param id
     * @return
     */
    AdGroupedModel showAdGroupsById(Long id);

    /**
     * 查看该组在播广告
     * @param id
     * @return
     */
    AdGroupedModel showAdGroupsByIdCurrent(Long id);
}
