package com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model;

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
 * @since 2019-08-21
 */
@TableName("t_wechat_template_message")
public class WechatTemplateMessage extends Model<WechatTemplateMessage> {

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
	@TableField("template_id")
	private String templateId;
	private String type;
	private String name;
	private Integer enabled;
    /**
     * 组织(部门)ID
     */
	@TableField("org_id")
	private Long orgId;


	public Integer getId() {
		return id;
	}

	public WechatTemplateMessage setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getTemplateId() {
		return templateId;
	}

	public WechatTemplateMessage setTemplateId(String templateId) {
		this.templateId = templateId;
		return this;
	}

	public String getType() {
		return type;
	}

	public WechatTemplateMessage setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public WechatTemplateMessage setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public WechatTemplateMessage setEnabled(Integer enabled) {
		this.enabled = enabled;
		return this;
	}

	public Long getOrgId() {
		return orgId;
	}

	public WechatTemplateMessage setOrgId(Long orgId) {
		this.orgId = orgId;
		return this;
	}

	public static final String ID = "id";

	public static final String TEMPLATE_ID = "template_id";

	public static final String TYPE = "type";

	public static final String NAME = "name";

	public static final String ENABLED = "enabled";

	public static final String ORG_ID = "org_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "WechatTemplateMessage{" +
			"id=" + id +
			", templateId=" + templateId +
			", type=" + type +
			", name=" + name +
			", enabled=" + enabled +
			", orgId=" + orgId +
			"}";
	}
}
