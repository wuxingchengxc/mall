package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * 品牌(PmsBrand)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-28 19:43:18
 */
@SuppressWarnings("serial")
@Schema(description = "品牌实体类" )
public class PmsBrand extends Model<PmsBrand> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" )
    private Long brandId;
    
              
    //品牌名    
    @Schema(description = "品牌名" )
    private String name;
    
              
    //品牌logo地址    
    @Schema(description = "品牌logo地址" )
    private String logo;
    
              
    //介绍    
    @Schema(description = "介绍" )
    private String descript;
    
              
    //显示状态[0-不显示；1-显示]    
    @Schema(description = "显示状态[0-不显示；1-显示]" )
    private Integer showStatus;
    
              
    //检索首字母    
    @Schema(description = "检索首字母" )
    private String firstLetter;
    
              
    //排序    
    @Schema(description = "排序" )
    private Integer sort;
    
    

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.brandId;
    }
    }

