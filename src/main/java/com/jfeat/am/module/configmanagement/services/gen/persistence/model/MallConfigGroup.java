package com.jfeat.am.module.configmanagement.services.gen.persistence.model;

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
 * @since 2019-08-13
 */
@TableName("t_config_group")
public class MallConfigGroup extends Model<MallConfigGroup> {

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
	@TableField("protected")
	private Integer protecte;
    /**
     * 组织(部门)ID
     */
	@TableField("org_id")
	private Long orgId;


	public Integer getId() {
		return id;
	}

	public MallConfigGroup setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public MallConfigGroup setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getProtected() {
		return protecte;
	}

	public MallConfigGroup setProtected(Integer protecte) {
		this.protecte = protecte;
		return this;
	}

	public Long getOrgId() {
		return orgId;
	}

	public MallConfigGroup setOrgId(Long orgId) {
		this.orgId = orgId;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String PROTECTED = "protected";

	public static final String ORG_ID = "org_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ConfigGroup{" +
			"id=" + id +
			", name=" + name +
			", protected=" + protecte +
			", orgId=" + orgId +
			"}";
	}
}
