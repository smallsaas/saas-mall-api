package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-25
 */
@TableName("t_product_purchase_strategy_relation")
public class ProductPurchaseStrategyRelation extends Model<ProductPurchaseStrategyRelation> {

    @com.baomidou.mybatisplus.annotations.TableField(exist = false)
    private com.alibaba.fastjson.JSONObject extra;

    public com.alibaba.fastjson.JSONObject getExtra() {
        return extra;
    }
    public void setExtra(com.alibaba.fastjson.JSONObject extra) {
        this.extra = extra;
    }


    private static final long serialVersionUID = 1L;

    @TableId("product_id")
	private Integer productId;
	@TableField("strategy_id")
	private Integer strategyId;


	public Integer getProductId() {
		return productId;
	}

	public ProductPurchaseStrategyRelation setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public Integer getStrategyId() {
		return strategyId;
	}

	public ProductPurchaseStrategyRelation setStrategyId(Integer strategyId) {
		this.strategyId = strategyId;
		return this;
	}

	public static final String PRODUCT_ID = "product_id";

	public static final String STRATEGY_ID = "strategy_id";

	@Override
	protected Serializable pkVal() {
		return this.productId;
	}

	@Override
	public String toString() {
		return "ProductPurchaseStrategyRelation{" +
			"productId=" + productId +
			", strategyId=" + strategyId +
			"}";
	}
}
