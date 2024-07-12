package com.xingcheng.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class PmsCategoryVO {

    /**
     * 主键值
     */
    private Long catId;

    //分类名称
    private String name;

    //父分类id
    private Long parentCid;

    //层级
    private Integer catLevel;

    //是否显示[0-不显示，1显示]
    private Integer showStatus;

    //排序
    private Integer sort;

    //图标地址
    private String icon;

    //计量单位
    private String productUnit;

    //商品数量
    private Integer productCount;

    // 子类
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<PmsCategoryVO> children;

}
