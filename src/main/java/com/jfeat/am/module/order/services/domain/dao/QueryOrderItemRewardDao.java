package com.jfeat.am.module.order.services.domain.dao;

import com.jfeat.am.module.order.services.domain.model.OrderItemRewardRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItemReward;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-31
 */
public interface QueryOrderItemRewardDao extends BaseMapper<OrderItemReward> {
    List<OrderItemRewardRecord> findOrderItemRewardPage(Page<OrderItemRewardRecord> page, @Param("record") OrderItemRewardRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime,
                                                        @Param("leftMoney") BigDecimal leftMoney,
                                                        @Param("rightMoney") BigDecimal rightMoney,
                                                        @Param("itemRewardLeftMoney") BigDecimal itemRewardLeftMoney,
                                                        @Param("itemRewardRightMoney") BigDecimal itemRewardRightMoney
     );
}