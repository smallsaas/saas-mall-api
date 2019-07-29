package com.jfeat.am.module.product.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
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
 * @since 2019-07-25
 */
@TableName("t_product_favorite")
public class ProductFavorite extends Model<ProductFavorite> {

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
	@TableField("user_id")
	private Integer userId;
	@TableField("product_id")
	private Integer productId;
	@TableField("collect_date")
	private Date collectDate;


	public Integer getId() {
		return id;
	}

	public ProductFavorite setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public ProductFavorite setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getProductId() {
		return productId;
	}

	public ProductFavorite setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public Date getCollectDate() {
		return collectDate;
	}

	public ProductFavorite setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
		return this;
	}

	public static final String ID = "id";

	public static final String USER_ID = "user_id";

	public static final String PRODUCT_ID = "product_id";

	public static final String COLLECT_DATE = "collect_date";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductFavorite{" +
			"id=" + id +
			", userId=" + userId +
			", productId=" + productId +
			", collectDate=" + collectDate +
			"}";
	}
}
