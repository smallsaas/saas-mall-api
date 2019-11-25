package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

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
 * @since 2019-07-25
 */
@TableName("t_product_category_property")
public class ProductCategoryProperty extends Model<ProductCategoryProperty> {

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
	@TableField("category_id")
	private Long categoryId;
	@TableField("display_name")
	private String displayName;
	@TableField("value_type")
	private String valueType;
	@TableField("input_type")
	private String inputType;
	@TableField("candidate_values")
	private String candidateValues;
	@TableField("default_value")
	private String defaultValue;
	@TableField("is_required")
	private Integer isRequired;
	@TableField("sort_num")
	private Integer sortNum;


	public Long getId() {
		return id;
	}

	public ProductCategoryProperty setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public ProductCategoryProperty setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
		return this;
	}

	public String getDisplayName() {
		return displayName;
	}

	public ProductCategoryProperty setDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

	public String getValueType() {
		return valueType;
	}

	public ProductCategoryProperty setValueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	public String getInputType() {
		return inputType;
	}

	public ProductCategoryProperty setInputType(String inputType) {
		this.inputType = inputType;
		return this;
	}

	public String getCandidateValues() {
		return candidateValues;
	}

	public ProductCategoryProperty setCandidateValues(String candidateValues) {
		this.candidateValues = candidateValues;
		return this;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public ProductCategoryProperty setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public Integer getIsRequired() {
		return isRequired;
	}

	public ProductCategoryProperty setIsRequired(Integer isRequired) {
		this.isRequired = isRequired;
		return this;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public ProductCategoryProperty setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
		return this;
	}

	public static final String ID = "id";

	public static final String CATEGORY_ID = "category_id";

	public static final String DISPLAY_NAME = "display_name";

	public static final String VALUE_TYPE = "value_type";

	public static final String INPUT_TYPE = "input_type";

	public static final String CANDIDATE_VALUES = "candidate_values";

	public static final String DEFAULT_VALUE = "default_value";

	public static final String IS_REQUIRED = "is_required";

	public static final String SORT_ORDER = "sort_num";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductCategoryProperty{" +
			"id=" + id +
			", categoryId=" + categoryId +
			", displayName=" + displayName +
			", valueType=" + valueType +
			", inputType=" + inputType +
			", candidateValues=" + candidateValues +
			", defaultValue=" + defaultValue +
			", isRequired=" + isRequired +
			", sortNum=" + sortNum +
			"}";
	}
}
