package com.jfeat.am.module.store.services.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
 * @since 2018-06-09
 */
@TableName("t_store_assistant")
public class StoreAssistant extends Model<StoreAssistant> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String username;
    private String avatar;
    private String position;
    private String telephone;
    private String wechat;
    private String qq;
    private String status;
    @TableField("is_director")
    private Integer isDirector;
    @TableField("director_id")
    private Long directorId;
    @TableField("store_id")
    private Long storeId;
    @TableField("user_id")
    private Long userId;
    @TableField("org_id")
    private Long orgId;

    public Long getId() {
        return id;
    }

    public StoreAssistant setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public StoreAssistant setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public StoreAssistant setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public StoreAssistant setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public StoreAssistant setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public StoreAssistant setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getWechat() {
        return wechat;
    }

    public StoreAssistant setWechat(String wechat) {
        this.wechat = wechat;
        return this;
    }

    public String getQq() {
        return qq;
    }

    public StoreAssistant setQq(String qq) {
        this.qq = qq;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public StoreAssistant setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getIsDirector() {
        return isDirector;
    }

    public StoreAssistant setIsDirector(Integer isDirector) {
        this.isDirector = isDirector;
        return this;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public StoreAssistant setDirectorId(Long directorId) {
        this.directorId = directorId;
        return this;
    }

    public Long getStoreId() {
        return storeId;
    }

    public StoreAssistant setStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public StoreAssistant setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public static final String ID = "id";

    public static final String CODE = "code";

    public static final String NAME = "name";

    public static final String USERNAME = "username";

    public static final String AVATAR = "avatar";

    public static final String POSITION = "position";

    public static final String TELEPHONE = "telephone";

    public static final String WECHAT = "wechat";

    public static final String QQ = "qq";

    public static final String STATUS = "status";

    public static final String IS_DIRECTOR = "is_director";

    public static final String DIRECTOR_ID = "director_id";

    public static final String STORE_ID = "store_id";

    public static final String USER_ID = "user_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StoreAssistant{" +
                "id=" + id +
                ", code=" + code +
                ", name=" + name +
                ", username=" + username +
                ", avatar=" + avatar +
                ", position=" + position +
                ", telephone=" + telephone +
                ", wechat=" + wechat +
                ", qq=" + qq +
                ", status=" + status +
                ", isDirector=" + isDirector +
                ", directorId=" + directorId +
                ", storeId=" + storeId +
                ", userId=" + userId +
                "}";
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
