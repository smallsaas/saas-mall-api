package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.ProductPurchaseStrategyRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductPurchaseStrategy;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public interface QueryProductPurchaseStrategyDao extends BaseMapper<ProductPurchaseStrategy> {
    List<ProductPurchaseStrategyRecord> findProductPurchaseStrategyPage(Page<ProductPurchaseStrategyRecord> page, @Param("record") ProductPurchaseStrategyRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}