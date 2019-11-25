package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

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
@TableName("t_product_tag")
public class FrontProductTag extends Model<FrontProductTag> {

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
	@TableField("sort_num")
	private Integer sortNum;
	@TableField("org_id")
	private Long orgId;
	public Long getId() {
		return id;
	}

	public FrontProductTag setId(Long id) {
		this.id = id;
		return this;
	}

	public String getIdentifier() {
		return identifier;
	}

	public FrontProductTag setIdentifier(String identifier) {
		this.identifier = identifier;
		return this;
	}

	public String getName() {
		return name;
	}

	public FrontProductTag setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public FrontProductTag setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
		return this;
	}

	public static final String ID = "id";

	public static final String IDENTIFIER = "identifier";

	public static final String NAME = "name";

	public static final String SORT_ORDER = "sort_num";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "FrontProductTag{" +
			"id=" + id +
			", identifier=" + identifier +
			", name=" + name +
			", sortNum=" + sortNum +
			"}";
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
