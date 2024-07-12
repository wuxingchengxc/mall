package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * 菜单表(SysMenu)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 23:00:29
 */
@SuppressWarnings("serial")
@Schema(description = "菜单表实体类" )
public class SysMenu extends Model<SysMenu> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" )
    private Long id;
    
              
    //所属上级    
    @Schema(description = "所属上级" )
    private Long parentId;
    
              
    //菜单标题    
    @Schema(description = "菜单标题" )
    private String title;
    
              
    //组件名称    
    @Schema(description = "组件名称" )
    private String component;
    
              
    //排序    
    @Schema(description = "排序" )
    private Integer sortValue;
    
              
    //状态(0:禁止,1:正常)    
    @Schema(description = "状态(0:禁止,1:正常)" )
    private Integer status;
    
              
    //创建时间    
    @Schema(description = "创建时间" )
    private Date createTime;
    
              
    //更新时间    
    @Schema(description = "更新时间" )
    private Date updateTime;
    
              
    //删除标记（0:不可用 1:可用）    
    @Schema(description = "删除标记（0:不可用 1:可用）" )
    private Integer isDeleted;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }
    }

