package com.jfeat.am.module.store.services.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Code Generator
 * @since 2018-06-09
 */
@TableName("t_store")
public class Store extends Model<Store> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String type;
    @TableField("warehouse_id")
    private Long warehouseId;
    private String code;
    private String name;
    private String avatar;
    private String director;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String address;
    private String pcd;
    private String introduce;
    private String telephone;
    private String status;
    @TableField("create_time")
    private Date createTime;
    private String province;
    private String city;
    private String district;
    @TableField("org_id")
    private Long orgId;

    public String getStatus() {
        return status;
    }

    public Store setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Store setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public Store setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public Store setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Store setName(String name) {
        this.name = name;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public Store setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public Store setDirector(String director) {
        this.director = director;
        return this;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public Store setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
        return this;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public Store setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Store setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPcd() {
        return pcd;
    }

    public void setPcd(String pcd) {
        this.pcd = pcd;
    }

    public String getIntroduce() {
        return introduce;
    }

    public Store setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Store setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Store setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public static final String ID = "id";

    public static final String WAREHOUSE_ID = "warehouse_id";

    public static final String TYPE = "type";

    public static final String CODE = "code";

    public static final String NAME = "name";

    public static final String AVATAR = "avatar";

    public static final String DIRECTOR = "director";

    public static final String LONGITUDE = "longitude";

    public static final String LATITUDE = "latitude";

    public static final String ADDRESS = "address";

    public static final String PCD = "pcd";
    public static final String PROVINCE = "province";

    public static final String CITY = "city";

    public static final String DISTRICT = "district";

    public static final String INTRODUCE = "introduce";

    public static final String TELEPHONE = "telephone";

    public static final String CREATE_TIME = "create_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", warehouseId=" + warehouseId +
                ", type=" + type +
                ", code=" + code +
                ", name=" + name +
                ", avatar=" + avatar +
                ", director=" + director +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", address=" + address +
                ", pcd=" + pcd +
                ", province=" + province +
                ", city=" + city +
                ", district=" + district +
                ", introduce=" + introduce +
                ", telephone=" + telephone +
                ", createTime=" + createTime +
                "}";
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
