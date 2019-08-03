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
@TableName("t_product_property")
public class ProductProperty extends Model<ProductProperty> {

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
	@TableField("property_id")
	private Integer propertyId;
	@TableField("property_value")
	private String propertyValue;


	public Long getId() {
		return id;
	}

	public ProductProperty setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getProductId() {
		return productId;
	}

	public ProductProperty setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public Integer getPropertyId() {
		return propertyId;
	}

	public ProductProperty setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
		return this;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public ProductProperty setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
		return this;
	}

	public static final String ID = "id";

	public static final String PRODUCT_ID = "product_id";

	public static final String PROPERTY_ID = "property_id";

	public static final String PROPERTY_VALUE = "property_value";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductProperty{" +
			"id=" + id +
			", productId=" + productId +
			", propertyId=" + propertyId +
			", propertyValue=" + propertyValue +
			"}";
	}
}
