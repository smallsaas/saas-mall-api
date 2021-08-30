package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-25
 */
@TableName("t_product_tag_relation")
public class FrontProductTagRelation extends Model<FrontProductTagRelation> {

    @com.baomidou.mybatisplus.annotation.TableField(exist = false)
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
	@TableField("tag_id")
	private Long tagId;
	@TableField("product_id")
	private Long productId;


	public Long getId() {
		return id;
	}

	public FrontProductTagRelation setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getTagId() {
		return tagId;
	}

	public FrontProductTagRelation setTagId(Long tagId) {
		this.tagId = tagId;
		return this;
	}

	public Long getProductId() {
		return productId;
	}

	public FrontProductTagRelation setProductId(Long productId) {
		this.productId = productId;
		return this;
	}

	public static final String ID = "id";

	public static final String TAG_ID = "tag_id";

	public static final String PRODUCT_ID = "product_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "FrontProductTagRelation{" +
			"id=" + id +
			", tagId=" + tagId +
			", productId=" + productId +
			"}";
	}
}
