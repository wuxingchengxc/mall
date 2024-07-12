package com.xingcheng.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 菜单表(SysMenu)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 23:00:29
 */
@SuppressWarnings("serial")
@Data
@Schema(description = "菜单表vo" )
public class SysMenuVo {

    /**
     * 主键值
     */
    @Schema(description = "主键值" )
    private Long id;


    //所属上级    
    @Schema(description = "所属上级" )
    private Long parentId;
    @Schema(description = "组件名称" )
    private String name;
    //菜单标题    
    @Schema(description = "菜单标题" )
    private String title;
    
              
    //组件名称    
    @Schema(description = "组件名称" )
    private String component;
    
              
    //排序    
    @Schema(description = "排序" )
    private Integer sortValue;
    
              
    //状态(0:禁止,1:正常)    
    @Schema(description = "状态(0:禁止,1:正常)" )
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

    List<SysMenuVo> children = new ArrayList<>();

}

