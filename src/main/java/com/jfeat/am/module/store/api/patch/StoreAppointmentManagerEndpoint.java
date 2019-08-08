package com.jfeat.am.module.store.api.patch;

import com.jfeat.am.common.controller.BaseController;


/*@Api("预约管理-店铺以及后台")
@RestController
@RequestMapping("/api/store")*/
public class StoreAppointmentManagerEndpoint extends BaseController {/*

    @Resource
    StoreAppointmentService storeAppointmentService;


    @ApiOperation("查看本店铺的预约列表")
    @BusinessLog(name = "Appointment", value = "get storeAppointments")
    @GetMapping("/stores/{id}/action/appointments")
    public Tip storeAppointments(@PathVariable Long id) {
        return SuccessTip.create(storeAppointmentService.storeAppointments(id));
    }

    @ApiOperation("查看我的服务列表")
    @BusinessLog(name = "Appointment", value = "get appointmentsServerOwnByMe")
    @GetMapping("/assistants/action/appointments/server")
    public Tip appointmentsServerOwnByMe(@PathVariable Long id) {
        return SuccessTip.create(storeAppointmentService.appointmentServerByUserId(JWTKit.getUserId(getHttpServletRequest())));
    }

    @ApiOperation("查看我的接待列表")
    @BusinessLog(name = "Appointment", value = "get appointmentsReceptionOwnByMe")
    @GetMapping("/assistants/action/appointments/reception")
    public Tip appointmentsServerOwnByMe() {
        return SuccessTip.create(storeAppointmentService.appointmentReceptionByUserId(JWTKit.getUserId(getHttpServletRequest())));
    }

    @ApiOperation(value = "分配预约 接待员工", response = AssignAppointmentModel.class)
    @BusinessLog(name = "Appointment", value = "put appointmentsReceptionAssign")
    @PostMapping("/appointments/assign/receptions")
    public Tip appointmentsReceptionAssign(@RequestBody AssignAppointmentModel model) {
        return SuccessTip.create(storeAppointmentService.assignReception(JWTKit.getUserId(getHttpServletRequest()),model));
    }

    @ApiOperation(value = "分配预约(One) 接待员工", response = AssignAppointmentModel.class)
    @BusinessLog(name = "Appointment", value = "put appointmentsReceptionAssign")
    @PostMapping("/appointments/{appointmentId}/assign/receptions")
    public Tip appointmentsAssignReception(@PathVariable Long appointmentId,@RequestBody AssignAppointmentModel model) {
        return SuccessTip.create(storeAppointmentService.assignOneReception(JWTKit.getUserId(getHttpServletRequest()),appointmentId,model));
    }


    @ApiOperation(value = "分配预约 服务员工", response = AssignAppointmentModel.class)
    @BusinessLog(name = "Appointment", value = "put appointmentsServersAssign")
    @PostMapping("/appointments/assign/servers")
    public Tip appointmentsServersAssign(@RequestBody AssignAppointmentModel model) {
        return SuccessTip.create(storeAppointmentService.assignServer(JWTKit.getUserId(getHttpServletRequest()),model));
    }

    @ApiOperation(value = "分配预约(one) 服务员工", response = AssignAppointmentModel.class)
    @BusinessLog(name = "Appointment", value = "put appointmentsServersAssign")
    @PostMapping("/appointments/{appointmentId}/assign/servers")
    public Tip appointmentsAssignServers(@PathVariable Long appointmentId,@RequestBody AssignAppointmentModel model) {
        return SuccessTip.create(storeAppointmentService.assignOneServer(JWTKit.getUserId(getHttpServletRequest()),appointmentId,model));
    }*/
}
