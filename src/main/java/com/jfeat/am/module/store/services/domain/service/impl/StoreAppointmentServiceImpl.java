package com.jfeat.am.module.store.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.appointment.services.persistence.dao.AppointmentMapper;
import com.jfeat.am.module.appointment.services.persistence.model.Appointment;
import com.jfeat.am.module.store.services.domain.model.AssignAppointmentModel;
import com.jfeat.am.module.store.services.domain.service.StoreAppointmentService;
import com.jfeat.am.module.store.services.persistence.dao.StoreAssistantMapper;
import com.jfeat.am.module.store.services.persistence.model.StoreAssistant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("StoreAppointmentService")
public class StoreAppointmentServiceImpl implements StoreAppointmentService {

    @Resource
    StoreAssistantMapper assistantMapper;
    @Resource
    AppointmentMapper appointmentMapper;

    @Override
    public List<Appointment> storeAppointments(Long storeId) {
        return appointmentMapper.selectList(new EntityWrapper<Appointment>().eq(Appointment.ITEM_ID, storeId));
    }

    @Override
    public List<Appointment> appointmentReceptionByUserId(Long userId) {
        /**
         * 我接待的预约
         * */
        StoreAssistant storeAssistant = new StoreAssistant();
        storeAssistant.setUserId(userId);
        StoreAssistant assistant = assistantMapper.selectOne(storeAssistant);
        if (assistant != null) {
            List<Appointment> appointments = appointmentMapper.selectList(new EntityWrapper<Appointment>().eq(Appointment.RECEPTIONIST_ID, assistant.getId()));
            return appointments;
        }
        throw new BusinessException(BusinessCode.UserNotExisted);

    }


    @Override
    public List<Appointment> appointmentServerByUserId(Long userId) {
        /**
         * 我服务的预约
         * */
        StoreAssistant storeAssistant = new StoreAssistant();
        storeAssistant.setUserId(userId);
        StoreAssistant assistant = assistantMapper.selectOne(storeAssistant);
        if (assistant != null) {
            List<Appointment> appointments = appointmentMapper.selectList(new EntityWrapper<Appointment>().eq(Appointment.SERVER_ID, assistant.getId()));
            return appointments;
        }
        throw new BusinessException(BusinessCode.UserNotExisted);

    }


    /**
     * 1.分配 接待 店员
     */
    @Transactional
    @Override
    public Integer assignReception(Long userId, AssignAppointmentModel model) {
        int affect = 0;
        StoreAssistant storeAssistant = new StoreAssistant();
        storeAssistant.setUserId(userId);
        StoreAssistant assistant = assistantMapper.selectOne(storeAssistant);
        if (assistant != null) {
            List<Long> ids = model.getIds().getIds();
            for (Long id : ids) {
                Appointment appointment = appointmentMapper.selectById(id);
                StoreAssistant staff = assistantMapper.selectById(model.getStaffId());
                appointment.setReceptionistId(model.getStaffId());
                appointment.setReceptionistName(staff.getName());
                appointmentMapper.updateById(appointment);
                affect++;
            }
            return affect;
        }
        throw new BusinessException(BusinessCode.UserNotExisted);
    }

    /**
     * 1.分配 接待 店员 (only for one Appointment)
     */
    @Transactional
    public Integer assignOneReception(Long userId,Long appointmentId, AssignAppointmentModel model) {
        int affect = 0;
        StoreAssistant storeAssistant = new StoreAssistant();
        storeAssistant.setUserId(userId);
        StoreAssistant assistant = assistantMapper.selectOne(storeAssistant);
        if (assistant != null) {
                Appointment appointment = appointmentMapper.selectById(appointmentId);
                StoreAssistant staff = assistantMapper.selectById(model.getStaffId());
                appointment.setReceptionistId(model.getStaffId());
                appointment.setReceptionistName(staff.getName());
                appointmentMapper.updateById(appointment);
                return affect++;
        }
        throw new BusinessException(BusinessCode.UserNotExisted);
    }

    /**
     * 1.分配 服务 店员
     */
    @Transactional
    public Integer assignServer(Long userId, AssignAppointmentModel model) {
        int affect = 0;
        StoreAssistant storeAssistant = new StoreAssistant();
        storeAssistant.setUserId(userId);
        StoreAssistant assistant = assistantMapper.selectOne(storeAssistant);
            if (assistant != null) {
                List<Long> ids = model.getIds().getIds();
                for (Long id : ids) {
                    Appointment appointment = appointmentMapper.selectById(id);
                    StoreAssistant staff = assistantMapper.selectById(model.getStaffId());
                    appointment.setServerId(model.getStaffId());
                    appointment.setServerName(staff.getName());
                    appointmentMapper.updateById(appointment);
                    affect++;
                }
                return affect;
            }
        throw new BusinessException(BusinessCode.UserNotExisted);
    }

    /**
     * 1.分配 服务 店员  (only for one Appointment)
     */
    @Transactional
    public Integer assignOneServer(Long userId, Long appointmentId,AssignAppointmentModel model) {
        int affect = 0;
        StoreAssistant storeAssistant = new StoreAssistant();
        storeAssistant.setUserId(userId);
        StoreAssistant assistant = assistantMapper.selectOne(storeAssistant);
            if (assistant != null) {
                    Appointment appointment = appointmentMapper.selectById(appointmentId);
                    StoreAssistant staff = assistantMapper.selectById(model.getStaffId());
                    appointment.setServerId(model.getStaffId());
                    appointment.setServerName(staff.getName());
                    appointmentMapper.updateById(appointment);
                return affect;
            }
        throw new BusinessException(BusinessCode.UserNotExisted);
    }
}
