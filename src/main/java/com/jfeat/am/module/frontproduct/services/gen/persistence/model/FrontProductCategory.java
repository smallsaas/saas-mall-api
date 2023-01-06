package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

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
 * @since 2019-07-25
 */
@TableName("t_product_category")
public class FrontProductCategory extends Model<FrontProductCategory> {

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
	@TableField("parent_id")
	private Integer parentId;
	private String name;
	private String description;
	private String cover;
	@TableField("sort_order")
	private Integer sortOrder;
	private Integer promoted;
	private Integer visible;
	@TableField("promoted_product_count")
	private Integer promotedProductCount;
	private Integer wholesale;
	@TableField("is_show_products")
	private Integer isShowProducts;
	@TableField("org_id")
	private Long orgId;

	@TableField("code")
	private String code;

	@TableField("category_name")
	private String categoryName;

	@TableField("appid")
	private String appid;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public FrontProductCategory setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getParentId() {
		return parentId;
	}

	public FrontProductCategory setParentId(Integer parentId) {
		this.parentId = parentId;
		return this;
	}

	public String getName() {
		return name;
	}

	public FrontProductCategory setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public FrontProductCategory setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getCover() {
		return cover;
	}

	public FrontProductCategory setCover(String cover) {
		this.cover = cover;
		return this;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public FrontProductCategory setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}

	public Integer getPromoted() {
		return promoted;
	}

	public FrontProductCategory setPromoted(Integer promoted) {
		this.promoted = promoted;
		return this;
	}

	public Integer getVisible() {
		return visible;
	}

	public FrontProductCategory setVisible(Integer visible) {
		this.visible = visible;
		return this;
	}

	public Integer getPromotedProductCount() {
		return promotedProductCount;
	}

	public FrontProductCategory setPromotedProductCount(Integer promotedProductCount) {
		this.promotedProductCount = promotedProductCount;
		return this;
	}

	public Integer getWholesale() {
		return wholesale;
	}

	public FrontProductCategory setWholesale(Integer wholesale) {
		this.wholesale = wholesale;
		return this;
	}

	public Integer getIsShowProducts() {
		return isShowProducts;
	}

	public FrontProductCategory setIsShowProducts(Integer isShowProducts) {
		this.isShowProducts = isShowProducts;
		return this;
	}

	public static final String ID = "id";

	public static final String PARENT_ID = "parent_id";

	public static final String NAME = "name";

	public static final String DESCRIPTION = "description";

	public static final String COVER = "cover";

	public static final String SORT_ORDER = "sort_order";

	public static final String PROMOTED = "promoted";

	public static final String VISIBLE = "visible";

	public static final String PROMOTED_PRODUCT_COUNT = "promoted_product_count";

	public static final String WHOLESALE = "wholesale";

	public static final String IS_SHOW_PRODUCTS = "is_show_products";


	public static final String CATEGORY_NAME = "category_name";

	public static final String APPID ="appid";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "FrontProductCategory{" +
			"id=" + id +
			", parentId=" + parentId +
			", name=" + name +
			", description=" + description +
			", cover=" + cover +
			", sortOrder=" + sortOrder +
			", promoted=" + promoted +
			", visible=" + visible +
			", promotedProductCount=" + promotedProductCount +
			", wholesale=" + wholesale +
			", isShowProducts=" + isShowProducts +
			"}";
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
