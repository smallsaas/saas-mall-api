package com.jfeat.am.module.product.services.gen.persistence.model;

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
 * @since 2019-08-02
 */
@TableName("t_trial_image")
public class TrialImage extends Model<TrialImage> {

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
	@TableField("trial_id")
	private Integer trialId;
	private String url;
	@TableField("sort_order")
	private Integer sortOrder;


	public Long getId() {
		return id;
	}

	public TrialImage setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getTrialId() {
		return trialId;
	}

	public TrialImage setTrialId(Integer trialId) {
		this.trialId = trialId;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public TrialImage setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public TrialImage setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}

	public static final String ID = "id";

	public static final String TRIAL_ID = "trial_id";

	public static final String URL = "url";

	public static final String SORT_ORDER = "sort_order";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "TrialImage{" +
			"id=" + id +
			", trialId=" + trialId +
			", url=" + url +
			", sortOrder=" + sortOrder +
			"}";
	}
}
