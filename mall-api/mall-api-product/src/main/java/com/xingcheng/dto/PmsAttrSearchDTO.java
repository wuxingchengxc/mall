package com.xingcheng.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PmsAttrSearchDTO {

    /**
     * 主键值
     */
    @NotNull(message = "分类id不能为空")
    private Long catelogId;

    private String searchKey;

}
