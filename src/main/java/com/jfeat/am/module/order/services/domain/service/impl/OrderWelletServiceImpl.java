package com.jfeat.am.module.order.services.domain.service.impl;

import com.jfeat.am.module.order.services.domain.dao.QueryOrderWalletDao;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderWalletHistoryDao;
import com.jfeat.am.module.order.services.domain.service.OrderWelletService;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderWallet;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderWalletHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderWelletServiceImpl implements OrderWelletService {

    @Resource
    QueryOrderWalletDao queryOrderWalletDao;
    @Resource
    QueryOrderWalletHistoryDao queryOrderWalletHistoryDao;

    @Override
    public Integer insertWelletHistoryByUserId( BigDecimal amount, BigDecimal GiftBalance, Long userId,String type,String note) {
        OrderWallet orderWallet = queryOrderWalletDao.selectWalletByUserId(userId);
        OrderWalletHistory walletHistory = new OrderWalletHistory();
        //金额 直接读取
        walletHistory.setBalance(orderWallet.getBalance());
        walletHistory.setCreatedTime(new Date());
        //变化额
        walletHistory.setAmount(amount);
        walletHistory.setGiftBalance(GiftBalance);
        walletHistory.setWalletId(orderWallet.getId());
        walletHistory.setType(type);
        walletHistory.setNote(note);
        Integer i = queryOrderWalletHistoryDao.insert(walletHistory);
        return i;
    }

    @Override
    public Integer insertWelletHistoryByUserId( BigDecimal amount, Long userId,String type,String note) {
        OrderWallet orderWallet = queryOrderWalletDao.selectWalletByUserId(userId);
        OrderWalletHistory walletHistory = new OrderWalletHistory();
        //金额 直接读取
        walletHistory.setBalance(orderWallet.getBalance());
        walletHistory.setCreatedTime(new Date());
        //变化额
        walletHistory.setAmount(amount);
        walletHistory.setWalletId(orderWallet.getId());
        walletHistory.setType(type);
        walletHistory.setNote(note);
        Integer i = queryOrderWalletHistoryDao.insert(walletHistory);
        return i;
    }

    @Override
    public Integer insertWelletHistoryByWalletId(BigDecimal balance, BigDecimal amount, BigDecimal GiftBalance, Long WalletId,String type,String note) {
        return null;
    }

    @Override
    public Integer insertWelletHistoryByWalletId(BigDecimal balance, BigDecimal amount, Long WalletId,String type,String note) {
        return null;
    }
}
