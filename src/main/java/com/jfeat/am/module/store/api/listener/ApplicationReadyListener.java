package com.jfeat.am.module.store.api.listener;

import com.jfeat.am.module.printer.constant.PrinterStatus;
import com.jfeat.am.module.printer.services.domain.dao.QueryPrinterDao;
import com.jfeat.am.module.printer.services.domain.model.PrinterRecord;
import com.jfeat.am.module.store.services.persistence.dao.CashierClientMapper;
import com.jfeat.am.module.store.services.persistence.model.CashierClient;
import com.plugin.printing.cloud.print.yilianyun.PrinterManager;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zy on 2018/10/19.
 */
@Component
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    CashierClientMapper cashierClientMapper;

    @Resource
    QueryPrinterDao queryPrinterDao;

    /**
     * 打印机初始化
     * */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        PrinterManager.me().reset();
        List<CashierClient> clients =cashierClientMapper.selectList(null);
        if(clients != null && !clients.isEmpty()) {
            clients.forEach(item -> {
                List<PrinterRecord> printerRecords = queryPrinterDao.findList(item.getId(), PrinterStatus.ENABLED.toString());
                printerRecords.forEach(printer -> {
                    com.plugin.printing.cloud.print.yilianyun.Printer p = new com.plugin.printing.cloud.print.yilianyun.Printer();
                    p.setApiKey(printer.getApiKey());
                    p.setMachineCode(printer.getMachineCode());
                    p.setMachineKey(printer.getMachineKey());
                    p.setPartner(printer.getPartner());
                    PrinterManager.me().registerPrinter(item.getId().toString(), p);
                });
            });
        }

    }
}
