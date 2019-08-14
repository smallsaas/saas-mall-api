package com.jfeat.am.module.advertisement.services.service;

import com.jfeat.am.common.crud.CRUDServiceOnly;
import com.jfeat.am.module.advertisement.services.persistence.model.Ad;

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

}

