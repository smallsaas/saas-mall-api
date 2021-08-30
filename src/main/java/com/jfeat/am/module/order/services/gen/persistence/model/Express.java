package com.jfeat.am.module.order.services.gen.persistence.model;

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
 * @since 2019-08-01
 */
@TableName("t_express")
public class Express extends Model<Express> {

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
	private String code;
	private String name;
	private Integer enabled;
	@TableField("is_default")
	private Integer isDefault;
	@TableField("org_id")
	private Long orgId;

	public Long getId() {
		return id;
	}

	public Express setId(Long id) {
		this.id = id;
		return this;
	}

	public String getCode() {
		return code;
	}

	public Express setCode(String code) {
		this.code = code;
		return this;
	}

	public String getName() {
		return name;
	}

	public Express setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public Express setEnabled(Integer enabled) {
		this.enabled = enabled;
		return this;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public Express setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
		return this;
	}

	public static final String ID = "id";

	public static final String CODE = "code";

	public static final String NAME = "name";

	public static final String ENABLED = "enabled";

	public static final String IS_DEFAULT = "is_default";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Express{" +
			"id=" + id +
			", code=" + code +
			", name=" + name +
			", enabled=" + enabled +
			", isDefault=" + isDefault +
			"}";
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
