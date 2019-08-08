package com.jfeat.am.module.store.api.crud;

import com.jfeat.am.common.controller.BaseController;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2018-06-09
 */
/*@Api("换班api")
@RestController
@RequestMapping("/api/store/shiftings")*/
public class StoreShiftingEndpoint extends BaseController {/*

    @Resource
    StoreShiftingService storeShiftingService;

    @Resource
    QueryStoreShiftingDao queryStoreShiftingDao;

    @ApiOperation(value = "新建换班", response = IdRequest.class)
    @BusinessLog(name = "StoreShifting", value = "create StoreShifting")
    @PostMapping
    public Tip createStoreShifting(@RequestBody IdRequest request) {
        Integer affected = 0;
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        if (userId == null){
            throw new BusinessException(BusinessCode.UserNotExisted);
        }
        affected = storeShiftingService.createShifting(userId,request);
        return SuccessTip.create(affected);
    }

    @ApiOperation("换班详情")
    @GetMapping("/{id}")
    public Tip getStoreShifting(@PathVariable Long id) {
        return SuccessTip.create(storeShiftingService.getSlaveItem(id));
    }

    @ApiOperation("换班记录列表")
    @GetMapping
    public Tip queryStoreShiftings(Page<StoreShiftingRecord> page,
                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                   @RequestParam(name = "id", required = false) Long id,
                                   @RequestParam(name = "storeId", required = false) Long storeId,
                                   @RequestParam(name = "cashierClientId", required = false) Long cashierClientId,
                                   @RequestParam(name = "assistantId", required = false) Long assistantId,
                                   @RequestParam(name = "cashier", required = false) String cashier,
                                   @RequestParam(name = "nextAssistantId", required = false) Long nextAssistantId,
                                   @RequestParam(name = "nextCashier", required = false) String nextCashier,
                                   @RequestParam(name = "status", required = false) String status,
                                   @RequestParam(name = "onDutyTime", required = false) Date onDutyTime,
                                   @RequestParam(name = "logTime", required = false) Date logTime,
                                   @RequestParam(name = "onDutyAmount", required = false) BigDecimal onDutyAmount,
                                   @RequestParam(name = "logAmount", required = false) BigDecimal logAmount,
                                   @RequestParam(name = "isMyApply",required = true,defaultValue = "1")Integer isMyApply,
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
        Long userId = JWTKit.getUserId(getHttpServletRequest());

        page.setCurrent(pageNum);
        page.setSize(pageSize);

        StoreShiftingRecord record = new StoreShiftingRecord();
        record.setId(id);
        record.setStoreId(storeId);
        record.setCashierClientId(cashierClientId);
        record.setAssistantId(assistantId);
        record.setCashier(cashier);
        record.setNextAssistantId(nextAssistantId);
        record.setNextCashier(nextCashier);
        record.setStatus(status);
        record.setOnDutyTime(onDutyTime);
        record.setLogTime(logTime);
        record.setOnDutyAmount(onDutyAmount);
        record.setLogAmount(logAmount);

        page.setRecords(queryStoreShiftingDao.findStoreShiftingPage(page, userId,record, orderBy,isMyApply));

        return SuccessTip.create(page);
    }

*/
}
