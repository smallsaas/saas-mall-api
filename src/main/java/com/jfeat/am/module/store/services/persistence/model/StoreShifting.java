package com.jfeat.am.module.store.services.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Code Generator
 * @since 2018-06-09
 */
@TableName("t_store_shifting")
public class StoreShifting extends Model<StoreShifting> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("store_id")
    private Long storeId;
    @TableField("cashier_client_id")
    private Long cashierClientId;
    @TableField("assistant_id")
    private Long assistantId;
    private String cashier;
    @TableField("next_assistant_id")
    private Long nextAssistantId;
    @TableField("next_cashier")
    private String nextCashier;
    private String status;
    @TableField("on_duty_time")
    private Date onDutyTime;
    @TableField("log_time")
    private Date logTime;
    @TableField("on_duty_amount")
    private BigDecimal onDutyAmount;
    @TableField("log_amount")
    private BigDecimal logAmount;

    @TableField("apply_time")
    private Date applyTime;

    @TableField("confirm_time")
    private Date confirmTime;
    @TableField("org_id")
    private Long orgId;

    public Long getId() {
        return id;
    }

    public StoreShifting setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getStoreId() {
        return storeId;
    }

    public StoreShifting setStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public Long getCashierClientId() {
        return cashierClientId;
    }

    public StoreShifting setCashierClientId(Long cashierClientId) {
        this.cashierClientId = cashierClientId;
        return this;
    }

    public Long getAssistantId() {
        return assistantId;
    }

    public StoreShifting setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
        return this;
    }

    public String getCashier() {
        return cashier;
    }

    public StoreShifting setCashier(String cashier) {
        this.cashier = cashier;
        return this;
    }

    public Long getNextAssistantId() {
        return nextAssistantId;
    }

    public StoreShifting setNextAssistantId(Long nextAssistantId) {
        this.nextAssistantId = nextAssistantId;
        return this;
    }

    public String getNextCashier() {
        return nextCashier;
    }

    public StoreShifting setNextCashier(String nextCashier) {
        this.nextCashier = nextCashier;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public StoreShifting setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getOnDutyTime() {
        return onDutyTime;
    }

    public StoreShifting setOnDutyTime(Date onDutyTime) {
        this.onDutyTime = onDutyTime;
        return this;
    }

    public Date getLogTime() {
        return logTime;
    }

    public StoreShifting setLogTime(Date logTime) {
        this.logTime = logTime;
        return this;
    }

    public BigDecimal getOnDutyAmount() {
        return onDutyAmount;
    }

    public StoreShifting setOnDutyAmount(BigDecimal onDutyAmount) {
        this.onDutyAmount = onDutyAmount;
        return this;
    }

    public BigDecimal getLogAmount() {
        return logAmount;
    }

    public StoreShifting setLogAmount(BigDecimal logAmount) {
        this.logAmount = logAmount;
        return this;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public static final String ID = "id";

    public static final String STORE_ID = "store_id";

    public static final String CASHIER_CLIENT_ID = "cashier_client_id";

    public static final String ASSISTANT_ID = "assistant_id";

    public static final String CASHIER = "cashier";

    public static final String NEXT_ASSISTANT_ID = "next_assistant_id";

    public static final String NEXT_CASHIER = "next_cashier";

    public static final String STATUS = "status";

    public static final String ON_DUTY_TIME = "on_duty_time";

    public static final String LOG_TIME = "log_time";

    public static final String ON_DUTY_AMOUNT = "on_duty_amount";

    public static final String LOG_AMOUNT = "log_amount";

    public static final String APPLY_TIME = "apply_time";

    public static final String CONFIRM_TIME = "confirm_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StoreShifting{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", cashierClientId=" + cashierClientId +
                ", assistantId=" + assistantId +
                ", cashier=" + cashier +
                ", nextAssistantId=" + nextAssistantId +
                ", nextCashier=" + nextCashier +
                ", status=" + status +
                ", onDutyTime=" + onDutyTime +
                ", applyTime=" + applyTime +
                ", confirmTime=" + confirmTime +
                ", logTime=" + logTime +
                ", onDutyAmount=" + onDutyAmount +
                ", logAmount=" + logAmount +
                "}";
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
