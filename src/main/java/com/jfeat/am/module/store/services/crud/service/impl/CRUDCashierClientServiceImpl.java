package com.jfeat.am.module.store.services.crud.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import com.jfeat.am.module.store.services.crud.service.CRUDCashierClientService;
import com.jfeat.am.module.store.services.persistence.dao.CashierClientMapper;
import com.jfeat.am.module.store.services.persistence.model.CashierClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * implementation
 * </p>
 * CRUDCashierClientService
 *
 * @author Code Generator
 * @since 2018-06-09
 */

@Service
public class CRUDCashierClientServiceImpl extends CRUDServiceOnlyImpl<CashierClient> implements CRUDCashierClientService {


    @Resource
    private CashierClientMapper cashierClientMapper;


    @Override
    protected BaseMapper<CashierClient> getMasterMapper() {
        return cashierClientMapper;
    }
}


