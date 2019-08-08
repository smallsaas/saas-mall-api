package com.jfeat.am.module.store.services.domain.service;

import com.jfeat.am.module.appointment.services.domain.service.AppointmentService;
import com.jfeat.am.module.appointment.services.persistence.model.Appointment;
import com.jfeat.am.module.store.services.domain.model.AssignAppointmentModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StoreAppointmentService {

    /**
     * 1.店铺预约 管理员 或者 店长 查看
     * */
    List<Appointment> storeAppointments(Long storeId);


    /**
     * 我接待的预约
     * */
    List<Appointment> appointmentReceptionByUserId(Long userId);


    /**
     * 我服务的预约
     * */
    List<Appointment> appointmentServerByUserId(Long userId);


    /**
     * 1.分配 接待 店员
     */
    @Transactional
    Integer assignReception(Long userId, AssignAppointmentModel model);



    /**
     * 1.分配 服务 店员
     */
    @Transactional
    Integer assignServer(Long userId, AssignAppointmentModel model);

    /**
     * 1.分配 服务 店员  (only for one Appointment)
     */
    @Transactional
    Integer assignOneServer(Long userId, Long appointmentId, AssignAppointmentModel model);


    /**
     * 1.分配 接待 店员 (only for one Appointment)
     */
    @Transactional
    Integer assignOneReception(Long userId, Long appointmentId, AssignAppointmentModel model);
}
