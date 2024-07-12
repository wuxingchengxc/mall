package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * 属性分组(PmsAttrGroup)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-28 22:18:18
 */
@SuppressWarnings("serial")
@Schema(description = "属性分组实体类" )
public class PmsAttrGroup extends Model<PmsAttrGroup> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" )
    private Long attrGroupId;
    
              
    //组名    
    @Schema(description = "组名" )
    private String attrGroupName;
    
              
    //排序    
    @Schema(description = "排序" )
    private Integer sort;
    
              
    //描述    
    @Schema(description = "描述" )
    private String descript;
    
              
    //组图标    
    @Schema(description = "组图标" )
    private String icon;
    
              
    //所属分类id
    @NotNull(message = "属性值id不能为空")
    @Schema(description = "所属分类id" )
    private Long catelogId;
    
    

    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }

    public String getAttrGroupName() {
        return attrGroupName;
    }

    public void setAttrGroupName(String attrGroupName) {
        this.attrGroupName = attrGroupName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(Long catelogId) {
        this.catelogId = catelogId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.attrGroupId;
    }
    }

