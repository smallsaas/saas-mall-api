package com.jfeat.am.module.store.services.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Code Generator
 * @since 2018-08-17
 */
@TableName("t_assistant_vip_relation")
public class AssistantVipRelation extends Model<AssistantVipRelation> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("assistant_id")
    private Long assistantId;
    @TableField("vip_id")
    private Long vipId;
    @TableField("create_time")
    private Date createTime;
    @TableField("store_id")
    private Long storeId;
    @TableField("org_id")
    private Long orgId;

    public Long getId() {
        return id;
    }

    public AssistantVipRelation setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getAssistantId() {
        return assistantId;
    }

    public AssistantVipRelation setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
        return this;
    }

    public Long getVipId() {
        return vipId;
    }

    public AssistantVipRelation setVipId(Long vipId) {
        this.vipId = vipId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public AssistantVipRelation setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getStoreId() {
        return storeId;
    }

    public AssistantVipRelation setStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public static final String ID = "id";

    public static final String ASSISTANT_ID = "assistant_id";

    public static final String VIP_ID = "vip_id";

    public static final String CREATE_TIME = "create_time";

    public static final String STORE_ID = "store_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AssistantVipRelation{" +
                "id=" + id +
                ", assistantId=" + assistantId +
                ", vipId=" + vipId +
                ", createTime=" + createTime +
                ", storeId=" + storeId +
                "}";
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
