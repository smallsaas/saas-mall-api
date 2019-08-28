package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

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
 * @since 2019-08-02
 */
@TableName("t_trial")
public class Trial extends Model<Trial> {

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
    /**
     * 产品id
     */
	@TableField("product_id")
	private Integer productId;
    /**
     * 价格
     */
	private BigDecimal price;
    /**
     * 试用装名称
     */
	private String name;
    /**
     * 简短描述
     */
	@TableField("short_note")
	private String shortNote;
    /**
     * 是否启用
     */
	private Integer enabled;
    /**
     * 有效申请时间
     */
	@TableField("start_time")
	private Date startTime;
    /**
     * 过期时间
     */
	@TableField("end_time")
	private Date endTime;
    /**
     * 试用装封面
     */
	private String cover;
    /**
     * 描述
     */
	private String note;
    /**
     * 排序号
     */
	private Integer index;
    /**
     * 运费支付 0 商家 1 顾客
     */
	@TableField("shipping_type")
	private Integer shippingType;
    /**
     * 支付方式
     */
	@TableField("payment_type")
	private String paymentType;
    /**
     * 版本号
     */
	private Integer version;

	@TableField("org_id")
	private Long orgId;

	public Long getId() {
		return id;
	}

	public Trial setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getProductId() {
		return productId;
	}

	public Trial setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Trial setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public String getName() {
		return name;
	}

	public Trial setName(String name) {
		this.name = name;
		return this;
	}

	public String getShortNote() {
		return shortNote;
	}

	public Trial setShortNote(String shortNote) {
		this.shortNote = shortNote;
		return this;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public Trial setEnabled(Integer enabled) {
		this.enabled = enabled;
		return this;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Trial setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Trial setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public String getCover() {
		return cover;
	}

	public Trial setCover(String cover) {
		this.cover = cover;
		return this;
	}

	public String getNote() {
		return note;
	}

	public Trial setNote(String note) {
		this.note = note;
		return this;
	}

	public Integer getIndex() {
		return index;
	}

	public Trial setIndex(Integer index) {
		this.index = index;
		return this;
	}

	public Integer getShippingType() {
		return shippingType;
	}

	public Trial setShippingType(Integer shippingType) {
		this.shippingType = shippingType;
		return this;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public Trial setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public Integer getVersion() {
		return version;
	}

	public Trial setVersion(Integer version) {
		this.version = version;
		return this;
	}

	public static final String ID = "id";

	public static final String PRODUCT_ID = "product_id";

	public static final String PRICE = "price";

	public static final String NAME = "name";

	public static final String SHORT_NOTE = "short_note";

	public static final String ENABLED = "enabled";

	public static final String START_TIME = "start_time";

	public static final String END_TIME = "end_time";

	public static final String COVER = "cover";

	public static final String NOTE = "note";

	public static final String INDEX = "index";

	public static final String SHIPPING_TYPE = "shipping_type";

	public static final String PAYMENT_TYPE = "payment_type";

	public static final String VERSION = "version";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Trial{" +
			"id=" + id +
			", productId=" + productId +
			", price=" + price +
			", name=" + name +
			", shortNote=" + shortNote +
			", enabled=" + enabled +
			", startTime=" + startTime +
			", endTime=" + endTime +
			", cover=" + cover +
			", note=" + note +
			", index=" + index +
			", shippingType=" + shippingType +
			", paymentType=" + paymentType +
			", version=" + version +
			"}";
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
