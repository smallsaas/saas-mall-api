package com.jfeat.am.module.store.services.domain.model;

import com.jfeat.am.common.constant.tips.Ids;


public class AssignAppointmentModel {
    Long staffId;
    Ids ids;

    public Ids getIds() {
        return ids;
    }

    public void setIds(Ids ids) {
        this.ids = ids;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
