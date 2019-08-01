package com.jfeat.am.module.product.services.domain.dao;

import com.jfeat.am.module.product.services.domain.model.InclPostageProvisoRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.product.services.gen.persistence.model.InclPostageProviso;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-31
 */
public interface QueryInclPostageProvisoDao extends BaseMapper<InclPostageProviso> {
    List<InclPostageProvisoRecord> findInclPostageProvisoPage(Page<InclPostageProvisoRecord> page, @Param("record") InclPostageProvisoRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}