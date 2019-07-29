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
@TableName("t_product_tag")
public class ProductTag extends Model<ProductTag> {

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
    /**
     * 标签标识
     */
	private String identifier;
    /**
     * 标签名称
     */
	private String name;
    /**
     * 排序号
     */
	@TableField("sort_order")
	private Integer sortOrder;


	public Integer getId() {
		return id;
	}

	public ProductTag setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getIdentifier() {
		return identifier;
	}

	public ProductTag setIdentifier(String identifier) {
		this.identifier = identifier;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductTag setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public ProductTag setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}

	public static final String ID = "id";

	public static final String IDENTIFIER = "identifier";

	public static final String NAME = "name";

	public static final String SORT_ORDER = "sort_order";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductTag{" +
			"id=" + id +
			", identifier=" + identifier +
			", name=" + name +
			", sortOrder=" + sortOrder +
			"}";
	}
}
