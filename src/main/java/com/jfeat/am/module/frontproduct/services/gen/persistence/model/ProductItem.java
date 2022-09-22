package com.jfeat.am.module.frontproduct.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code generator
 * @since 2022-09-20
 */
@TableName("t_product_item")
@ApiModel(value="ProductItem对象", description="")
public class ProductItem extends Model<ProductItem> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "父id")
      private Long parentId;

      @ApiModelProperty(value = "子id")
      private Long childId;

      @ApiModelProperty(value = "备注")
      private String note;

      @ApiModelProperty(value = "创建时间")
      private Date createTime;

      @ApiModelProperty(value = "更新时间")
      private Date updateTime;

    
    public Long getId() {
        return id;
    }

      public ProductItem setId(Long id) {
          this.id = id;
          return this;
      }
    
    public Long getParentId() {
        return parentId;
    }

      public ProductItem setParentId(Long parentId) {
          this.parentId = parentId;
          return this;
      }
    
    public Long getChildId() {
        return childId;
    }

      public ProductItem setChildId(Long childId) {
          this.childId = childId;
          return this;
      }
    
    public String getNote() {
        return note;
    }

      public ProductItem setNote(String note) {
          this.note = note;
          return this;
      }
    
    public Date getCreateTime() {
        return createTime;
    }

      public ProductItem setCreateTime(Date createTime) {
          this.createTime = createTime;
          return this;
      }
    
    public Date getUpdateTime() {
        return updateTime;
    }

      public ProductItem setUpdateTime(Date updateTime) {
          this.updateTime = updateTime;
          return this;
      }

      public static final String ID = "id";

      public static final String PARENT_ID = "parent_id";

      public static final String CHILD_ID = "child_id";

      public static final String NOTE = "note";

      public static final String CREATE_TIME = "create_time";

      public static final String UPDATE_TIME = "update_time";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "ProductItem{" +
              "id=" + id +
                  ", parentId=" + parentId +
                  ", childId=" + childId +
                  ", note=" + note +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
