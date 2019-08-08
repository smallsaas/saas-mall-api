package com.jfeat.am.module.store.services.crud.service;

import com.jfeat.am.common.crud.CRUDServicePeer;
import com.jfeat.am.module.printer.services.persistence.model.Printer;
import com.jfeat.am.module.printer.services.persistence.model.PrinterTerminal;
import com.jfeat.am.module.store.services.persistence.model.CashierClient;

/**
 * @author jackyhuang
 * @date 2018/10/23
 */
public interface CRUDCashierClientPeerService extends CRUDServicePeer<CashierClient, Printer, PrinterTerminal> {
}
