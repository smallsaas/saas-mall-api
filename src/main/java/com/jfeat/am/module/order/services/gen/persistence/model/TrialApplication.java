package com.jfeat.am.module.order.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-08-02
 */
@TableName("t_trial_application")
public class TrialApplication extends Model<TrialApplication> {

    @com.baomidou.mybatisplus.annotation.TableField(exist = false)
    private com.alibaba.fastjson.JSONObject extra;

    public com.alibaba.fastjson.JSONObject getExtra() {
        return extra;
    }
    public void setExtra(com.alibaba.fastjson.JSONObject extra) {
        this.extra = extra;
    }


    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 试用活动id
     */
	@TableField("trial_id")
	private Integer trialId;
    /**
     * 订单id
     */
	@TableField("order_id")
	private Integer orderId;
    /**
     * 订单号
     */
	@TableField("order_number")
	private String orderNumber;
    /**
     * 申请人id
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 创建时间
     */
	@TableField("created_time")
	private Date createdTime;
    /**
     * 状态
     */
	private String status;
    /**
     * 0 包邮 1 根据产品计算
     */
	@TableField("shipping_type")
	private Integer shippingType;
    /**
     * 描述
     */
	private String note;
    /**
     * 版本号
     */
	private Integer version;
	@TableField("org_id")
	private Long orgId;


	public Long getId() {
		return id;
	}

	public TrialApplication setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getTrialId() {
		return trialId;
	}

	public TrialApplication setTrialId(Integer trialId) {
		this.trialId = trialId;
		return this;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public TrialApplication setOrderId(Integer orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public TrialApplication setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public TrialApplication setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public TrialApplication setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public TrialApplication setStatus(String status) {
		this.status = status;
		return this;
	}

	public Integer getShippingType() {
		return shippingType;
	}

	public TrialApplication setShippingType(Integer shippingType) {
		this.shippingType = shippingType;
		return this;
	}

	public String getNote() {
		return note;
	}

	public TrialApplication setNote(String note) {
		this.note = note;
		return this;
	}

	public Integer getVersion() {
		return version;
	}

	public TrialApplication setVersion(Integer version) {
		this.version = version;
		return this;
	}

	public Long getOrgId() {
		return orgId;
	}

	public TrialApplication setOrgId(Long orgId) {
		this.orgId = orgId;
		return this;
	}

	public static final String ID = "id";

	public static final String TRIAL_ID = "trial_id";

	public static final String ORDER_ID = "order_id";

	public static final String ORDER_NUMBER = "order_number";

	public static final String USER_ID = "user_id";

	public static final String CREATED_TIME = "created_time";

	public static final String STATUS = "status";

	public static final String SHIPPING_TYPE = "shipping_type";

	public static final String NOTE = "note";

	public static final String VERSION = "version";

	public static final String ORG_ID = "org_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "TrialApplication{" +
			"id=" + id +
			", trialId=" + trialId +
			", orderId=" + orderId +
			", orderNumber=" + orderNumber +
			", userId=" + userId +
			", createdTime=" + createdTime +
			", status=" + status +
			", shippingType=" + shippingType +
			", note=" + note +
			", version=" + version +
			", orgId=" + orgId +
			"}";
	}
}
