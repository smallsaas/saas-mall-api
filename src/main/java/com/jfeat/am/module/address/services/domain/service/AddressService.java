package com.jfeat.am.module.address.services.domain.service;

import com.jfeat.am.module.address.services.gen.crud.service.CRUDAddressService;
import com.jfeat.am.module.address.services.gen.persistence.model.Address;

/**
 * Created by vincent on 2017/10/19.
 */
public interface AddressService extends CRUDAddressService {
//    修改为默认地址
    int updateDefaultAddress(Address entity);

//    删除带默认地址的
    int deleteWithDefaultAddress(Long id);

//    添加带默认地址
    int addWithDefaultAddress(Address entity);

//    修改修改带默认地址
    int updateWhitDefaultAddress(Address entity);

//    查询默认地址
    Address queryDefaultAddress(Long userId);
}