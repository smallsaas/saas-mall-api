package com.jfeat.am.module.store.api.crud;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.core.support.BeanKit;
import com.jfeat.am.core.support.StrKit;
import com.jfeat.am.core.util.JsonKit;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.printer.constant.PrinterStatus;
import com.jfeat.am.module.printer.services.domain.dao.QueryPrinterDao;
import com.jfeat.am.module.printer.services.domain.model.PrinterRecord;
import com.jfeat.am.module.printer.services.persistence.dao.PrinterTerminalMapper;
import com.jfeat.am.module.printer.services.persistence.model.Printer;
import com.jfeat.am.module.printer.services.persistence.model.PrinterTerminal;
import com.jfeat.am.module.store.services.domain.dao.QueryCashierClientDao;
import com.jfeat.am.module.store.services.domain.model.CashierClientModel;
import com.jfeat.am.module.store.services.domain.model.CashierClientRecord;
import com.jfeat.am.module.store.services.domain.service.CashierClientPeerService;
import com.jfeat.am.module.store.services.domain.service.CashierClientService;
import com.jfeat.am.module.store.services.persistence.dao.CashierClientMapper;
import com.jfeat.am.module.store.services.persistence.model.CashierClient;
import com.plugin.printing.cloud.print.yilianyun.PrinterManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2018-06-09
 */
@Api("收款机api")
@RestController
@RequestMapping("/api/store/cashiers")
public class CashierClientEndpoint extends BaseController {


    @Resource
    CashierClientService cashierClientService;
    @Resource
    CashierClientPeerService cashierClientPeerService;

    @Resource
    CashierClientMapper cashierClientMapper;

    @Resource
    QueryCashierClientDao queryCashierClientDao;

    @Resource
    QueryPrinterDao queryPrinterDao;
    @Resource
    PrinterTerminalMapper printerTerminalMapper;

    @ApiOperation(value = "注册收款机", response = CashierClient.class)
    @BusinessLog(name = "CashierClient", value = "create CashierClient")
    @PostMapping
    public Tip createCashierClient(@RequestBody CashierClientModel entity) {
        if (StrKit.isBlank(entity.getCode()) || entity.getStoreId() == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }

        CashierClient cashierClient = new CashierClient();
        cashierClient.setStoreId(entity.getStoreId());
        cashierClient.setCode(entity.getCode());
        CashierClient cashierClientRecord = cashierClientMapper.selectOne(cashierClient);
        Long terminalId = null;
        if (cashierClientRecord == null) {
            entity.setCreateTime(new Date());
            cashierClientService.createMaster(entity);
            terminalId = entity.getId();

            if (entity.getPrinterList() != null) {
                logger.debug("going to update printerList.");
                for (Printer printer : entity.getPrinterList()) {
                    logger.debug("set terminal id to {} for machine-code = {}", terminalId, printer.getMachineCode());
                    PrinterTerminal printerTerminal = new PrinterTerminal();
                    printerTerminal.setTerminalId(terminalId);
                    printerTerminal.setPrinterId(printer.getId());
                    PrinterTerminal terminal = printerTerminalMapper.selectOne(printerTerminal);
                    if (terminal == null) {
                        logger.debug("printer terminal not found, create one. {}", printerTerminal);
                        printerTerminalMapper.insert(printerTerminal);
                    }
                }
            }
        }
        else {
            logger.debug("cashier client found. {}", JsonKit.toJson(cashierClientRecord));
            terminalId = cashierClientRecord.getId();
            entity.setId(cashierClientRecord.getId());
        }

        if (terminalId != null) {
            //reset corresponding printer
            PrinterManager.me().resetDevicePrinter(terminalId.toString());

            List<PrinterRecord> printerRecords = queryPrinterDao.findList(terminalId, PrinterStatus.ENABLED.toString());
            logger.debug("found {} enabled printers for terminal id {}.", printerRecords.size(), terminalId);
            if (!printerRecords.isEmpty()) {
                for (PrinterRecord printer : printerRecords) {
                    logger.debug("checking printer registration. machine-code = {}", printer.getMachineCode());
                    if (!PrinterManager.me().registeredPrinter(printer.getMachineCode())) {
                        logger.debug("not register, now register it. machine-code = {}, terminal_id = {}", printer.getMachineCode(), terminalId);
                        com.plugin.printing.cloud.print.yilianyun.Printer p = new com.plugin.printing.cloud.print.yilianyun.Printer();
                        p.setApiKey(printer.getApiKey());
                        p.setMachineCode(printer.getMachineCode());
                        p.setMachineKey(printer.getMachineKey());
                        p.setPartner(printer.getPartner());
                        PrinterManager.me().registerPrinter(terminalId.toString(), p);
                    }
                }
            }
            entity.setPrinterList(new ArrayList<>(printerRecords));
        }

        return SuccessTip.create(entity);
    }

