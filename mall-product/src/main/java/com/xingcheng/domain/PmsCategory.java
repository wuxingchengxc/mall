package com.xingcheng.domain;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 商品三级分类(PmsCategory)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-19 01:35:56
 */
@SuppressWarnings("serial")
@Data
public class PmsCategory  {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" , requiredMode = Schema.RequiredMode.REQUIRED)
    private Long catId;
    
              
    //分类名称
    @Schema(description = "分类名称" , requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    
              
    //父分类id
    @Schema(description = "父分类id" , requiredMode = Schema.RequiredMode.REQUIRED)
    private Long parentCid;
    
              
    //层级
    @Schema(description = "层级" )
    private Integer catLevel;
    
              
    //是否显示[0-不显示，1显示]
    @Schema(description = "是否显示[0-不显示，1显示] " )
    @TableLogic(value = "1", delval = "0")
    private Integer showStatus;
    
              
    //排序
    @Schema(description = "排序   " )
    private Integer sort;
    
              
    //图标地址
    @Schema(description = "图标地址    " )
    private String icon;
    
              
    //计量单位
    @Schema(description = "计量单位      " )
    private String productUnit;
    
              
    //商品数量
    @Schema(description = "商品数量       " )
    private Integer productCount;
    }

