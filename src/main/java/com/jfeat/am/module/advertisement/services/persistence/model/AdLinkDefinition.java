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
@TableName("t_ad_link_definition")
public class AdLinkDefinition extends Model<AdLinkDefinition> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private Integer type;
	private String name;
	private String url;
	@TableField("org_id")
	private Long orgId;

	public Long getId() {
		return id;
	}

	public AdLinkDefinition setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public AdLinkDefinition setType(Integer type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public AdLinkDefinition setName(String name) {
		this.name = name;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public AdLinkDefinition setUrl(String url) {
		this.url = url;
		return this;
	}

	public static final String ID = "id";

	public static final String TYPE = "type";

	public static final String NAME = "name";

	public static final String URL = "url";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "AdLinkDefinition{" +
			"id=" + id +
			", type=" + type +
			", name=" + name +
			", url=" + url +
			"}";
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
