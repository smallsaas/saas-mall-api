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
@TableName("t_ad")
public class Ad extends Model<Ad> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("group_id")
	private Long groupId;
	private String name;
	private String image;
	private Integer enabled;
	@TableField("target_url")
	private String targetUrl;
	private String strategy;
	@TableField("org_id")
	private Long orgId;

	public Long getId() {
		return id;
	}

	public Ad setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getGroupId() {
		return groupId;
	}

	public Ad setGroupId(Long groupId) {
		this.groupId = groupId;
		return this;
	}

	public String getName() {
		return name;
	}

	public Ad setName(String name) {
		this.name = name;
		return this;
	}

	public String getImage() {
		return image;
	}

	public Ad setImage(String image) {
		this.image = image;
		return this;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public Ad setEnabled(Integer enabled) {
		this.enabled = enabled;
		return this;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public Ad setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
		return this;
	}

	public static final String ID = "id";

	public static final String GROUP_ID = "group_id";

	public static final String NAME = "name";

	public static final String IMAGE = "image";

	public static final String ENABLED = "enabled";

	public static final String TARGET_URL = "target_url";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Ad{" +
			"id=" + id +
			", groupId=" + groupId +
			", name=" + name +
			", image=" + image +
			", enabled=" + enabled +
			", targetUrl=" + targetUrl +
			"}";
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
}
