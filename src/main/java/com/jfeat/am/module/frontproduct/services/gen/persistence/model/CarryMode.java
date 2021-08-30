package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-08-01
 */
@TableName("t_carry_mode")
public class CarryMode extends Model<CarryMode> {

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
	@TableField("fare_id")
	private Long fareId;
	private String region;
	@TableField("first_piece")
	private Integer firstPiece;
	@TableField("first_weight")
	private Integer firstWeight;
	@TableField("first_bulk")
	private Integer firstBulk;
	@TableField("first_amount")
	private BigDecimal firstAmount;
	@TableField("second_piece")
	private Integer secondPiece;
	@TableField("second_weight")
	private Integer secondWeight;
	@TableField("second_bulk")
	private Integer secondBulk;
	@TableField("second_amount")
	private BigDecimal secondAmount;
	@TableField("carry_way")
	private Integer carryWay;
	@TableField("is_default")
	private Integer isDefault;


	public Long getId() {
		return id;
	}

	public CarryMode setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getFareId() {
		return fareId;
	}

	public CarryMode setFareId(Long fareId) {
		this.fareId = fareId;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public CarryMode setRegion(String region) {
		this.region = region;
		return this;
	}

	public Integer getFirstPiece() {
		return firstPiece;
	}

	public CarryMode setFirstPiece(Integer firstPiece) {
		this.firstPiece = firstPiece;
		return this;
	}

	public Integer getFirstWeight() {
		return firstWeight;
	}

	public CarryMode setFirstWeight(Integer firstWeight) {
		this.firstWeight = firstWeight;
		return this;
	}

	public Integer getFirstBulk() {
		return firstBulk;
	}

	public CarryMode setFirstBulk(Integer firstBulk) {
		this.firstBulk = firstBulk;
		return this;
	}

	public BigDecimal getFirstAmount() {
		return firstAmount;
	}

	public CarryMode setFirstAmount(BigDecimal firstAmount) {
		this.firstAmount = firstAmount;
		return this;
	}

	public Integer getSecondPiece() {
		return secondPiece;
	}

	public CarryMode setSecondPiece(Integer secondPiece) {
		this.secondPiece = secondPiece;
		return this;
	}

	public Integer getSecondWeight() {
		return secondWeight;
	}

	public CarryMode setSecondWeight(Integer secondWeight) {
		this.secondWeight = secondWeight;
		return this;
	}

	public Integer getSecondBulk() {
		return secondBulk;
	}

	public CarryMode setSecondBulk(Integer secondBulk) {
		this.secondBulk = secondBulk;
		return this;
	}

	public BigDecimal getSecondAmount() {
		return secondAmount;
	}

	public CarryMode setSecondAmount(BigDecimal secondAmount) {
		this.secondAmount = secondAmount;
		return this;
	}

	public Integer getCarryWay() {
		return carryWay;
	}

	public CarryMode setCarryWay(Integer carryWay) {
		this.carryWay = carryWay;
		return this;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public CarryMode setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
		return this;
	}

	public static final String ID = "id";

	public static final String FARE_ID = "fare_id";

	public static final String REGION = "region";

	public static final String FIRST_PIECE = "first_piece";

	public static final String FIRST_WEIGHT = "first_weight";

	public static final String FIRST_BULK = "first_bulk";

	public static final String FIRST_AMOUNT = "first_amount";

	public static final String SECOND_PIECE = "second_piece";

	public static final String SECOND_WEIGHT = "second_weight";

	public static final String SECOND_BULK = "second_bulk";

	public static final String SECOND_AMOUNT = "second_amount";

	public static final String CARRY_WAY = "carry_way";

	public static final String IS_DEFAULT = "is_default";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CarryMode{" +
			"id=" + id +
			", fareId=" + fareId +
			", region=" + region +
			", firstPiece=" + firstPiece +
			", firstWeight=" + firstWeight +
			", firstBulk=" + firstBulk +
			", firstAmount=" + firstAmount +
			", secondPiece=" + secondPiece +
			", secondWeight=" + secondWeight +
			", secondBulk=" + secondBulk +
			", secondAmount=" + secondAmount +
			", carryWay=" + carryWay +
			", isDefault=" + isDefault +
			"}";
	}
}
