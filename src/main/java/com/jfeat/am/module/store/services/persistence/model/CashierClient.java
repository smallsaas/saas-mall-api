package com.jfeat.am.module.store.services.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2018-06-09
 */
@TableName("t_cashier_client")
public class CashierClient extends Model<CashierClient> {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	@TableField("store_id")
	private Long storeId;
	private String code;
	private String factory;
	private String model;
	@TableField("create_time")
	private Date createTime;
	@TableField("org_id")
	private Long orgId;

	public Long getId() {
		return id;
	}

	public CashierClient setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getStoreId() {
		return storeId;
	}

	public CashierClient setStoreId(Long storeId) {
		this.storeId = storeId;
		return this;
	}

	public String getCode() {
		return code;
	}

	public CashierClient setCode(String code) {
		this.code = code;
		return this;
	}

	public String getFactory() {
		return factory;
	}

	public CashierClient setFactory(String factory) {
		this.factory = factory;
		return this;
	}

	public String getModel() {
		return model;
	}

	public CashierClient setModel(String model) {
		this.model = model;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public CashierClient setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public static final String ID = "id";

	public static final String STORE_ID = "store_id";

	public static final String CODE = "code";

	public static final String FACTORY = "factory";

	public static final String MODEL = "model";

	public static final String CREATE_TIME = "create_time";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CashierClient{" +
			"id=" + id +
			", storeId=" + storeId +
			", code=" + code +
			", factory=" + factory +
			", model=" + model +
			", createTime=" + createTime +
			"}";
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
