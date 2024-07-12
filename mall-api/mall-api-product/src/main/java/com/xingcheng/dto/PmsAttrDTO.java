package com.xingcheng.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PmsAttrDTO {

    /**
     * 主键值
     */
    @Schema(description = "主键值" )
    private Long attrId;


    //属性名
    @Schema(description = "属性名" )
    private String attrName;


    //是否需要检索[0-不需要，1-需要]
    @Schema(description = "是否需要检索[0-不需要，1-需要]" )
    private Integer searchType;


    //属性图标
    @Schema(description = "属性图标" )
    private String icon;


    //可选值列表[用逗号分隔]
    @Schema(description = "可选值列表[用逗号分隔]" )
    private String valueSelect;


    //属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
    @Schema(description = "属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]" )
    private Integer attrType;


    //启用状态[0 - 禁用，1 - 启用]
    @Schema(description = "启用状态[0 - 禁用，1 - 启用]" )
    private Long enable;


    //所属分类
    @Schema(description = "所属分类" )
    private Long catelogId;


    //快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
    @Schema(description = "快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整" )
    private Integer showDesc;

    @Schema(description = "分组id" )
    private Long attrGroupId;
}
