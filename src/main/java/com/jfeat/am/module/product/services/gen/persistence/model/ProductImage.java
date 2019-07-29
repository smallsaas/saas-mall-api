package com.jfeat.am.module.product.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("t_product_image")
public class ProductImage extends Model<ProductImage> {

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
	private Integer type;
	private String url;
	@TableField("sort_order")
	private Integer sortOrder;


	public Integer getId() {
		return id;
	}

	public ProductImage setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getProductId() {
		return productId;
	}

	public ProductImage setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public ProductImage setType(Integer type) {
		this.type = type;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public ProductImage setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public ProductImage setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}

	public static final String ID = "id";

	public static final String PRODUCT_ID = "product_id";

	public static final String TYPE = "type";

	public static final String URL = "url";

	public static final String SORT_ORDER = "sort_order";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductImage{" +
			"id=" + id +
			", productId=" + productId +
			", type=" + type +
			", url=" + url +
			", sortOrder=" + sortOrder +
			"}";
	}
}
