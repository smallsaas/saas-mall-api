package com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model;

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
 * @since 2019-08-21
 */
@TableName("t_wechat_message_type_prop")
public class WechatMessageTypeProp extends Model<WechatMessageTypeProp> {

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
	@TableField("message_id")
	private Integer messageId;
	private String name;
	@TableField("display_attr")
	private String displayAttr;
	@TableField("display_value")
	private String displayValue;


	public Integer getId() {
		return id;
	}

	public WechatMessageTypeProp setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public WechatMessageTypeProp setMessageId(Integer messageId) {
		this.messageId = messageId;
		return this;
	}

	public String getName() {
		return name;
	}

	public WechatMessageTypeProp setName(String name) {
		this.name = name;
		return this;
	}

	public String getDisplayAttr() {
		return displayAttr;
	}

	public WechatMessageTypeProp setDisplayAttr(String displayAttr) {
		this.displayAttr = displayAttr;
		return this;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public WechatMessageTypeProp setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
		return this;
	}

	public static final String ID = "id";

	public static final String MESSAGE_ID = "message_id";

	public static final String NAME = "name";

	public static final String DISPLAY_ATTR = "display_attr";

	public static final String DISPLAY_VALUE = "display_value";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "WechatMessageTypeProp{" +
			"id=" + id +
			", messageId=" + messageId +
			", name=" + name +
			", displayAttr=" + displayAttr +
			", displayValue=" + displayValue +
			"}";
	}
}
