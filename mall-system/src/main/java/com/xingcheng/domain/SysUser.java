package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * 用户表(SysUser)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 19:48:20
 */
@SuppressWarnings("serial")
@Schema(description = "用户表实体类" )
public class SysUser extends Model<SysUser> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" )
    private Long id;
    
              
    //用户名    
    @Schema(description = "用户名" )
    private String username;
    
              
    //密码    
    @Schema(description = "密码" )
    private String password;
    
              
    //姓名    
    @Schema(description = "姓名" )
    private String name;
    
              
    //手机    
    @Schema(description = "手机" )
    private String phone;
    
              
    //头像    
    @Schema(description = "头像" )
    private String avatar;
    
              
    //描述    
    @Schema(description = "描述" )
    private String description;
    
              
    //状态（1：正常 0：停用）    
    @Schema(description = "状态（1：正常 0：停用）" )
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

