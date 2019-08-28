package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("t_product_settlement_proportion")
public class ProductSettlementProportion extends Model<ProductSettlementProportion> {

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
	@TableField("product_id")
	private Integer productId;
	private String name;
	private String type;
	private String proportion;
	private Integer level;


	public Long getId() {
		return id;
	}

	public ProductSettlementProportion setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getProductId() {
		return productId;
	}

	public ProductSettlementProportion setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductSettlementProportion setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return type;
	}

	public ProductSettlementProportion setType(String type) {
		this.type = type;
		return this;
	}

	public String getProportion() {
		return proportion;
	}

	public ProductSettlementProportion setProportion(String proportion) {
		this.proportion = proportion;
		return this;
	}

	public Integer getLevel() {
		return level;
	}

	public ProductSettlementProportion setLevel(Integer level) {
		this.level = level;
		return this;
	}

	public static final String ID = "id";

	public static final String PRODUCT_ID = "product_id";

	public static final String NAME = "name";

	public static final String TYPE = "type";

	public static final String PROPORTION = "proportion";

	public static final String LEVEL = "level";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductSettlementProportion{" +
			"id=" + id +
			", productId=" + productId +
			", name=" + name +
			", type=" + type +
			", proportion=" + proportion +
			", level=" + level +
			"}";
	}
}
