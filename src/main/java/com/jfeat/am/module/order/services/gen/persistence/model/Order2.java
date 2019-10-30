package com.jfeat.am.module.order.services.gen.persistence.model;

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
 * @since 2019-10-17
 */
@TableName("t_order")
public class Order2 extends Model<Order2> {

    @TableField(exist = false)
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
	private Long userId;
	@TableField("Order2_number")
	private String Order2Number;
	@TableField("trade_number")
	private String tradeNumber;
	@TableField("payment_type")
	private String paymentType;
	@TableField("created_date")
	private Date createdDate;
	@TableField("pay_date")
	private Date payDate;
	@TableField("confirm_date")
	private Date confirmDate;
	@TableField("deliver_date")
	private Date deliverDate;
	@TableField("delivered_date")
	private Date deliveredDate;
	@TableField("deal_date")
	private Date dealDate;
	@TableField("deliver_Order2_number")
	private String deliverOrder2Number;
	private String status;
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
     * �?货款金额
     */
	@TableField("refund_fee")
	private BigDecimal refundFee;
	@TableField("store_address")
	private String storeAddress;
    /**
     * 换货补差价金�?
     */
	@TableField("supplementary_fee")
	private BigDecimal supplementaryFee;
    /**
     * 原价
     */
	@TableField("origin_price")
	private BigDecimal originPrice;
    /**
     * 优惠券价�?
     */
	@TableField("coupon_price")
	private BigDecimal couponPrice;
    /**
     * 积分抵扣价钱
     */
	@TableField("credit_price")
	private BigDecimal creditPrice;


	public Long getId() {
		return id;
	}

	public Order2 setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public Order2 setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public String getOrder2Number() {
		return Order2Number;
	}

	public Order2 setOrder2Number(String Order2Number) {
		this.Order2Number = Order2Number;
		return this;
	}

	public String getTradeNumber() {
		return tradeNumber;
	}

	public Order2 setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
		return this;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public Order2 setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Order2 setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public Date getPayDate() {
		return payDate;
	}

	public Order2 setPayDate(Date payDate) {
		this.payDate = payDate;
		return this;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public Order2 setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
		return this;
	}

	public Date getDeliverDate() {
		return deliverDate;
	}

