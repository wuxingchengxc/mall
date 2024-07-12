package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * 角色(SysRole)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 14:26:52
 */
@SuppressWarnings("serial")
@Schema(description = "角色实体类" )
public class SysRole extends Model<SysRole> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" )
    private Long id;
    
              
    //角色名称    
    @Schema(description = "角色名称" )
    private String roleName;
    
              
    //角色编码    
    @Schema(description = "角色编码" )
    private String roleCode;
    
              
    //描述    
    @Schema(description = "描述" )
    private String description;
    
              
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

