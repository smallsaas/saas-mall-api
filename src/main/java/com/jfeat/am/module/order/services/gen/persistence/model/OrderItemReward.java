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
@TableName("t_order_item_reward")
public class OrderItemReward extends Model<OrderItemReward> {

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
	@TableField("order_id")
	private Integer orderId;
	@TableField("order_number")
	private String orderNumber;
	@TableField("order_total_price")
	private BigDecimal orderTotalPrice;
	@TableField("order_created_time")
	private Date orderCreatedTime;
	@TableField("order_paid_time")
	private Date orderPaidTime;
	@TableField("order_item_id")
	private Integer orderItemId;
	@TableField("order_profit")
	private BigDecimal orderProfit;
	private Integer percent;
	private BigDecimal reward;
	@TableField("owner_id")
	private Integer ownerId;
	private Integer level;
	private String state;
	private String type;
	@TableField("created_time")
	private Date createdTime;
	@TableField("settled_time")
	private Date settledTime;
	@TableField("withdrawn_time")
	private Date withdrawnTime;
	@TableField("order_user_name")
	private String orderUserName;
	@TableField("payment_type")
	private String paymentType;
	@TableField("point_exchange_rate")
	private Integer pointExchangeRate;


	public Long getId() {
		return id;
	}

	public OrderItemReward setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public OrderItemReward setOrderId(Integer orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public OrderItemReward setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public BigDecimal getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public OrderItemReward setOrderTotalPrice(BigDecimal orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
		return this;
	}

	public Date getOrderCreatedTime() {
		return orderCreatedTime;
	}

	public OrderItemReward setOrderCreatedTime(Date orderCreatedTime) {
		this.orderCreatedTime = orderCreatedTime;
		return this;
	}

	public Date getOrderPaidTime() {
		return orderPaidTime;
	}

	public OrderItemReward setOrderPaidTime(Date orderPaidTime) {
		this.orderPaidTime = orderPaidTime;
		return this;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public OrderItemReward setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
		return this;
	}

	public BigDecimal getOrderProfit() {
		return orderProfit;
	}

	public OrderItemReward setOrderProfit(BigDecimal orderProfit) {
		this.orderProfit = orderProfit;
		return this;
	}

	public Integer getPercent() {
		return percent;
	}

	public OrderItemReward setPercent(Integer percent) {
		this.percent = percent;
		return this;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public OrderItemReward setReward(BigDecimal reward) {
		this.reward = reward;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public OrderItemReward setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Integer getLevel() {
		return level;
	}

	public OrderItemReward setLevel(Integer level) {
		this.level = level;
		return this;
	}

	public String getState() {
		return state;
	}

	public OrderItemReward setState(String state) {
		this.state = state;
		return this;
	}

	public String getType() {
		return type;
	}

	public OrderItemReward setType(String type) {
		this.type = type;
		return this;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public OrderItemReward setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
		return this;
	}

	public Date getSettledTime() {
		return settledTime;
	}

	public OrderItemReward setSettledTime(Date settledTime) {
		this.settledTime = settledTime;
		return this;
	}

	public Date getWithdrawnTime() {
		return withdrawnTime;
	}

	public OrderItemReward setWithdrawnTime(Date withdrawnTime) {
		this.withdrawnTime = withdrawnTime;
		return this;
	}

	public String getOrderUserName() {
		return orderUserName;
	}

	public OrderItemReward setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
		return this;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public OrderItemReward setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public Integer getPointExchangeRate() {
		return pointExchangeRate;
	}

	public OrderItemReward setPointExchangeRate(Integer pointExchangeRate) {
		this.pointExchangeRate = pointExchangeRate;
		return this;
	}

	public static final String ID = "id";

	public static final String ORDER_ID = "order_id";

	public static final String ORDER_NUMBER = "order_number";

	public static final String ORDER_TOTAL_PRICE = "order_total_price";

	public static final String ORDER_CREATED_TIME = "order_created_time";

	public static final String ORDER_PAID_TIME = "order_paid_time";

	public static final String ORDER_ITEM_ID = "order_item_id";

	public static final String ORDER_PROFIT = "order_profit";

	public static final String PERCENT = "percent";

	public static final String REWARD = "reward";

	public static final String OWNER_ID = "owner_id";

	public static final String LEVEL = "level";

	public static final String STATE = "state";

	public static final String TYPE = "type";

	public static final String CREATED_TIME = "created_time";

	public static final String SETTLED_TIME = "settled_time";

	public static final String WITHDRAWN_TIME = "withdrawn_time";

	public static final String ORDER_USER_NAME = "order_user_name";

	public static final String PAYMENT_TYPE = "payment_type";

	public static final String POINT_EXCHANGE_RATE = "point_exchange_rate";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "OrderItemReward{" +
			"id=" + id +
			", orderId=" + orderId +
			", orderNumber=" + orderNumber +
			", orderTotalPrice=" + orderTotalPrice +
			", orderCreatedTime=" + orderCreatedTime +
			", orderPaidTime=" + orderPaidTime +
			", orderItemId=" + orderItemId +
			", orderProfit=" + orderProfit +
			", percent=" + percent +
			", reward=" + reward +
			", ownerId=" + ownerId +
			", level=" + level +
			", state=" + state +
			", type=" + type +
			", createdTime=" + createdTime +
			", settledTime=" + settledTime +
			", withdrawnTime=" + withdrawnTime +
			", orderUserName=" + orderUserName +
			", paymentType=" + paymentType +
			", pointExchangeRate=" + pointExchangeRate +
			"}";
	}
}
