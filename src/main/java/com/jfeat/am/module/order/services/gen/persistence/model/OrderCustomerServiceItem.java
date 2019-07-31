package com.jfeat.am.module.order.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
@TableName("t_order_customer_service_item")
public class OrderCustomerServiceItem extends Model<OrderCustomerServiceItem> {

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
    /**
     * 售后单id
     */
	@TableField("order_customer_service_id")
	private Integer orderCustomerServiceId;
    /**
     * 退款金额(仅退回项使用)
     */
	@TableField("refund_fee")
	private BigDecimal refundFee;
    /**
     * 项类型(RETURN 退回项 EXCHANGE 置换项)
     */
	private String type;
    /**
     * 产品id
     */
	@TableField("product_id")
	private Integer productId;
    /**
     * 产品名称
     */
	@TableField("product_name")
	private String productName;
    /**
     * 退回项：退回数量/件 置换项：置换数量/件
     */
	private Integer quantity;
    /**
     * 单价
     */
	private BigDecimal price;
    /**
     * 退回项：原支付金额 置换项：置换项金额
     */
	@TableField("final_price")
	private BigDecimal finalPrice;
    /**
     * 成本价
     */
	@TableField("cost_price")
	private BigDecimal costPrice;
    /**
     * 产品封面
     */
	private String cover;
    /**
     * 产品规格名
     */
	@TableField("product_specification_name")
	private String productSpecificationName;
    /**
     * 产品规格id
     */
	@TableField("product_specification_id")
	private Integer productSpecificationId;
    /**
     * 重量
     */
	private Integer weight;
    /**
     * 营销活动记录
     */
	private String marketing;
    /**
     * 营销活动id
     */
	@TableField("marketing_id")
	private Integer marketingId;
    /**
     * 营销活动描述
     */
	@TableField("marketing_description")
	private String marketingDescription;


	public Integer getId() {
		return id;
	}

	public OrderCustomerServiceItem setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOrderCustomerServiceId() {
		return orderCustomerServiceId;
	}

	public OrderCustomerServiceItem setOrderCustomerServiceId(Integer orderCustomerServiceId) {
		this.orderCustomerServiceId = orderCustomerServiceId;
		return this;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public OrderCustomerServiceItem setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
		return this;
	}

	public String getType() {
		return type;
	}

	public OrderCustomerServiceItem setType(String type) {
		this.type = type;
		return this;
	}

	public Integer getProductId() {
		return productId;
	}

	public OrderCustomerServiceItem setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public String getProductName() {
		return productName;
	}

	public OrderCustomerServiceItem setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public OrderCustomerServiceItem setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public OrderCustomerServiceItem setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public OrderCustomerServiceItem setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
		return this;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public OrderCustomerServiceItem setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
		return this;
	}

	public String getCover() {
		return cover;
	}

	public OrderCustomerServiceItem setCover(String cover) {
		this.cover = cover;
		return this;
	}

	public String getProductSpecificationName() {
		return productSpecificationName;
	}

	public OrderCustomerServiceItem setProductSpecificationName(String productSpecificationName) {
		this.productSpecificationName = productSpecificationName;
		return this;
	}

	public Integer getProductSpecificationId() {
		return productSpecificationId;
	}

	public OrderCustomerServiceItem setProductSpecificationId(Integer productSpecificationId) {
		this.productSpecificationId = productSpecificationId;
		return this;
	}

	public Integer getWeight() {
		return weight;
	}

	public OrderCustomerServiceItem setWeight(Integer weight) {
		this.weight = weight;
		return this;
	}

	public String getMarketing() {
		return marketing;
	}

	public OrderCustomerServiceItem setMarketing(String marketing) {
		this.marketing = marketing;
		return this;
	}

	public Integer getMarketingId() {
		return marketingId;
	}

	public OrderCustomerServiceItem setMarketingId(Integer marketingId) {
		this.marketingId = marketingId;
		return this;
	}

	public String getMarketingDescription() {
		return marketingDescription;
	}

	public OrderCustomerServiceItem setMarketingDescription(String marketingDescription) {
		this.marketingDescription = marketingDescription;
		return this;
	}

	public static final String ID = "id";

	public static final String ORDER_CUSTOMER_SERVICE_ID = "order_customer_service_id";

	public static final String REFUND_FEE = "refund_fee";

	public static final String TYPE = "type";

	public static final String PRODUCT_ID = "product_id";

	public static final String PRODUCT_NAME = "product_name";

	public static final String QUANTITY = "quantity";

	public static final String PRICE = "price";

	public static final String FINAL_PRICE = "final_price";

	public static final String COST_PRICE = "cost_price";

	public static final String COVER = "cover";

	public static final String PRODUCT_SPECIFICATION_NAME = "product_specification_name";

	public static final String PRODUCT_SPECIFICATION_ID = "product_specification_id";

	public static final String WEIGHT = "weight";

	public static final String MARKETING = "marketing";

	public static final String MARKETING_ID = "marketing_id";

	public static final String MARKETING_DESCRIPTION = "marketing_description";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "OrderCustomerServiceItem{" +
			"id=" + id +
			", orderCustomerServiceId=" + orderCustomerServiceId +
			", refundFee=" + refundFee +
			", type=" + type +
			", productId=" + productId +
			", productName=" + productName +
			", quantity=" + quantity +
			", price=" + price +
			", finalPrice=" + finalPrice +
			", costPrice=" + costPrice +
			", cover=" + cover +
			", productSpecificationName=" + productSpecificationName +
			", productSpecificationId=" + productSpecificationId +
			", weight=" + weight +
			", marketing=" + marketing +
			", marketingId=" + marketingId +
			", marketingDescription=" + marketingDescription +
			"}";
	}
}