    @ApiOperation("收款机详情")
    @GetMapping("/{id}")
    public Tip getCashierClient(@PathVariable Long id) {
        CashierClient cashierClient = cashierClientService.retrieveMaster(id);
        if (cashierClient == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }
        Map<String, Object> res = BeanKit.beanToMap(cashierClient);
        List<PrinterRecord> printerList = queryPrinterDao.findList(id, null);
        res.put("printerList", printerList);
        return SuccessTip.create(res);
    }


    @ApiOperation(value = "修改收款机", response = CashierClient.class)
    @BusinessLog(name = "CashierClient", value = "update CashierClient")
    @PutMapping("/{id}")
    public Tip updateCashierClient(@PathVariable Long id, @RequestBody CashierClientModel entity) {
        logger.debug("going to update cashier client {}", JsonKit.toJson(entity));
        entity.setId(id);
        cashierClientService.updateMaster(entity);
        if (entity.getPrinterList() != null) {
            logger.debug("reset printer terminal list.");
            PrinterManager printerManager = PrinterManager.me();
            printerManager.resetDevicePrinter(entity.getId().toString());
            cashierClientPeerService.resetPeerList(id);
            if (!entity.getPrinterList().isEmpty()) {
                logger.debug("add printer terminal list.");
                cashierClientPeerService.addPeerList(id, entity.getPrinterList().stream().map(Printer::getId).collect(Collectors.toList()));
            }

            List<com.plugin.printing.cloud.print.yilianyun.Printer> printers = new ArrayList<>();
            entity.getPrinterList().forEach(printer -> {
                com.plugin.printing.cloud.print.yilianyun.Printer p = new com.plugin.printing.cloud.print.yilianyun.Printer();
                p.setApiKey(printer.getApiKey());
                p.setMachineCode(printer.getMachineCode());
                p.setMachineKey(printer.getMachineKey());
                p.setPartner(printer.getPartner());
                printers.add(p);
            });
            if(!printers.isEmpty()) {
                printerManager.registerPrinter(entity.getId().toString(), printers.toArray(new com.plugin.printing.cloud.print.yilianyun.Printer[0]));
            }
        }
        return SuccessTip.create();
    }

    @ApiOperation("删除收款机")
    @BusinessLog(name = "CashierClient", value = "delete CashierClient")
    @DeleteMapping("/{id}")
    public Tip deleteCashierClient(@PathVariable Long id) {
        cashierClientPeerService.resetPeerList(id);
        cashierClientPeerService.deleteMaster(id);
        return SuccessTip.create();
    }

    @ApiOperation("收款机列表")
    @GetMapping
    public Tip queryCashierClients(Page<CashierClientRecord> page,
                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                   @RequestParam(name = "id", required = false) Long id,
                                   @RequestParam(name = "storeId", required = false) Long storeId,
                                   @RequestParam(name = "code", required = false) String code,
                                   @RequestParam(name = "factory", required = false) String factory,
                                   @RequestParam(name = "model", required = false) String model,
                                   @RequestParam(name = "createTime", required = false) Date createTime,
                                   @RequestParam(name = "orderBy", required = false) String orderBy,
                                   @RequestParam(name = "sort", required = false) String sort) {
        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        CashierClientRecord record = new CashierClientRecord();
        record.setId(id);
        record.setStoreId(storeId);
        record.setCode(code);
        record.setFactory(factory);
        record.setModel(model);
        record.setCreateTime(createTime);

        page.setRecords(queryCashierClientDao.findCashierClientPage(page, record, orderBy));

        return SuccessTip.create(page);
    }

    @PostMapping("/registerd")
    public SuccessTip registerPrintTest() {
        return SuccessTip.create(PrinterManager.me().getRegisterd());
    }
}
