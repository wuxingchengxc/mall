package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * 仓库信息(WmsWareInfo)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-05-12 18:35:20
 */
@SuppressWarnings("serial")
@Schema(description = "仓库信息实体类" )
public class WmsWareInfo extends Model<WmsWareInfo> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" )
    private Long id;
    
              
    //仓库名    
    @Schema(description = "仓库名" )
    private String name;
    
              
    //仓库地址    
    @Schema(description = "仓库地址" )
    private String address;
    
              
    //区域编码    
    @Schema(description = "区域编码" )
    private String areacode;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
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

