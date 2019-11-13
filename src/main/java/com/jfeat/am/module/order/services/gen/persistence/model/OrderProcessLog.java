package com.jfeat.am.module.order.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-31
 */
@TableName("t_order_process_log")
public class OrderProcessLog extends Model<OrderProcessLog> {

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
	@TableField("order_id")
	private Integer orderId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@TableField("process_date")
	private Date processDate;
	private String content;


	public Long getId() {
		return id;
	}

	public OrderProcessLog setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public OrderProcessLog setOrderId(Integer orderId) {
		this.orderId = orderId;
		return this;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public OrderProcessLog setProcessDate(Date processDate) {
		this.processDate = processDate;
		return this;
	}

	public String getContent() {
		return content;
	}

	public OrderProcessLog setContent(String content) {
		this.content = content;
		return this;
	}

	public static final String ID = "id";

	public static final String ORDER_ID = "order_id";

	public static final String PROCESS_DATE = "process_date";

	public static final String CONTENT = "content";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "OrderProcessLog{" +
			"id=" + id +
			", orderId=" + orderId +
			", processDate=" + processDate +
			", content=" + content +
			"}";
	}
}
