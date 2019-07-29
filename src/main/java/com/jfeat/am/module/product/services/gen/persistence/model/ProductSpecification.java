package com.jfeat.am.module.product.services.gen.persistence.model;

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
 * @since 2019-07-25
 */
@TableName("t_product_specification")
public class ProductSpecification extends Model<ProductSpecification> {

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
	@TableField("product_id")
	private Integer productId;
	private String name;
	@TableField("stock_balance")
	private Integer stockBalance;
	private BigDecimal price;
	@TableField("cost_price")
	private BigDecimal costPrice;
	@TableField("suggested_price")
	private BigDecimal suggestedPrice;
	private Integer weight;
	private Integer bulk;
	@TableField("sku_id")
	private String skuId;
	@TableField("sku_name")
	private String skuName;
	@TableField("sku_code")
	private String skuCode;
	@TableField("bar_code")
	private String barCode;


	public Integer getId() {
		return id;
	}

	public ProductSpecification setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getProductId() {
		return productId;
	}

	public ProductSpecification setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductSpecification setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getStockBalance() {
		return stockBalance;
	}

	public ProductSpecification setStockBalance(Integer stockBalance) {
		this.stockBalance = stockBalance;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public ProductSpecification setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public ProductSpecification setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
		return this;
	}

	public BigDecimal getSuggestedPrice() {
		return suggestedPrice;
	}

	public ProductSpecification setSuggestedPrice(BigDecimal suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
		return this;
	}

	public Integer getWeight() {
		return weight;
	}

	public ProductSpecification setWeight(Integer weight) {
		this.weight = weight;
		return this;
	}

	public Integer getBulk() {
		return bulk;
	}

	public ProductSpecification setBulk(Integer bulk) {
		this.bulk = bulk;
		return this;
	}

	public String getSkuId() {
		return skuId;
	}

	public ProductSpecification setSkuId(String skuId) {
		this.skuId = skuId;
		return this;
	}

	public String getSkuName() {
		return skuName;
	}

	public ProductSpecification setSkuName(String skuName) {
		this.skuName = skuName;
		return this;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public ProductSpecification setSkuCode(String skuCode) {
		this.skuCode = skuCode;
		return this;
	}

	public String getBarCode() {
		return barCode;
	}

	public ProductSpecification setBarCode(String barCode) {
		this.barCode = barCode;
		return this;
	}

	public static final String ID = "id";

	public static final String PRODUCT_ID = "product_id";

	public static final String NAME = "name";

	public static final String STOCK_BALANCE = "stock_balance";

	public static final String PRICE = "price";

	public static final String COST_PRICE = "cost_price";

	public static final String SUGGESTED_PRICE = "suggested_price";

	public static final String WEIGHT = "weight";

	public static final String BULK = "bulk";

	public static final String SKU_ID = "sku_id";

	public static final String SKU_NAME = "sku_name";

	public static final String SKU_CODE = "sku_code";

	public static final String BAR_CODE = "bar_code";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductSpecification{" +
			"id=" + id +
			", productId=" + productId +
			", name=" + name +
			", stockBalance=" + stockBalance +
			", price=" + price +
			", costPrice=" + costPrice +
			", suggestedPrice=" + suggestedPrice +
			", weight=" + weight +
			", bulk=" + bulk +
			", skuId=" + skuId +
			", skuName=" + skuName +
			", skuCode=" + skuCode +
			", barCode=" + barCode +
			"}";
	}
}
