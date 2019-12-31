package com.jfeat.am.module.order.services.domain.service;

import java.math.BigDecimal;

public interface OrderWelletService {

    //请在操作之后再调用
    Integer insertWelletHistoryByUserId(BigDecimal amount,BigDecimal GiftBalance,Long userId,String type,String note);
    //请在操作之后再调用
    Integer insertWelletHistoryByUserId(BigDecimal amount,Long userId,String type,String note);
    Integer insertWelletHistoryByWalletId(BigDecimal balance,BigDecimal amount,BigDecimal GiftBalance,Long WalletId,String type,String note);
    Integer insertWelletHistoryByWalletId(BigDecimal balance,BigDecimal amount,Long WalletId,String type,String note);

}
