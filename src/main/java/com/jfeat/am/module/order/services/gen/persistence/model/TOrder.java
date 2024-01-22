package com.jfeat.am.module.order.services.gen.persistence.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-31
 */
@TableName("t_order")
public class TOrder extends Model<TOrder> {

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
	@TableField("user_id")
	private Integer userId;
	@TableField("order_number")
	private String orderNumber;
	@TableField("trade_number")
	private String tradeNumber;
	@TableField("payment_type")
	private String paymentType;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@TableField("created_date")
	private Date createdDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@TableField("pay_date")
	private Date payDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@TableField("confirm_date")
	private Date confirmDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@TableField("deliver_date")
	private Date deliverDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@TableField("delivered_date")
	private Date deliveredDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@TableField("deal_date")
	private Date dealDate;
	@TableField("deliver_order_number")
	private String deliverOrderNumber;
	private String status;

	//价格
	@TableField("total_price")
	private BigDecimal totalPrice;
	private BigDecimal freight;
	private String description;
	private String remark;
	private Integer invoice;
	@TableField("invoice_title")
	private String invoiceTitle;
	@TableField("receiving_time")
	private String receivingTime;
	private String zip;
	@TableField("contact_user")
	private String contactUser;
	private String phone;
	private String province;
	private String city;
	private String district;
	private String street;
	private String detail;
	private String cover;
	@TableField("express_number")
	private String expressNumber;
	@TableField("express_company")
	private String expressCompany;
	@TableField("express_code")
	private String expressCode;
	private Integer settled;
	@TableField("previous_status")
	private String previousStatus;
	@TableField("is_deliver_reminder")
	private Integer isDeliverReminder;
	@TableField("is_deleted")
	private Integer isDeleted;
	@TableField("point_exchange_rate")
	private Integer pointExchangeRate;
	@TableField("coupon_info")
	private String couponInfo;
	private String marketing;
	@TableField("marketing_id")
	private Integer marketingId;
	@TableField("marketing_description")
	private String marketingDescription;
	private Integer mid;
	private String mname;
	@TableField("store_id")
	private String storeId;
	@TableField("store_name")
	private String storeName;
	@TableField("store_user_id")
	private String storeUserId;
	@TableField("store_user_name")
	private String storeUserName;
	private String type;
	@TableField("pay_credit")
	private Integer payCredit;
	@TableField("delivery_type")
	private String deliveryType;
	private String origin;
	@TableField("store_user_code")
	private String storeUserCode;
	@TableField("store_code")
	private String storeCode;
	@TableField("store_cover")
	private String storeCover;
	@TableField("store_guide_user_id")
	private String storeGuideUserId;
	@TableField("store_guide_user_code")
	private String storeGuideUserCode;
	@TableField("store_guide_user_name")
	private String storeGuideUserName;
	@TableField("inviter_user_id")
	private String inviterUserId;
	@TableField("inviter_user_name")
	private String inviterUserName;
	@TableField("followed_store_id")
	private String followedStoreId;
	@TableField("followed_store_code")
	private String followedStoreCode;
	@TableField("followed_store_name")
	private String followedStoreName;
	@TableField("followed_store_cover")
	private String followedStoreCover;
    /**
     * 评价ID
     */
	@TableField("comment_id")
	private String commentId;
	@TableField("binding_store_id")
	private String bindingStoreId;
	@TableField("binding_store_code")
	private String bindingStoreCode;
	@TableField("binding_store_name")
	private String bindingStoreName;
	@TableField("binding_store_cover")
	private String bindingStoreCover;
    /**
     * 退货款金额
     */
	@TableField("refund_fee")
	private BigDecimal refundFee;
	@TableField("store_address")
	private String storeAddress;
    /**
     * 换货补差价金额
     */
	@TableField("supplementary_fee")
	private BigDecimal supplementaryFee;
    /**
     * 原价
     */
	@TableField("origin_price")
	private BigDecimal originPrice;
    /**
     * 优惠券价钱
     */
	@TableField("coupon_price")
	private BigDecimal couponPrice;
    /**
     * 积分抵扣价钱
     */
	@TableField("credit_price")
	private BigDecimal creditPrice;
    /**
     * 第三方优惠券的优惠券ID
     */
	@TableField("ext_coupon_id")
	private String extCouponId;
    /**
     * 第三方优惠券的用户类型
     */
	@TableField("ext_user_type")
	private String extUserType;
    /**
     * 第三方优惠券的优惠券类型
     */
	@TableField("ext_coupon_type")
	private String extCouponType;
    /**
     * 第三方优惠券的折扣率
     */
	@TableField("ext_discount")
	private Integer extDiscount;
    /**
     * 第三方优惠券的优惠
     */
	@TableField("ext_cuts")
	private Integer extCuts;
	@TableField("org_id")
	private Long orgId;

