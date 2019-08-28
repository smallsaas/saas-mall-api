package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-31
 */
@TableName("t_incl_postage_proviso")
public class InclPostageProviso extends Model<InclPostageProviso> {

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
	@TableField("fare_id")
	private Integer fareId;
	private String region;
	@TableField("piece_no")
	private Integer pieceNo;
	@TableField("weight_no")
	private Integer weightNo;
	@TableField("bulk_no")
	private Integer bulkNo;
	private BigDecimal amount;
	@TableField("carry_way")
	private Integer carryWay;
	private Integer type;


	public Long getId() {
		return id;
	}

	public InclPostageProviso setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getFareId() {
		return fareId;
	}

	public InclPostageProviso setFareId(Integer fareId) {
		this.fareId = fareId;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public InclPostageProviso setRegion(String region) {
		this.region = region;
		return this;
	}

	public Integer getPieceNo() {
		return pieceNo;
	}

	public InclPostageProviso setPieceNo(Integer pieceNo) {
		this.pieceNo = pieceNo;
		return this;
	}

	public Integer getWeightNo() {
		return weightNo;
	}

	public InclPostageProviso setWeightNo(Integer weightNo) {
		this.weightNo = weightNo;
		return this;
	}

	public Integer getBulkNo() {
		return bulkNo;
	}

	public InclPostageProviso setBulkNo(Integer bulkNo) {
		this.bulkNo = bulkNo;
		return this;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public InclPostageProviso setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public Integer getCarryWay() {
		return carryWay;
	}

	public InclPostageProviso setCarryWay(Integer carryWay) {
		this.carryWay = carryWay;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public InclPostageProviso setType(Integer type) {
		this.type = type;
		return this;
	}

	public static final String ID = "id";

	public static final String FARE_ID = "fare_id";

	public static final String REGION = "region";

	public static final String PIECE_NO = "piece_no";

	public static final String WEIGHT_NO = "weight_no";

	public static final String BULK_NO = "bulk_no";

	public static final String AMOUNT = "amount";

	public static final String CARRY_WAY = "carry_way";

	public static final String TYPE = "type";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "InclPostageProviso{" +
			"id=" + id +
			", fareId=" + fareId +
			", region=" + region +
			", pieceNo=" + pieceNo +
			", weightNo=" + weightNo +
			", bulkNo=" + bulkNo +
			", amount=" + amount +
			", carryWay=" + carryWay +
			", type=" + type +
			"}";
	}
}
