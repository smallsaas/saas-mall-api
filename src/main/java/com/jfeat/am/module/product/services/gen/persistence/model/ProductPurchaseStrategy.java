package com.jfeat.am.module.product.services.gen.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
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
@TableName("t_product_purchase_strategy")
public class ProductPurchaseStrategy extends Model<ProductPurchaseStrategy> {

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
	private String name;
	private String description;


	public Long getId() {
		return id;
	}

	public ProductPurchaseStrategy setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductPurchaseStrategy setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ProductPurchaseStrategy setDescription(String description) {
		this.description = description;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String DESCRIPTION = "description";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductPurchaseStrategy{" +
			"id=" + id +
			", name=" + name +
			", description=" + description +
			"}";
	}
}
