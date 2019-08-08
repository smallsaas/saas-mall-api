package com.jfeat.am.module.store.api.patch;

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
public class PatchStoreShiftingEndpoint extends BaseController {/*


    @Resource
    StoreShiftingService storeShiftingService;

    @Resource
    QueryStoreShiftingDao queryStoreShiftingDao;

    @Resource
    StoreAssistantService storeAssistantService;

    @ApiOperation("确认换班")
    @BusinessLog(name = "StoreShifting", value = "confirm StoreShifting")
    @PutMapping("/{id}/shift/confirm")
    public Tip confirmStoreShifting(@PathVariable Long id) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        StoreAssistant storeAssistants = storeAssistantService.getStoreAssistantByUserId(userId);
        if (storeAssistants == null){
            throw new BusinessException(ExceptionEnum.NOT_AN_ASSISTANT.getFriendlyCode(),ExceptionEnum.NOT_AN_ASSISTANT.getFriendlyMsg());
        }
        StoreShifting storeShifting = storeShiftingService.getSlaveItem(id);
//        修改上一条记录
        if (!storeShifting.getNextAssistantId().equals(storeAssistants.getId())){
            throw new BusinessException(ExceptionEnum.NOT_THE_NEXT_ASSISTANT.getFriendlyCode(),ExceptionEnum.NOT_THE_NEXT_ASSISTANT.getFriendlyMsg());
        }
        if (!storeShifting.getStatus().equals(ShiftingStatus.APPLYING)){
            throw new BusinessException(ExceptionEnum.NOT_APPLYINIG.getFriendlyCode(),ExceptionEnum.NOT_APPLYINIG.getFriendlyMsg());
        }
        storeShifting.setId(id);
        storeShifting.setStatus(ShiftingStatus.CONFIRM);
        storeShifting.setConfirmTime(new Date());
        return SuccessTip.create(storeShiftingService.updateSlaveItem(storeShifting));
    }

    @ApiOperation("申请换班")
    @BusinessLog(name = "StoreShifting", value = "apply StoreShifting")
    @PutMapping("/{id}/shift/apply")
    public Tip applyStoreShifting(@PathVariable Long id) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        StoreAssistant storeAssistants = storeAssistantService.getStoreAssistantByUserId(userId);
        if (storeAssistants == null){
            throw  new BusinessException(ExceptionEnum.NOT_AN_ASSISTANT.getFriendlyCode(),ExceptionEnum.NOT_AN_ASSISTANT.getFriendlyMsg());
        }
        StoreShifting storeShifting = storeShiftingService.getSlaveItem(id);
//        修改上一条记录
        if (!storeShifting.getAssistantId().equals(storeAssistants.getId())){
            throw new BusinessException(ExceptionEnum.NOT_THE_CURRENT_ASSISTANT.getFriendlyCode(),ExceptionEnum.NOT_THE_CURRENT_ASSISTANT.getFriendlyMsg());
        }
        if (!storeShifting.getStatus().equals(ShiftingStatus.WORKING)){
            throw new BusinessException(ExceptionEnum.NOT_WORKING.getFriendlyCode(),ExceptionEnum.NOT_WORKING.getFriendlyMsg());
        }
        storeShifting.setId(id);
        storeShifting.setStatus(ShiftingStatus.APPLYING);
        return SuccessTip.create(storeShiftingService.updateSlaveItem(storeShifting));
    }*/
}
