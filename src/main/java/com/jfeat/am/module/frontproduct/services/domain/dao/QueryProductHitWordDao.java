package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.ProductHitWordRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductHitWord;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public interface QueryProductHitWordDao extends BaseMapper<ProductHitWord> {
    List<ProductHitWordRecord> findProductHitWordPage(Page<ProductHitWordRecord> page, @Param("record") ProductHitWordRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}