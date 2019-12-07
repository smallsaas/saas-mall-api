package com.jfeat.am.module.frontproduct.services.domain.dao;

import com.jfeat.am.module.frontproduct.services.domain.model.ProductSettlementProportionRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductSettlementProportion;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-25
 */
public interface QueryProductSettlementProportionDao extends BaseMapper<ProductSettlementProportion> {

    List<ProductSettlementProportionRecord> findProductSettlementProportion(@Param("productId") Long productId);


    List<ProductSettlementProportionRecord> findProductSettlementProportionPage(Page<ProductSettlementProportionRecord> page, @Param("record") ProductSettlementProportionRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}