package com.jfeat.am.module.frontproduct.services.domain.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2017-12-22
 */
public class FareTemplatePcd extends Model<FareTemplatePcd> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String type;
	private Long pid;


	public Long getId() {
		return id;
	}

	public FareTemplatePcd setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public FareTemplatePcd setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return type;
	}

	public FareTemplatePcd setType(String type) {
		this.type = type;
		return this;
	}

	public Long getPid() {
		return pid;
	}

	public FareTemplatePcd setPid(Long pid) {
		this.pid = pid;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String TYPE = "type";

	public static final String PID = "pid";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Pcd{" +
			"id=" + id +
			", name=" + name +
			", type=" + type +
			", pid=" + pid +
			"}";
	}
}
