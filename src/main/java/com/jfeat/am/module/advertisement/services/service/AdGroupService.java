package com.jfeat.am.module.advertisement.services.service;

import com.jfeat.am.common.crud.CRUDServiceOnly;
import com.jfeat.am.module.advertisement.services.persistence.model.Ad;
import com.jfeat.am.module.advertisement.services.persistence.model.AdGroup;

import java.util.List;

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
    List<Ad> showAdGroupsById(Long id);

    /**
     * 查看该组在播广告
     * @param id
     * @return
     */
    List<Ad> showAdGroupsByIdCurrent(Long id);
}
