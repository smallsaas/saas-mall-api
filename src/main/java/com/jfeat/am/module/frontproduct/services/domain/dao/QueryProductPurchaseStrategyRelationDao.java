package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.ProductPurchaseStrategyRelationRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductPurchaseStrategyRelation;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public interface QueryProductPurchaseStrategyRelationDao extends BaseMapper<ProductPurchaseStrategyRelation> {
    List<ProductPurchaseStrategyRelationRecord> findProductPurchaseStrategyRelationPage(Page<ProductPurchaseStrategyRelationRecord> page, @Param("record") ProductPurchaseStrategyRelationRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}