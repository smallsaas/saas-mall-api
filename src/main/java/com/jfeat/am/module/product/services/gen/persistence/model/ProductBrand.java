package com.jfeat.am.module.product.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("t_product_brand")
public class ProductBrand extends Model<ProductBrand> {

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
	private String name;
	private String description;
	private String logo;


	public Integer getId() {
		return id;
	}

	public ProductBrand setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductBrand setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ProductBrand setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getLogo() {
		return logo;
	}

	public ProductBrand setLogo(String logo) {
		this.logo = logo;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String DESCRIPTION = "description";

	public static final String LOGO = "logo";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductBrand{" +
			"id=" + id +
			", name=" + name +
			", description=" + description +
			", logo=" + logo +
			"}";
	}
}
