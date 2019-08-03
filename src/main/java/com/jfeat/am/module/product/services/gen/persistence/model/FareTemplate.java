package com.jfeat.am.module.product.services.gen.persistence.model;

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
 * @since 2019-07-31
 */
@TableName("t_fare_template")
public class FareTemplate extends Model<FareTemplate> {

    @com.baomidou.mybatisplus.annotations.TableField(exist = false)
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
	private String name;
	@TableField("shop_addr")
	private String shopAddr;
	@TableField("dispatch_time")
	private String dispatchTime;
	@TableField("is_incl_postage")
	private Integer isInclPostage;
	@TableField("valuation_model")
	private Integer valuationModel;
	@TableField("is_incl_postage_by_if")
	private Integer isInclPostageByIf;
	@TableField("last_modified_date")
	private Date lastModifiedDate;
	private String title;
	private String content;
	@TableField("message_format")
	private String messageFormat;
	@TableField("org_id")
	private Long orgId;

	public Long getId() {
		return id;
	}

	public FareTemplate setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public FareTemplate setName(String name) {
		this.name = name;
		return this;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public FareTemplate setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
		return this;
	}

	public String getDispatchTime() {
		return dispatchTime;
	}

	public FareTemplate setDispatchTime(String dispatchTime) {
		this.dispatchTime = dispatchTime;
		return this;
	}

	public Integer getIsInclPostage() {
		return isInclPostage;
	}

	public FareTemplate setIsInclPostage(Integer isInclPostage) {
		this.isInclPostage = isInclPostage;
		return this;
	}

	public Integer getValuationModel() {
		return valuationModel;
	}

	public FareTemplate setValuationModel(Integer valuationModel) {
		this.valuationModel = valuationModel;
		return this;
	}

	public Integer getIsInclPostageByIf() {
		return isInclPostageByIf;
	}

	public FareTemplate setIsInclPostageByIf(Integer isInclPostageByIf) {
		this.isInclPostageByIf = isInclPostageByIf;
		return this;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public FareTemplate setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public FareTemplate setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getContent() {
		return content;
	}

	public FareTemplate setContent(String content) {
		this.content = content;
		return this;
	}

	public String getMessageFormat() {
		return messageFormat;
	}

	public FareTemplate setMessageFormat(String messageFormat) {
		this.messageFormat = messageFormat;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String SHOP_ADDR = "shop_addr";

	public static final String DISPATCH_TIME = "dispatch_time";

	public static final String IS_INCL_POSTAGE = "is_incl_postage";

	public static final String VALUATION_MODEL = "valuation_model";

	public static final String IS_INCL_POSTAGE_BY_IF = "is_incl_postage_by_if";

	public static final String LAST_MODIFIED_DATE = "last_modified_date";

	public static final String TITLE = "title";

	public static final String CONTENT = "content";

	public static final String MESSAGE_FORMAT = "message_format";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "FareTemplate{" +
			"id=" + id +
			", name=" + name +
			", shopAddr=" + shopAddr +
			", dispatchTime=" + dispatchTime +
			", isInclPostage=" + isInclPostage +
			", valuationModel=" + valuationModel +
			", isInclPostageByIf=" + isInclPostageByIf +
			", lastModifiedDate=" + lastModifiedDate +
			", title=" + title +
			", content=" + content +
			", messageFormat=" + messageFormat +
			"}";
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
