package com.jfeat.am.module.alliance.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
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
 * @since 2019-10-12
 */
@TableName("t_alliance")
public class Alliance extends Model<Alliance> {

    @com.baomidou.mybatisplus.annotations.TableField(exist = false)
    private com.alibaba.fastjson.JSONObject extra;

    public com.alibaba.fastjson.JSONObject getExtra() {
        return extra;
    }
    public void setExtra(com.alibaba.fastjson.JSONObject extra) {
        this.extra = extra;
    }


    @com.baomidou.mybatisplus.annotations.TableField(exist = false)
    private com.alibaba.fastjson.JSONArray images;

    public com.alibaba.fastjson.JSONArray getImages() {
        return images;
    }
    public void setImages(com.alibaba.fastjson.JSONArray images) {
        this.images = images;
    }

    @com.baomidou.mybatisplus.annotations.TableField(exist = false)
    private com.alibaba.fastjson.JSONArray tags;

    public com.alibaba.fastjson.JSONArray getTags() {
        return tags;
    }
    public void setTags(com.alibaba.fastjson.JSONArray tags) {
        this.tags = tags;
    }

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户id
     */
	@TableField("user_id")
	private Long userId;
    /**
     * �?请人id
     */
	@TableField("invitor_alliance_id")
	private Integer invitorAllianceId;
    /**
     * 是否为盟�? 0:否，1:临时�?2:正式
     */
	@TableField("alliance_ship")
	private Integer allianceShip;
    /**
     * 是否为股�? 0:否，1:�?
     */
	@TableField("stockholder_ship")
	private Integer stockholderShip;
    /**
     * creation_time
     */
	@TableField("creation_time")
	private Date creationTime;
    /**
     * 成为盟友的时�?
     */
	@TableField("alliance_ship_time")
	private Date allianceShipTime;
    /**
     * 成为股东的时�?
     */
	@TableField("stockholder_ship_time")
	private Date stockholderShipTime;
    /**
     * 临时盟友过期时间
     */
	@TableField("temp_alliance_expiry_time")
	private Date tempAllianceExpiryTime;
    /**
     * 盟友状�?�，0:禁止�?1:正常
     */
	@TableField("alliance_status")
	private Integer allianceStatus;
    /**
     * 入库金额
     */
	@TableField("alliance_store_amount")
	private BigDecimal allianceStoreAmount;


	public Long getId() {
		return id;
	}

	public Alliance setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public Alliance setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Integer getInvitorAllianceId() {
		return invitorAllianceId;
	}

	public Alliance setInvitorAllianceId(Integer invitorAllianceId) {
		this.invitorAllianceId = invitorAllianceId;
		return this;
	}

	public Integer getAllianceShip() {
		return allianceShip;
	}

	public Alliance setAllianceShip(Integer allianceShip) {
		this.allianceShip = allianceShip;
		return this;
	}

	public Integer getStockholderShip() {
		return stockholderShip;
	}

	public Alliance setStockholderShip(Integer stockholderShip) {
		this.stockholderShip = stockholderShip;
		return this;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public Alliance setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
		return this;
	}

	public Date getAllianceShipTime() {
		return allianceShipTime;
	}

	public Alliance setAllianceShipTime(Date allianceShipTime) {
		this.allianceShipTime = allianceShipTime;
		return this;
	}

	public Date getStockholderShipTime() {
		return stockholderShipTime;
	}

	public Alliance setStockholderShipTime(Date stockholderShipTime) {
		this.stockholderShipTime = stockholderShipTime;
		return this;
	}

	public Date getTempAllianceExpiryTime() {
		return tempAllianceExpiryTime;
	}

	public Alliance setTempAllianceExpiryTime(Date tempAllianceExpiryTime) {
		this.tempAllianceExpiryTime = tempAllianceExpiryTime;
		return this;
	}

	public Integer getAllianceStatus() {
		return allianceStatus;
	}

	public Alliance setAllianceStatus(Integer allianceStatus) {
		this.allianceStatus = allianceStatus;
		return this;
	}

	public BigDecimal getAllianceStoreAmount() {
		return allianceStoreAmount;
	}

	public Alliance setAllianceStoreAmount(BigDecimal allianceStoreAmount) {
		this.allianceStoreAmount = allianceStoreAmount;
		return this;
	}

	public static final String ID = "id";

	public static final String USER_ID = "user_id";

	public static final String INVITOR_ALLIANCE_ID = "invitor_alliance_id";

	public static final String ALLIANCE_SHIP = "alliance_ship";

	public static final String STOCKHOLDER_SHIP = "stockholder_ship";

	public static final String CREATION_TIME = "creation_time";

	public static final String ALLIANCE_SHIP_TIME = "alliance_ship_time";

	public static final String STOCKHOLDER_SHIP_TIME = "stockholder_ship_time";

	public static final String TEMP_ALLIANCE_EXPIRY_TIME = "temp_alliance_expiry_time";

	public static final String ALLIANCE_STATUS = "alliance_status";

	public static final String ALLIANCE_STORE_AMOUNT = "alliance_store_amount";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Alliance{" +
			"id=" + id +
			", userId=" + userId +
			", invitorAllianceId=" + invitorAllianceId +
			", allianceShip=" + allianceShip +
			", stockholderShip=" + stockholderShip +
			", creationTime=" + creationTime +
			", allianceShipTime=" + allianceShipTime +
			", stockholderShipTime=" + stockholderShipTime +
			", tempAllianceExpiryTime=" + tempAllianceExpiryTime +
			", allianceStatus=" + allianceStatus +
			", allianceStoreAmount=" + allianceStoreAmount +
			"}";
	}
}