	@TableField("tenant_id")
	private Long tenantId;

	private Integer settlementStatus;

	/**
	 * 订单类别
	 */
	private String category;

	/**
	 * 负责跟进的客服人员id
	 */
	private Long assistantId;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(Integer settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public Long getId() {
		return id;
	}

	public TOrder setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public TOrder setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public TOrder setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public String getTradeNumber() {
		return tradeNumber;
	}

	public TOrder setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
		return this;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public TOrder setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public TOrder setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public Date getPayDate() {
		return payDate;
	}

	public TOrder setPayDate(Date payDate) {
		this.payDate = payDate;
		return this;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public TOrder setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
		return this;
	}

	public Date getDeliverDate() {
		return deliverDate;
	}

	public TOrder setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
		return this;
	}

	public Date getDeliveredDate() {
		return deliveredDate;
	}

	public TOrder setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
		return this;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public TOrder setDealDate(Date dealDate) {
		this.dealDate = dealDate;
		return this;
	}

	public String getDeliverOrderNumber() {
		return deliverOrderNumber;
	}

	public TOrder setDeliverOrderNumber(String deliverOrderNumber) {
		this.deliverOrderNumber = deliverOrderNumber;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public TOrder setStatus(String status) {
		this.status = status;
		return this;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public TOrder setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public TOrder setFreight(BigDecimal freight) {
		this.freight = freight;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public TOrder setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public TOrder setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getInvoice() {
		return invoice;
	}

	public TOrder setInvoice(Integer invoice) {
		this.invoice = invoice;
		return this;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public TOrder setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
		return this;
	}

	public String getReceivingTime() {
		return receivingTime;
	}

	public TOrder setReceivingTime(String receivingTime) {
		this.receivingTime = receivingTime;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public TOrder setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public String getContactUser() {
		return contactUser;
	}

	public TOrder setContactUser(String contactUser) {
		this.contactUser = contactUser;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public TOrder setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getProvince() {
		return province;
	}

	public TOrder setProvince(String province) {
		this.province = province;
		return this;
	}

	public String getCity() {
		return city;
	}

	public TOrder setCity(String city) {
		this.city = city;
		return this;
	}

	public String getDistrict() {
		return district;
	}

	public TOrder setDistrict(String district) {
		this.district = district;
		return this;
	}

	public String getStreet() {
		return street;
	}

	public TOrder setStreet(String street) {
		this.street = street;
		return this;
	}

	public String getDetail() {
		return detail;
	}

	public TOrder setDetail(String detail) {
		this.detail = detail;
		return this;
	}

	public String getCover() {
		return cover;
	}

	public TOrder setCover(String cover) {
		this.cover = cover;
		return this;
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public TOrder setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
		return this;
	}

	public String getExpressCompany() {
		return expressCompany;
	}

	public TOrder setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
		return this;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public TOrder setExpressCode(String expressCode) {
		this.expressCode = expressCode;
		return this;
	}

	public Integer getSettled() {
		return settled;
	}

	public TOrder setSettled(Integer settled) {
		this.settled = settled;
		return this;
	}

	public String getPreviousStatus() {
		return previousStatus;
	}

	public TOrder setPreviousStatus(String previousStatus) {
		this.previousStatus = previousStatus;
		return this;
	}

	public Integer getIsDeliverReminder() {
		return isDeliverReminder;
	}

	public TOrder setIsDeliverReminder(Integer isDeliverReminder) {
		this.isDeliverReminder = isDeliverReminder;
		return this;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public TOrder setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}

	public Integer getPointExchangeRate() {
		return pointExchangeRate;
	}

	public TOrder setPointExchangeRate(Integer pointExchangeRate) {
		this.pointExchangeRate = pointExchangeRate;
		return this;
	}

	public String getCouponInfo() {
		return couponInfo;
	}

	public TOrder setCouponInfo(String couponInfo) {
		this.couponInfo = couponInfo;
		return this;
	}

	public String getMarketing() {
		return marketing;
	}

	public TOrder setMarketing(String marketing) {
		this.marketing = marketing;
		return this;
	}

	public Integer getMarketingId() {
		return marketingId;
	}

	public TOrder setMarketingId(Integer marketingId) {
		this.marketingId = marketingId;
		return this;
	}

	public String getMarketingDescription() {
		return marketingDescription;
	}

	public TOrder setMarketingDescription(String marketingDescription) {
		this.marketingDescription = marketingDescription;
		return this;
	}

	public Integer getMid() {
		return mid;
	}

	public TOrder setMid(Integer mid) {
		this.mid = mid;
		return this;
	}

	public String getMname() {
		return mname;
	}

	public TOrder setMname(String mname) {
		this.mname = mname;
		return this;
	}

	public String getStoreId() {
		return storeId;
	}

	public TOrder setStoreId(String storeId) {
		this.storeId = storeId;
		return this;
	}

	public String getStoreName() {
		return storeName;
	}

	public TOrder setStoreName(String storeName) {
		this.storeName = storeName;
		return this;
	}

	public String getStoreUserId() {
		return storeUserId;
	}

	public TOrder setStoreUserId(String storeUserId) {
		this.storeUserId = storeUserId;
		return this;
	}

	public String getStoreUserName() {
		return storeUserName;
	}

	public TOrder setStoreUserName(String storeUserName) {
		this.storeUserName = storeUserName;
		return this;
	}

	public String getType() {
		return type;
	}

	public TOrder setType(String type) {
		this.type = type;
		return this;
	}

	public Integer getPayCredit() {
		return payCredit;
	}

	public TOrder setPayCredit(Integer payCredit) {
		this.payCredit = payCredit;
		return this;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public TOrder setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
		return this;
	}

	public String getOrigin() {
		return origin;
	}

	public TOrder setOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public String getStoreUserCode() {
		return storeUserCode;
	}

	public TOrder setStoreUserCode(String storeUserCode) {
		this.storeUserCode = storeUserCode;
		return this;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public TOrder setStoreCode(String storeCode) {
		this.storeCode = storeCode;
		return this;
	}

	public String getStoreCover() {
		return storeCover;
	}

	public TOrder setStoreCover(String storeCover) {
		this.storeCover = storeCover;
		return this;
	}

	public String getStoreGuideUserId() {
		return storeGuideUserId;
	}

	public TOrder setStoreGuideUserId(String storeGuideUserId) {
		this.storeGuideUserId = storeGuideUserId;
		return this;
	}

	public String getStoreGuideUserCode() {
		return storeGuideUserCode;
	}

	public TOrder setStoreGuideUserCode(String storeGuideUserCode) {
		this.storeGuideUserCode = storeGuideUserCode;
		return this;
	}

	public String getStoreGuideUserName() {
		return storeGuideUserName;
	}

	public TOrder setStoreGuideUserName(String storeGuideUserName) {
		this.storeGuideUserName = storeGuideUserName;
		return this;
	}

	public String getInviterUserId() {
		return inviterUserId;
	}

	public TOrder setInviterUserId(String inviterUserId) {
		this.inviterUserId = inviterUserId;
		return this;
	}

	public String getInviterUserName() {
		return inviterUserName;
	}

	public TOrder setInviterUserName(String inviterUserName) {
		this.inviterUserName = inviterUserName;
		return this;
	}

	public String getFollowedStoreId() {
		return followedStoreId;
	}

	public TOrder setFollowedStoreId(String followedStoreId) {
		this.followedStoreId = followedStoreId;
		return this;
	}

	public String getFollowedStoreCode() {
		return followedStoreCode;
	}

	public TOrder setFollowedStoreCode(String followedStoreCode) {
		this.followedStoreCode = followedStoreCode;
		return this;
	}

	public String getFollowedStoreName() {
		return followedStoreName;
	}

	public TOrder setFollowedStoreName(String followedStoreName) {
		this.followedStoreName = followedStoreName;
		return this;
	}

	public String getFollowedStoreCover() {
		return followedStoreCover;
	}

	public TOrder setFollowedStoreCover(String followedStoreCover) {
		this.followedStoreCover = followedStoreCover;
		return this;
	}

	public String getCommentId() {
		return commentId;
	}

	public TOrder setCommentId(String commentId) {
		this.commentId = commentId;
		return this;
	}

	public String getBindingStoreId() {
		return bindingStoreId;
	}

	public TOrder setBindingStoreId(String bindingStoreId) {
		this.bindingStoreId = bindingStoreId;
		return this;
	}

	public String getBindingStoreCode() {
		return bindingStoreCode;
	}

	public TOrder setBindingStoreCode(String bindingStoreCode) {
		this.bindingStoreCode = bindingStoreCode;
		return this;
	}

	public String getBindingStoreName() {
		return bindingStoreName;
	}

	public TOrder setBindingStoreName(String bindingStoreName) {
		this.bindingStoreName = bindingStoreName;
		return this;
	}

	public String getBindingStoreCover() {
		return bindingStoreCover;
	}

	public TOrder setBindingStoreCover(String bindingStoreCover) {
		this.bindingStoreCover = bindingStoreCover;
		return this;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public TOrder setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
		return this;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public TOrder setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
		return this;
	}

	public BigDecimal getSupplementaryFee() {
		return supplementaryFee;
	}

	public TOrder setSupplementaryFee(BigDecimal supplementaryFee) {
		this.supplementaryFee = supplementaryFee;
		return this;
	}

	public BigDecimal getOriginPrice() {
		return originPrice;
	}

	public TOrder setOriginPrice(BigDecimal originPrice) {
		this.originPrice = originPrice;
		return this;
	}

	public BigDecimal getCouponPrice() {
		return couponPrice;
	}

	public TOrder setCouponPrice(BigDecimal couponPrice) {
		this.couponPrice = couponPrice;
		return this;
	}

	public BigDecimal getCreditPrice() {
		return creditPrice;
	}

	public TOrder setCreditPrice(BigDecimal creditPrice) {
		this.creditPrice = creditPrice;
		return this;
	}

	public String getExtCouponId() {
		return extCouponId;
	}

	public TOrder setExtCouponId(String extCouponId) {
		this.extCouponId = extCouponId;
		return this;
	}

	public String getExtUserType() {
		return extUserType;
	}

	public TOrder setExtUserType(String extUserType) {
		this.extUserType = extUserType;
		return this;
	}

	public String getExtCouponType() {
		return extCouponType;
	}

	public TOrder setExtCouponType(String extCouponType) {
		this.extCouponType = extCouponType;
		return this;
	}

	public Integer getExtDiscount() {
		return extDiscount;
	}

	public TOrder setExtDiscount(Integer extDiscount) {
		this.extDiscount = extDiscount;
		return this;
	}

	public Integer getExtCuts() {
		return extCuts;
	}

	public TOrder setExtCuts(Integer extCuts) {
		this.extCuts = extCuts;
		return this;
	}

	public Long getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(Long assistantId) {
		this.assistantId = assistantId;
	}

	public static final String ID = "id";

	public static final String USER_ID = "user_id";

	public static final String ORDER_NUMBER = "order_number";

	public static final String TRADE_NUMBER = "trade_number";

	public static final String PAYMENT_TYPE = "payment_type";

	public static final String CREATED_DATE = "created_date";

	public static final String PAY_DATE = "pay_date";

	public static final String CONFIRM_DATE = "confirm_date";

	public static final String DELIVER_DATE = "deliver_date";

	public static final String DELIVERED_DATE = "delivered_date";

	public static final String DEAL_DATE = "deal_date";

	public static final String DELIVER_ORDER_NUMBER = "deliver_order_number";

	public static final String STATUS = "status";

	public static final String TOTAL_PRICE = "total_price";

	public static final String FREIGHT = "freight";

	public static final String DESCRIPTION = "description";

	public static final String REMARK = "remark";

	public static final String INVOICE = "invoice";

	public static final String INVOICE_TITLE = "invoice_title";

	public static final String RECEIVING_TIME = "receiving_time";

	public static final String ZIP = "zip";

	public static final String CONTACT_USER = "contact_user";

	public static final String PHONE = "phone";

	public static final String PROVINCE = "province";

	public static final String CITY = "city";

	public static final String DISTRICT = "district";

	public static final String STREET = "street";

	public static final String DETAIL = "detail";

	public static final String COVER = "cover";

	public static final String EXPRESS_NUMBER = "express_number";

	public static final String EXPRESS_COMPANY = "express_company";

	public static final String EXPRESS_CODE = "express_code";

	public static final String SETTLED = "settled";

	public static final String PREVIOUS_STATUS = "previous_status";

	public static final String IS_DELIVER_REMINDER = "is_deliver_reminder";

	public static final String IS_DELETED = "is_deleted";

	public static final String POINT_EXCHANGE_RATE = "point_exchange_rate";

	public static final String COUPON_INFO = "coupon_info";

	public static final String MARKETING = "marketing";

	public static final String MARKETING_ID = "marketing_id";

	public static final String MARKETING_DESCRIPTION = "marketing_description";

	public static final String MID = "mid";

	public static final String MNAME = "mname";

	public static final String STORE_ID = "store_id";

	public static final String STORE_NAME = "store_name";

	public static final String STORE_USER_ID = "store_user_id";

	public static final String STORE_USER_NAME = "store_user_name";

	public static final String TYPE = "type";

	public static final String PAY_CREDIT = "pay_credit";

	public static final String DELIVERY_TYPE = "delivery_type";

	public static final String ORIGIN = "origin";

	public static final String STORE_USER_CODE = "store_user_code";

	public static final String STORE_CODE = "store_code";

	public static final String STORE_COVER = "store_cover";

	public static final String STORE_GUIDE_USER_ID = "store_guide_user_id";

	public static final String STORE_GUIDE_USER_CODE = "store_guide_user_code";

	public static final String STORE_GUIDE_USER_NAME = "store_guide_user_name";

	public static final String INVITER_USER_ID = "inviter_user_id";

	public static final String INVITER_USER_NAME = "inviter_user_name";

	public static final String FOLLOWED_STORE_ID = "followed_store_id";

	public static final String FOLLOWED_STORE_CODE = "followed_store_code";

	public static final String FOLLOWED_STORE_NAME = "followed_store_name";

	public static final String FOLLOWED_STORE_COVER = "followed_store_cover";

	public static final String COMMENT_ID = "comment_id";

	public static final String BINDING_STORE_ID = "binding_store_id";

	public static final String BINDING_STORE_CODE = "binding_store_code";

	public static final String BINDING_STORE_NAME = "binding_store_name";

	public static final String BINDING_STORE_COVER = "binding_store_cover";

	public static final String REFUND_FEE = "refund_fee";

	public static final String STORE_ADDRESS = "store_address";

	public static final String SUPPLEMENTARY_FEE = "supplementary_fee";

	public static final String ORIGIN_PRICE = "origin_price";

	public static final String COUPON_PRICE = "coupon_price";

	public static final String CREDIT_PRICE = "credit_price";

	public static final String EXT_COUPON_ID = "ext_coupon_id";

	public static final String EXT_USER_TYPE = "ext_user_type";

	public static final String EXT_COUPON_TYPE = "ext_coupon_type";

	public static final String EXT_DISCOUNT = "ext_discount";

	public static final String EXT_CUTS = "ext_cuts";

	public static final String CATEGORY = "category";

	public static final String ASSISTANT_ID = "assistant_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Order{" +
			"id=" + id +
			", userId=" + userId +
			", orderNumber=" + orderNumber +
			", tradeNumber=" + tradeNumber +
			", paymentType=" + paymentType +
			", createdDate=" + createdDate +
			", payDate=" + payDate +
			", confirmDate=" + confirmDate +
			", deliverDate=" + deliverDate +
			", deliveredDate=" + deliveredDate +
			", dealDate=" + dealDate +
			", deliverOrderNumber=" + deliverOrderNumber +
			", status=" + status +
			", totalPrice=" + totalPrice +
			", freight=" + freight +
			", description=" + description +
			", remark=" + remark +
			", invoice=" + invoice +
			", invoiceTitle=" + invoiceTitle +
			", receivingTime=" + receivingTime +
			", zip=" + zip +
			", contactUser=" + contactUser +
			", phone=" + phone +
			", province=" + province +
			", city=" + city +
			", district=" + district +
			", street=" + street +
			", detail=" + detail +
			", cover=" + cover +
			", expressNumber=" + expressNumber +
			", expressCompany=" + expressCompany +
			", expressCode=" + expressCode +
			", settled=" + settled +
			", previousStatus=" + previousStatus +
			", isDeliverReminder=" + isDeliverReminder +
			", isDeleted=" + isDeleted +
			", pointExchangeRate=" + pointExchangeRate +
			", couponInfo=" + couponInfo +
			", marketing=" + marketing +
			", marketingId=" + marketingId +
			", marketingDescription=" + marketingDescription +
			", mid=" + mid +
			", mname=" + mname +
			", storeId=" + storeId +
			", storeName=" + storeName +
			", storeUserId=" + storeUserId +
			", storeUserName=" + storeUserName +
			", type=" + type +
			", payCredit=" + payCredit +
			", deliveryType=" + deliveryType +
			", origin=" + origin +
			", storeUserCode=" + storeUserCode +
			", storeCode=" + storeCode +
			", storeCover=" + storeCover +
			", storeGuideUserId=" + storeGuideUserId +
			", storeGuideUserCode=" + storeGuideUserCode +
			", storeGuideUserName=" + storeGuideUserName +
			", inviterUserId=" + inviterUserId +
			", inviterUserName=" + inviterUserName +
			", followedStoreId=" + followedStoreId +
			", followedStoreCode=" + followedStoreCode +
			", followedStoreName=" + followedStoreName +
			", followedStoreCover=" + followedStoreCover +
			", commentId=" + commentId +
			", bindingStoreId=" + bindingStoreId +
			", bindingStoreCode=" + bindingStoreCode +
			", bindingStoreName=" + bindingStoreName +
			", bindingStoreCover=" + bindingStoreCover +
			", refundFee=" + refundFee +
			", storeAddress=" + storeAddress +
			", supplementaryFee=" + supplementaryFee +
			", originPrice=" + originPrice +
			", couponPrice=" + couponPrice +
			", creditPrice=" + creditPrice +
			", extCouponId=" + extCouponId +
			", extUserType=" + extUserType +
			", extCouponType=" + extCouponType +
			", extDiscount=" + extDiscount +
			", extCuts=" + extCuts +
			", assistantId" + assistantId +
			"}";
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
