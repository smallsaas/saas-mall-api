package com.jfeat.am.module.store.services.domain.service;

import com.jfeat.am.module.store.api.IdRequest;
import com.jfeat.am.module.store.services.crud.service.CRUDStoreShiftingService;

/**
 * Created by vincent on 2017/10/19.
 */
public interface StoreShiftingService extends CRUDStoreShiftingService {


    /**
     * 新建 交班 表， 传递  店铺 id 以及 下一位 员工的 id
     */
    Integer createShifting(Long userId, IdRequest entity);

}