package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 用户角色(SysUserRole)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 22:23:09
 */
@SuppressWarnings("serial")

@AllArgsConstructor
@Schema(description = "用户角色实体类" )
@NoArgsConstructor
public class SysUserRole extends Model<SysUserRole> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" )
    private Long id;
    
              
    //角色id    
    @Schema(description = "角色id" )
    private Long roleId;
    
              
    //用户id    
    @Schema(description = "用户id" )
    private Long userId;
    
              
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

