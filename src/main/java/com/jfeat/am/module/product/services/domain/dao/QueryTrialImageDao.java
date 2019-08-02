package com.jfeat.am.module.product.services.domain.dao;

import com.jfeat.am.module.product.services.domain.model.TrialImageRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.product.services.gen.persistence.model.TrialImage;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-02
 */
public interface QueryTrialImageDao extends BaseMapper<TrialImage> {
    List<TrialImageRecord> findTrialImagePage(Page<TrialImageRecord> page, @Param("record") TrialImageRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}