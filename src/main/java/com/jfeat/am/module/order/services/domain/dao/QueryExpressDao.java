package com.jfeat.am.module.order.services.domain.dao;

import com.jfeat.am.module.order.services.domain.model.ExpressRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.order.services.gen.persistence.model.Express;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-01
 */
public interface QueryExpressDao extends BaseMapper<Express> {
    List<ExpressRecord> findExpressPage(Page<ExpressRecord> page, @Param("record") ExpressRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}