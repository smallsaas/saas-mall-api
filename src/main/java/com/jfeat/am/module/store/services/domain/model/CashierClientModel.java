package com.jfeat.am.module.store.services.domain.model;

import com.jfeat.am.module.printer.services.persistence.model.Printer;
import com.jfeat.am.module.store.services.persistence.model.CashierClient;
import com.jfeat.am.module.store.services.persistence.model.StoreShifting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Code Generator on 2018-06-09
 */
public class CashierClientModel extends CashierClient {
    private List<Printer> printerList = new ArrayList<>();

    public List<Printer> getPrinterList() {
        return printerList;
    }

    public CashierClientModel setPrinterList(List<Printer> printerList) {
        this.printerList = printerList;
        return this;
    }
}
