package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * 会员表(UserInfo)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-23 12:40:10
 */
@SuppressWarnings("serial")
@Schema(description = "会员表实体类" )
public class UserInfo extends Model<UserInfo> {

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
    
              
    //昵称    
    @Schema(description = "昵称" )
    private String nickName;
    
              
    //电话号码    
    @Schema(description = "电话号码" )
    private String phone;
    
              
    //头像    
    @Schema(description = "头像" )
    private String avatar;
    
              
    //性别    
    @Schema(description = "性别" )
    private Integer sex;
    
              
    //备注    
    @Schema(description = "备注" )
    private String memo;
    
              
    //微信open id    
    @Schema(description = "微信open id" )
    private String openId;
    
              
    //微信开放平台unionID    
    @Schema(description = "微信开放平台unionID" )
    private String unionId;
    
              
    //最后一次登录ip    
    @Schema(description = "最后一次登录ip" )
    private String lastLoginIp;
    
              
    //最后一次登录时间    
    @Schema(description = "最后一次登录时间" )
    private Date lastLoginTime;
    
              
    //状态：1为正常，0为禁止    
    @Schema(description = "状态：1为正常，0为禁止" )
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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

