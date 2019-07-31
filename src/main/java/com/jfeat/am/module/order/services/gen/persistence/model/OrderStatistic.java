package com.jfeat.am.module.order.services.gen.persistence.model;

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
 * @since 2019-07-31
 */
@TableName("t_order_statistic")
public class OrderStatistic extends Model<OrderStatistic> {

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
	@TableField("created_date")
	private Date createdDate;
	@TableField("sales_amount")
	private BigDecimal salesAmount;


	public Integer getId() {
		return id;
	}

	public OrderStatistic setId(Integer id) {
		this.id = id;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public OrderStatistic setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public BigDecimal getSalesAmount() {
		return salesAmount;
	}

	public OrderStatistic setSalesAmount(BigDecimal salesAmount) {
		this.salesAmount = salesAmount;
		return this;
	}

	public static final String ID = "id";

	public static final String CREATED_DATE = "created_date";

	public static final String SALES_AMOUNT = "sales_amount";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "OrderStatistic{" +
			"id=" + id +
			", createdDate=" + createdDate +
			", salesAmount=" + salesAmount +
			"}";
	}
}
