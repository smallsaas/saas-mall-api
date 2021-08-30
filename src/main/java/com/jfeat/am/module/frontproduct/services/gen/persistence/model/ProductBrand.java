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
@TableName("t_product_brand")
public class ProductBrand extends Model<ProductBrand> {

    @com.baomidou.mybatisplus.annotation.TableField(exist = false)
    private com.alibaba.fastjson.JSONObject extra;

    public com.alibaba.fastjson.JSONObject getExtra() {
        return extra;
    }
    public void setExtra(com.alibaba.fastjson.JSONObject extra) {
        this.extra = extra;
    }


    private static final long serialVersionUID = 1L;
	@TableField("org_id")
	private Long orgId;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private String name;
	private String description;
	private String logo;


	public Long getId() {
		return id;
	}

	public ProductBrand setId(Long id) {
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
