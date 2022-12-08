package com.jfeat.am.module.address.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 *
 * </p>
 *
 * @author Code generator
 * @since 2022-08-13
 */
@TableName("t_address")
@ApiModel(value = "Address对象", description = "")
public class Address extends Model<Address> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "固定电话")
    private String tel;

    @ApiModelProperty(value = "省-名称")
    private String provinceName;

    @ApiModelProperty(value = "省-行政编码")
    private String provinceCode;

    @ApiModelProperty(value = "市-名称")
    private String cityName;

    @ApiModelProperty(value = "市-行政编码")
    private String cityCode;

    @ApiModelProperty(value = "区名")
    private String areaName;

    @ApiModelProperty(value = "区-行政编码")
    private String areaCode;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "邮政编码")
    private String zip;

    @ApiModelProperty(value = "是否默认 0-不默认 1-默认")
    private Integer defaultStatus;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    private String note;


    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Address setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Address setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Address setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public Address setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public Address setProvinceName(String provinceName) {
        this.provinceName = provinceName;
        return this;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public Address setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public Address setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getCityCode() {
        return cityCode;
    }

    public Address setCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public Address setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public Address setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Address setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Address setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public Address setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Address setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Address setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Address setNote(String note) {
        this.note = note;
        return this;
    }

    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String NAME = "name";

    public static final String PHONE = "phone";

    public static final String TEL = "tel";

    public static final String PROVINCE_NAME = "province_name";

    public static final String PROVINCE_CODE = "province_code";

    public static final String CITY_NAME = "city_name";

    public static final String CITY_CODE = "city_code";

    public static final String AREA_NAME = "area_name";

    public static final String AREA_CODE = "area_code";

    public static final String ADDRESS = "address";

    public static final String ZIP = "zip";

    public static final String DEFAULT_STATUS = "default_status";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String NOTE = "note";

    public static final Integer DEFAULT_STATUS_NOT_DEFAULT = 0;

    public static final Integer DEFAULT_STATUS_DEFAULT = 1;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", name=" + name +
                ", phone=" + phone +
                ", tel=" + tel +
                ", provinceName=" + provinceName +
                ", provinceCode=" + provinceCode +
                ", cityName=" + cityName +
                ", cityCode=" + cityCode +
                ", areaName=" + areaName +
                ", areaCode=" + areaCode +
                ", address=" + address +
                ", zip=" + zip +
                ", defaultStatus=" + defaultStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", note=" + note +
                "}";
    }
}
