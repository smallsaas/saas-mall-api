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
@TableName("t_product_description")
public class ProductDescription extends Model<ProductDescription> {

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
	private Long productId;
	private String description;


	public Long getId() {
		return id;
	}

	public ProductDescription setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getProductId() {
		return productId;
	}

	public ProductDescription setProductId(Long productId) {
		this.productId = productId;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ProductDescription setDescription(String description) {
		this.description = description;
		return this;
	}

	public static final String ID = "id";

	public static final String PRODUCT_ID = "product_id";

	public static final String DESCRIPTION = "description";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductDescription{" +
			"id=" + id +
			", productId=" + productId +
			", description=" + description +
			"}";
	}
}
