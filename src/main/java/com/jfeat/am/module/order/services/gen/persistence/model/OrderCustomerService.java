package com.jfeat.am.module.order.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-31
 */
@TableName("t_order_customer_service")
public class OrderCustomerService extends Model<OrderCustomerService> {

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
	private Integer id;
	@TableField("order_id")
	private Integer orderId;
	@TableField("created_date")
	private Date createdDate;
	@TableField("express_number")
	private String expressNumber;
	@TableField("express_company")
	private String expressCompany;
	@TableField("express_code")
	private String expressCode;
	private String reason;
	@TableField("service_type")
	private String serviceType;
	private String status;
	private String log;
	private String images;
	@TableField("refund_fee")
	private BigDecimal refundFee;
    /**
     * 补款金额(用于换货单)
     */
	@TableField("supplementary_fee")
	private BigDecimal supplementaryFee;
	@TableField("store_id")
	private String storeId;
	@TableField("store_name")
	private String storeName;
	@TableField("store_user_id")
	private String storeUserId;
	@TableField("store_user_name")
	private String storeUserName;
    /**
     * 售后单号
     */
	@TableField("service_number")
	private String serviceNumber;
    /**
     * 处理结果
     */
	private String result;
	@TableField("refund_way")
	private String refundWay;


	public Integer getId() {
		return id;
	}

	public OrderCustomerService setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public OrderCustomerService setOrderId(Integer orderId) {
		this.orderId = orderId;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public OrderCustomerService setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public OrderCustomerService setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
		return this;
	}

	public String getExpressCompany() {
		return expressCompany;
	}

	public OrderCustomerService setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
		return this;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public OrderCustomerService setExpressCode(String expressCode) {
		this.expressCode = expressCode;
		return this;
	}

	public String getReason() {
		return reason;
	}

	public OrderCustomerService setReason(String reason) {
		this.reason = reason;
		return this;
	}

	public String getServiceType() {
		return serviceType;
	}

	public OrderCustomerService setServiceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public OrderCustomerService setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getLog() {
		return log;
	}

	public OrderCustomerService setLog(String log) {
		this.log = log;
		return this;
	}

	public String getImages() {
		return images;
	}

	public OrderCustomerService setImages(String images) {
		this.images = images;
		return this;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public OrderCustomerService setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
		return this;
	}

	public BigDecimal getSupplementaryFee() {
		return supplementaryFee;
	}

	public OrderCustomerService setSupplementaryFee(BigDecimal supplementaryFee) {
		this.supplementaryFee = supplementaryFee;
		return this;
	}

	public String getStoreId() {
		return storeId;
	}

	public OrderCustomerService setStoreId(String storeId) {
		this.storeId = storeId;
		return this;
	}

	public String getStoreName() {
		return storeName;
	}

	public OrderCustomerService setStoreName(String storeName) {
		this.storeName = storeName;
		return this;
	}

	public String getStoreUserId() {
		return storeUserId;
	}

	public OrderCustomerService setStoreUserId(String storeUserId) {
		this.storeUserId = storeUserId;
		return this;
	}

	public String getStoreUserName() {
		return storeUserName;
	}

	public OrderCustomerService setStoreUserName(String storeUserName) {
		this.storeUserName = storeUserName;
		return this;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public OrderCustomerService setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
		return this;
	}

	public String getResult() {
		return result;
	}

	public OrderCustomerService setResult(String result) {
		this.result = result;
		return this;
	}

	public String getRefundWay() {
		return refundWay;
	}

	public OrderCustomerService setRefundWay(String refundWay) {
		this.refundWay = refundWay;
		return this;
	}

	public static final String ID = "id";

	public static final String ORDER_ID = "order_id";

	public static final String CREATED_DATE = "created_date";

	public static final String EXPRESS_NUMBER = "express_number";

	public static final String EXPRESS_COMPANY = "express_company";

	public static final String EXPRESS_CODE = "express_code";

	public static final String REASON = "reason";

	public static final String SERVICE_TYPE = "service_type";

	public static final String STATUS = "status";

	public static final String LOG = "log";

	public static final String IMAGES = "images";

	public static final String REFUND_FEE = "refund_fee";

	public static final String SUPPLEMENTARY_FEE = "supplementary_fee";

	public static final String STORE_ID = "store_id";

	public static final String STORE_NAME = "store_name";

	public static final String STORE_USER_ID = "store_user_id";

	public static final String STORE_USER_NAME = "store_user_name";

	public static final String SERVICE_NUMBER = "service_number";

	public static final String RESULT = "result";

	public static final String REFUND_WAY = "refund_way";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "OrderCustomerService{" +
			"id=" + id +
			", orderId=" + orderId +
			", createdDate=" + createdDate +
			", expressNumber=" + expressNumber +
			", expressCompany=" + expressCompany +
			", expressCode=" + expressCode +
			", reason=" + reason +
			", serviceType=" + serviceType +
			", status=" + status +
			", log=" + log +
			", images=" + images +
			", refundFee=" + refundFee +
			", supplementaryFee=" + supplementaryFee +
			", storeId=" + storeId +
			", storeName=" + storeName +
			", storeUserId=" + storeUserId +
			", storeUserName=" + storeUserName +
			", serviceNumber=" + serviceNumber +
			", result=" + result +
			", refundWay=" + refundWay +
			"}";
	}
}
