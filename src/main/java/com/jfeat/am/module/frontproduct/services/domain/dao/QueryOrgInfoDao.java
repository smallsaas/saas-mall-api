package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public interface QueryOrgInfoDao  {
    Long getTenantOrgIdByOrgId (@Param("orgId")Long orgId);
}