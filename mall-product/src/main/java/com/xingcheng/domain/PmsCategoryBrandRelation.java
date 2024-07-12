package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * 品牌分类关联(PmsCategoryBrandRelation)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-30 13:12:25
 */
@SuppressWarnings("serial")
@Schema(description = "品牌分类关联实体类" )
public class PmsCategoryBrandRelation extends Model<PmsCategoryBrandRelation> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" )
    private Long id;
    
              
    //品牌id    
    @Schema(description = "品牌id" )
    private Long brandId;
    
              
    //分类id    
    @Schema(description = "分类id" )
    @NotNull(message = "分类id不能为空")
    private Long catelogId;
    
              
        
    @Schema(description = "${column.comment}" )
    private String brandName;
    
              
        
    @Schema(description = "${column.comment}" )
    private String catelogName;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(Long catelogId) {
        this.catelogId = catelogId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCatelogName() {
        return catelogName;
    }

    public void setCatelogName(String catelogName) {
        this.catelogName = catelogName;
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

