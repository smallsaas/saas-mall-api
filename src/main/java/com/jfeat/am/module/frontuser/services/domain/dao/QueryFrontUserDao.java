package com.jfeat.am.module.frontuser.services.domain.dao;

import com.jfeat.am.module.frontuser.services.domain.model.FrontUserRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.frontuser.services.gen.persistence.model.FrontUser;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-22
 */
public interface QueryFrontUserDao extends BaseMapper<FrontUser> {
    List<FrontUserRecord> findUserPage(Page<FrontUserRecord> page, @Param("record") FrontUserRecord record,
                                       @Param("search") String search, @Param("orderBy") String orderBy,
                                       @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}