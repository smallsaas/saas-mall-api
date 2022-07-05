package com.jfeat.am.module.supplier.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Code generator
 * @since 2022-05-19
 */
@TableName("t_supplier")
public class Supplier extends Model<Supplier> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 渚涘簲鍟�
     */
    private String name;

    /**
     * 浠嬬粛
     */
    private String note;

    /**
     * 绫诲瀷 棰勭暀
     */
    private Integer type;

    /**
     * 渚涘簲鍟嗗浘鐗�
     */
    private String url;

    /**
     * 渚涘簲鍟嗗湴鍧�
     */
    private String address;


    private String phone;


    private Long userId;

    @TableField(updateStrategy = FieldStrategy.IGNORED )
    private Long endUserId;


    private Long orgId;


    private String link;

    private String snapshot;
    @TableField(updateStrategy = FieldStrategy.IGNORED )
    private String bindKey;

    private Integer bindType;
    @TableField(updateStrategy = FieldStrategy.IGNORED )
    private Long bindUserId;

    @TableField(value = "vr_id")
    private Long vrId;


    public Long getVrId() {
        return vrId;
    }

    public void setVrId(Long vrId) {
        this.vrId = vrId;
    }

    public Long getBindUserId() {
        return bindUserId;
    }

    public void setBindUserId(Long bindUserId) {
        this.bindUserId = bindUserId;
    }

    public Integer getBindType() {
        return bindType;
    }

    public void setBindType(Integer bindType) {
        this.bindType = bindType;
    }

    public String getBindKey() {
        return bindKey;
    }

    public void setBindKey(String bindKey) {
        this.bindKey = bindKey;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    public Long getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Long endUserId) {
        this.endUserId = endUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public Supplier setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Supplier setName(String name) {
        this.name = name;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Supplier setNote(String note) {
        this.note = note;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Supplier setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Supplier setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Supplier setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getOrgId() {
        return orgId;
    }

    public Supplier setOrgId(Long orgId) {
        this.orgId = orgId;
        return this;
    }

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String NOTE = "note";

    public static final String TYPE = "type";

    public static final String URL = "url";

    public static final String ADDRESS = "address";

    public static final String ORG_ID = "org_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name=" + name +
                ", note=" + note +
                ", type=" + type +
                ", url=" + url +
                ", address=" + address +
                ", orgId=" + orgId +
                "}";
    }
}
