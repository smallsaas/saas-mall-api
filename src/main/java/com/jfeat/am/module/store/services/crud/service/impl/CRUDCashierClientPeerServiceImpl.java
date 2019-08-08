package com.jfeat.am.module.store.services.crud.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.impl.CRUDServicePeerImpl;
import com.jfeat.am.module.printer.services.persistence.dao.PrinterMapper;
import com.jfeat.am.module.printer.services.persistence.dao.PrinterTerminalMapper;
import com.jfeat.am.module.printer.services.persistence.model.Printer;
import com.jfeat.am.module.printer.services.persistence.model.PrinterTerminal;
import com.jfeat.am.module.store.services.crud.service.CRUDCashierClientPeerService;
import com.jfeat.am.module.store.services.persistence.dao.CashierClientMapper;
import com.jfeat.am.module.store.services.persistence.model.CashierClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jackyhuang
 * @date 2018/10/23
 */
@Service
public class CRUDCashierClientPeerServiceImpl extends CRUDServicePeerImpl<CashierClient, Printer, PrinterTerminal> implements CRUDCashierClientPeerService {

    @Resource
    private CashierClientMapper cashierClientMapper;
    @Resource
    private PrinterMapper printerMapper;
    @Resource
    private PrinterTerminalMapper printerTerminalMapper;

    @Override
    protected Class<PrinterTerminal> relationClassName() {
        return PrinterTerminal.class;
    }

    @Override
    protected BaseMapper<CashierClient> getMasterMapper() {
        return cashierClientMapper;
    }

    @Override
    protected BaseMapper<Printer> getMasterPeerMapper() {
        return printerMapper;
    }

    @Override
    protected BaseMapper<PrinterTerminal> getRelationMapper() {
        return printerTerminalMapper;
    }

    @Override
    protected String[] relationMatches() {
        return new String[] {
                "terminal_id", "printer_id"
        };
    }
}
