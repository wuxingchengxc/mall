package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * 角色菜单(SysRoleMenu)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 23:00:43
 */
@SuppressWarnings("serial")
@Schema(description = "角色菜单实体类" )
public class SysRoleMenu extends Model<SysRoleMenu> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" )
    private Long id;
    
              
        
    @Schema(description = "${column.comment}" )
    private Long roleId;
    
              
        
    @Schema(description = "${column.comment}" )
    private Long menuId;
    
              
    //创建时间    
    @Schema(description = "创建时间" )
    private Date createTime;
    
              
    //更新时间    
    @Schema(description = "更新时间" )
    private Date updateTime;
    
              
    //删除标记（0:不可用 1:可用）    
    @Schema(description = "删除标记（0:不可用 1:可用）" )
    private Integer isDeleted;
    
              
        
    @Schema(description = "描述" )
    private Integer isHalf;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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

    public Integer getIsHalf() {
        return isHalf;
    }

    public void setIsHalf(Integer isHalf) {
        this.isHalf = isHalf;
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

