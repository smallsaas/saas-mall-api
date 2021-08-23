package com.jfeat.am.module.order.services.domain.service;

import org.springframework.transaction.annotation.Transactional;

public interface DevService {

    public Integer deleteOrder(String type);

    @Transactional
    Integer deleteOrderRefunds();
}
