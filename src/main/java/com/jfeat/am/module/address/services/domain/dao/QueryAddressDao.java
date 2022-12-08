package com.jfeat.am.module.address.services.domain.dao;

import com.jfeat.am.module.address.services.domain.model.AddressRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.address.services.gen.persistence.model.Address;
import com.jfeat.am.module.address.services.gen.crud.model.AddressModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-08-13
 */
public interface QueryAddressDao extends QueryMasterDao<Address> {
   /*
    * Query entity list by page
    */
    List<AddressRecord> findAddressPage(Page<AddressRecord> page, @Param("record") AddressRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    AddressModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<AddressModel> queryMasterModelList(@Param("masterId") Object masterId);

    int updateAddressList(@Param("addressList") List<Address> addressList);
}