	public Order2 setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
		return this;
	}

	public Date getDeliveredDate() {
		return deliveredDate;
	}

	public Order2 setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
		return this;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public Order2 setDealDate(Date dealDate) {
		this.dealDate = dealDate;
		return this;
	}

	public String getDeliverOrder2Number() {
		return deliverOrder2Number;
	}

	public Order2 setDeliverOrder2Number(String deliverOrder2Number) {
		this.deliverOrder2Number = deliverOrder2Number;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Order2 setStatus(String status) {
		this.status = status;
		return this;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public Order2 setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public Order2 setFreight(BigDecimal freight) {
		this.freight = freight;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Order2 setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public Order2 setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getInvoice() {
		return invoice;
	}

	public Order2 setInvoice(Integer invoice) {
		this.invoice = invoice;
		return this;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public Order2 setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
		return this;
	}

	public String getReceivingTime() {
		return receivingTime;
	}

	public Order2 setReceivingTime(String receivingTime) {
		this.receivingTime = receivingTime;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public Order2 setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public String getContactUser() {
		return contactUser;
	}

	public Order2 setContactUser(String contactUser) {
		this.contactUser = contactUser;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Order2 setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getProvince() {
		return province;
	}

	public Order2 setProvince(String province) {
		this.province = province;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Order2 setCity(String city) {
		this.city = city;
		return this;
	}

	public String getDistrict() {
		return district;
	}

	public Order2 setDistrict(String district) {
		this.district = district;
		return this;
	}

	public String getStreet() {
		return street;
	}

	public Order2 setStreet(String street) {
		this.street = street;
		return this;
	}

	public String getDetail() {
		return detail;
	}

	public Order2 setDetail(String detail) {
		this.detail = detail;
		return this;
	}

	public String getCover() {
		return cover;
	}

	public Order2 setCover(String cover) {
		this.cover = cover;
		return this;
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public Order2 setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
		return this;
	}

	public String getExpressCompany() {
		return expressCompany;
	}

	public Order2 setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
		return this;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public Order2 setExpressCode(String expressCode) {
		this.expressCode = expressCode;
		return this;
	}

	public Integer getSettled() {
		return settled;
	}

	public Order2 setSettled(Integer settled) {
		this.settled = settled;
		return this;
	}

	public String getPreviousStatus() {
		return previousStatus;
	}

	public Order2 setPreviousStatus(String previousStatus) {
		this.previousStatus = previousStatus;
		return this;
	}

	public Integer getIsDeliverReminder() {
		return isDeliverReminder;
	}

	public Order2 setIsDeliverReminder(Integer isDeliverReminder) {
		this.isDeliverReminder = isDeliverReminder;
		return this;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public Order2 setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}

	public Integer getPointExchangeRate() {
		return pointExchangeRate;
	}

	public Order2 setPointExchangeRate(Integer pointExchangeRate) {
		this.pointExchangeRate = pointExchangeRate;
		return this;
	}

	public String getCouponInfo() {
		return couponInfo;
	}

	public Order2 setCouponInfo(String couponInfo) {
		this.couponInfo = couponInfo;
		return this;
	}

	public String getMarketing() {
		return marketing;
	}

	public Order2 setMarketing(String marketing) {
		this.marketing = marketing;
		return this;
	}

	public Integer getMarketingId() {
		return marketingId;
	}

	public Order2 setMarketingId(Integer marketingId) {
		this.marketingId = marketingId;
		return this;
	}

	public String getMarketingDescription() {
		return marketingDescription;
	}

	public Order2 setMarketingDescription(String marketingDescription) {
		this.marketingDescription = marketingDescription;
		return this;
	}

	public Integer getMid() {
		return mid;
	}

	public Order2 setMid(Integer mid) {
		this.mid = mid;
		return this;
	}

	public String getMname() {
		return mname;
	}

	public Order2 setMname(String mname) {
		this.mname = mname;
		return this;
	}

	public String getStoreId() {
		return storeId;
	}

	public Order2 setStoreId(String storeId) {
		this.storeId = storeId;
		return this;
	}

	public String getStoreName() {
		return storeName;
	}

	public Order2 setStoreName(String storeName) {
		this.storeName = storeName;
		return this;
	}

	public String getStoreUserId() {
		return storeUserId;
	}

	public Order2 setStoreUserId(String storeUserId) {
		this.storeUserId = storeUserId;
		return this;
	}

	public String getStoreUserName() {
		return storeUserName;
	}

	public Order2 setStoreUserName(String storeUserName) {
		this.storeUserName = storeUserName;
		return this;
	}

	public String getType() {
		return type;
	}

	public Order2 setType(String type) {
		this.type = type;
		return this;
	}

	public Integer getPayCredit() {
		return payCredit;
	}

	public Order2 setPayCredit(Integer payCredit) {
		this.payCredit = payCredit;
		return this;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public Order2 setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
		return this;
	}

	public String getOrigin() {
		return origin;
	}

	public Order2 setOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public String getStoreUserCode() {
		return storeUserCode;
	}

	public Order2 setStoreUserCode(String storeUserCode) {
		this.storeUserCode = storeUserCode;
		return this;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public Order2 setStoreCode(String storeCode) {
		this.storeCode = storeCode;
		return this;
	}

	public String getStoreCover() {
		return storeCover;
	}

	public Order2 setStoreCover(String storeCover) {
		this.storeCover = storeCover;
		return this;
	}

	public String getStoreGuideUserId() {
		return storeGuideUserId;
	}

	public Order2 setStoreGuideUserId(String storeGuideUserId) {
		this.storeGuideUserId = storeGuideUserId;
		return this;
	}

	public String getStoreGuideUserCode() {
		return storeGuideUserCode;
	}

	public Order2 setStoreGuideUserCode(String storeGuideUserCode) {
		this.storeGuideUserCode = storeGuideUserCode;
		return this;
	}

	public String getStoreGuideUserName() {
		return storeGuideUserName;
	}

	public Order2 setStoreGuideUserName(String storeGuideUserName) {
		this.storeGuideUserName = storeGuideUserName;
		return this;
	}

	public String getInviterUserId() {
		return inviterUserId;
	}

	public Order2 setInviterUserId(String inviterUserId) {
		this.inviterUserId = inviterUserId;
		return this;
	}

	public String getInviterUserName() {
		return inviterUserName;
	}

	public Order2 setInviterUserName(String inviterUserName) {
		this.inviterUserName = inviterUserName;
		return this;
	}

	public String getFollowedStoreId() {
		return followedStoreId;
	}

	public Order2 setFollowedStoreId(String followedStoreId) {
		this.followedStoreId = followedStoreId;
		return this;
	}

	public String getFollowedStoreCode() {
		return followedStoreCode;
	}

	public Order2 setFollowedStoreCode(String followedStoreCode) {
		this.followedStoreCode = followedStoreCode;
		return this;
	}

	public String getFollowedStoreName() {
		return followedStoreName;
	}

	public Order2 setFollowedStoreName(String followedStoreName) {
		this.followedStoreName = followedStoreName;
		return this;
	}

	public String getFollowedStoreCover() {
		return followedStoreCover;
	}

	public Order2 setFollowedStoreCover(String followedStoreCover) {
		this.followedStoreCover = followedStoreCover;
		return this;
	}

	public String getCommentId() {
		return commentId;
	}

	public Order2 setCommentId(String commentId) {
		this.commentId = commentId;
		return this;
	}

	public String getBindingStoreId() {
		return bindingStoreId;
	}

	public Order2 setBindingStoreId(String bindingStoreId) {
		this.bindingStoreId = bindingStoreId;
		return this;
	}

	public String getBindingStoreCode() {
		return bindingStoreCode;
	}

	public Order2 setBindingStoreCode(String bindingStoreCode) {
		this.bindingStoreCode = bindingStoreCode;
		return this;
	}

	public String getBindingStoreName() {
		return bindingStoreName;
	}

	public Order2 setBindingStoreName(String bindingStoreName) {
		this.bindingStoreName = bindingStoreName;
		return this;
	}

	public String getBindingStoreCover() {
		return bindingStoreCover;
	}

	public Order2 setBindingStoreCover(String bindingStoreCover) {
		this.bindingStoreCover = bindingStoreCover;
		return this;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public Order2 setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
		return this;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public Order2 setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
		return this;
	}

	public BigDecimal getSupplementaryFee() {
		return supplementaryFee;
	}

	public Order2 setSupplementaryFee(BigDecimal supplementaryFee) {
		this.supplementaryFee = supplementaryFee;
		return this;
	}

	public BigDecimal getOriginPrice() {
		return originPrice;
	}

	public Order2 setOriginPrice(BigDecimal originPrice) {
		this.originPrice = originPrice;
		return this;
	}

	public BigDecimal getCouponPrice() {
		return couponPrice;
	}

	public Order2 setCouponPrice(BigDecimal couponPrice) {
		this.couponPrice = couponPrice;
		return this;
	}

	public BigDecimal getCreditPrice() {
		return creditPrice;
	}

	public Order2 setCreditPrice(BigDecimal creditPrice) {
		this.creditPrice = creditPrice;
		return this;
	}

	public static final String ID = "id";

	public static final String USER_ID = "user_id";

	public static final String Order2_NUMBER = "Order2_number";

	public static final String TRADE_NUMBER = "trade_number";

	public static final String PAYMENT_TYPE = "payment_type";

	public static final String CREATED_DATE = "created_date";

	public static final String PAY_DATE = "pay_date";

	public static final String CONFIRM_DATE = "confirm_date";

	public static final String DELIVER_DATE = "deliver_date";

	public static final String DELIVERED_DATE = "delivered_date";

	public static final String DEAL_DATE = "deal_date";

	public static final String DELIVER_Order2_NUMBER = "deliver_Order2_number";

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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Order2{" +
			"id=" + id +
			", userId=" + userId +
			", Order2Number=" + Order2Number +
			", tradeNumber=" + tradeNumber +
			", paymentType=" + paymentType +
			", createdDate=" + createdDate +
			", payDate=" + payDate +
			", confirmDate=" + confirmDate +
			", deliverDate=" + deliverDate +
			", deliveredDate=" + deliveredDate +
			", dealDate=" + dealDate +
			", deliverOrder2Number=" + deliverOrder2Number +
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
			"}";
	}
}
