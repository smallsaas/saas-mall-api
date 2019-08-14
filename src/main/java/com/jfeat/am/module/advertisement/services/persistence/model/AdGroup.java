package com.jfeat.am.module.advertisement.services.persistence.model;

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
 * @since 2017-11-08
 */
@TableName("t_ad_group")
public class AdGroup extends Model<AdGroup> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private String name;
	@TableField("org_id")
	private Long orgId;

	public Long getId() {
		return id;
	}

	public AdGroup setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public AdGroup setName(String name) {
		this.name = name;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String IDENTIFIER = "identifier";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "AdGroup{" +
			"id=" + id +
			", name=" + name +
			"}";
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
