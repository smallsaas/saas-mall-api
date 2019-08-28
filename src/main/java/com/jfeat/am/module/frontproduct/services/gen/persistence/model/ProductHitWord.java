package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
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
@TableName("t_product_hit_word")
public class ProductHitWord extends Model<ProductHitWord> {

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
	private String name;
	private Integer hit;


	public Long getId() {
		return id;
	}

	public ProductHitWord setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductHitWord setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getHit() {
		return hit;
	}

	public ProductHitWord setHit(Integer hit) {
		this.hit = hit;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String HIT = "hit";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductHitWord{" +
			"id=" + id +
			", name=" + name +
			", hit=" + hit +
			"}";
	}
}
