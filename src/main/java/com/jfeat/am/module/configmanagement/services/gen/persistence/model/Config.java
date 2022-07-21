package com.jfeat.am.module.configmanagement.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-08-13
 */
@TableName("t_config")
public class Config extends Model<Config> {

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
	private Integer id;
	@TableField("user_id")
	private Integer userId;
	@TableField("group_id")
	private Integer groupId;
	private String name;
	@TableField("key_name")
	private String keyName;
	@TableField("value_type")
	private String valueType;
	private String value;
	private String type;
	private Integer visible;
	private String description;
	private Integer readonly;
    /**
     * 组织(部门)ID
     */
	@TableField("org_id")
	private Long orgId;

	private Long appid;

	public Long getAppid() {
		return appid;
	}

	public void setAppid(Long appid) {
		this.appid = appid;
	}

	public Integer getId() {
		return id;
	}

	public Config setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public Config setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public Config setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	public String getName() {
		return name;
	}

	public Config setName(String name) {
		this.name = name;
		return this;
	}

	public String getKeyName() {
		return keyName;
	}

	public Config setKeyName(String keyName) {
		this.keyName = keyName;
		return this;
	}

	public String getValueType() {
		return valueType;
	}

	public Config setValueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	public String getValue() {
		return value;
	}

	public Config setValue(String value) {
		this.value = value;
		return this;
	}

	public String getType() {
		return type;
	}

	public Config setType(String type) {
		this.type = type;
		return this;
	}

	public Integer getVisible() {
		return visible;
	}

	public Config setVisible(Integer visible) {
		this.visible = visible;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Config setDescription(String description) {
		this.description = description;
		return this;
	}

	public Integer getReadonly() {
		return readonly;
	}

	public Config setReadonly(Integer readonly) {
		this.readonly = readonly;
		return this;
	}

	public Long getOrgId() {
		return orgId;
	}

	public Config setOrgId(Long orgId) {
		this.orgId = orgId;
		return this;
	}

	public static final String ID = "id";

	public static final String USER_ID = "user_id";

	public static final String GROUP_ID = "group_id";

	public static final String NAME = "name";

	public static final String KEY_NAME = "key_name";

	public static final String VALUE_TYPE = "value_type";

	public static final String VALUE = "value";

	public static final String TYPE = "type";

	public static final String VISIBLE = "visible";

	public static final String DESCRIPTION = "description";

	public static final String READONLY = "readonly";

	public static final String ORG_ID = "org_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Config{" +
			"id=" + id +
			", userId=" + userId +
			", groupId=" + groupId +
			", name=" + name +
			", keyName=" + keyName +
			", valueType=" + valueType +
			", value=" + value +
			", type=" + type +
			", visible=" + visible +
			", description=" + description +
			", readonly=" + readonly +
			", orgId=" + orgId +
			"}";
	}
}
