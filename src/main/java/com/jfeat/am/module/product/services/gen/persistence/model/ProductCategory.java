package com.jfeat.am.module.product.services.gen.persistence.model;

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
 * @since 2019-07-25
 */
@TableName("t_product_category")
public class ProductCategory extends Model<ProductCategory> {

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


	public Integer getId() {
		return id;
	}

	public ProductCategory setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getParentId() {
		return parentId;
	}

	public ProductCategory setParentId(Integer parentId) {
		this.parentId = parentId;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductCategory setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ProductCategory setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getCover() {
		return cover;
	}

	public ProductCategory setCover(String cover) {
		this.cover = cover;
		return this;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public ProductCategory setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}

	public Integer getPromoted() {
		return promoted;
	}

	public ProductCategory setPromoted(Integer promoted) {
		this.promoted = promoted;
		return this;
	}

	public Integer getVisible() {
		return visible;
	}

	public ProductCategory setVisible(Integer visible) {
		this.visible = visible;
		return this;
	}

	public Integer getPromotedProductCount() {
		return promotedProductCount;
	}

	public ProductCategory setPromotedProductCount(Integer promotedProductCount) {
		this.promotedProductCount = promotedProductCount;
		return this;
	}

	public Integer getWholesale() {
		return wholesale;
	}

	public ProductCategory setWholesale(Integer wholesale) {
		this.wholesale = wholesale;
		return this;
	}

	public Integer getIsShowProducts() {
		return isShowProducts;
	}

	public ProductCategory setIsShowProducts(Integer isShowProducts) {
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductCategory{" +
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
}
