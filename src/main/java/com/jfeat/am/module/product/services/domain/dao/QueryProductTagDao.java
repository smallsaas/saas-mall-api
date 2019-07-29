package com.jfeat.am.module.product.services.domain.dao;

import com.jfeat.am.module.product.services.domain.model.ProductTagRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductTag;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public interface QueryProductTagDao extends BaseMapper<ProductTag> {
    List<ProductTagRecord> findProductTagPage(Page<ProductTagRecord> page, @Param("record") ProductTagRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}