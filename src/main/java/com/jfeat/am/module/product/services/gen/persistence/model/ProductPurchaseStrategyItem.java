package com.jfeat.am.module.product.services.gen.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-25
 */
@TableName("t_product_purchase_strategy_item")
public class ProductPurchaseStrategyItem extends Model<ProductPurchaseStrategyItem> {

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
	@TableField("strategy_id")
	private Integer strategyId;
	private String name;
	private String operator;
	@TableField("sort_order")
	private Integer sortOrder;
	private String param;


	public Long getId() {
		return id;
	}

	public ProductPurchaseStrategyItem setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getStrategyId() {
		return strategyId;
	}

	public ProductPurchaseStrategyItem setStrategyId(Integer strategyId) {
		this.strategyId = strategyId;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductPurchaseStrategyItem setName(String name) {
		this.name = name;
		return this;
	}

	public String getOperator() {
		return operator;
	}

	public ProductPurchaseStrategyItem setOperator(String operator) {
		this.operator = operator;
		return this;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public ProductPurchaseStrategyItem setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}

	public String getParam() {
		return param;
	}

	public ProductPurchaseStrategyItem setParam(String param) {
		this.param = param;
		return this;
	}

	public static final String ID = "id";

	public static final String STRATEGY_ID = "strategy_id";

	public static final String NAME = "name";

	public static final String OPERATOR = "operator";

	public static final String SORT_ORDER = "sort_order";

	public static final String PARAM = "param";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductPurchaseStrategyItem{" +
			"id=" + id +
			", strategyId=" + strategyId +
			", name=" + name +
			", operator=" + operator +
			", sortOrder=" + sortOrder +
			", param=" + param +
			"}";
	}
}
