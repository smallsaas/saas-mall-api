package com.jfeat.am.module.store.services.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
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
 * @since 2018-07-10
 */
@TableName("t_store_assistant_relation")
public class StoreAssistantRelation extends Model<StoreAssistantRelation> {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 店铺Id
     */
	@TableField("store_id")
	private Long storeId;
    /**
     * 店员Id
     */
	@TableField("assistant_id")
	private Long assistantId;
    /**
     * 是否是店长
     */
	@TableField("is_shopkeeper")
	private Integer isShopkeeper;


	public Long getId() {
		return id;
	}

	public StoreAssistantRelation setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getStoreId() {
		return storeId;
	}

	public StoreAssistantRelation setStoreId(Long storeId) {
		this.storeId = storeId;
		return this;
	}

	public Long getAssistantId() {
		return assistantId;
	}

	public StoreAssistantRelation setAssistantId(Long assistantId) {
		this.assistantId = assistantId;
		return this;
	}

	public Integer getIsShopkeeper() {
		return isShopkeeper;
	}

	public StoreAssistantRelation setIsShopkeeper(Integer isShopkeeper) {
		this.isShopkeeper = isShopkeeper;
		return this;
	}

	public static final String ID = "id";

	public static final String STORE_ID = "store_id";

	public static final String ASSISTANT_ID = "assistant_id";

	public static final String IS_SHOPKEEPER = "is_shopkeeper";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StoreAssistantRelation{" +
			"id=" + id +
			", storeId=" + storeId +
			", assistantId=" + assistantId +
			", isShopkeeper=" + isShopkeeper +
			"}";
	}
}
