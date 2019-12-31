package com.jfeat.am.module.order.services.domain.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderWallet;

/**
 * Created by Code Generator on 2019-10-14
 */
public interface QueryOrderWalletDao extends BaseMapper<OrderWallet> {

    OrderWallet selectWalletByUserId(Long userId);


}