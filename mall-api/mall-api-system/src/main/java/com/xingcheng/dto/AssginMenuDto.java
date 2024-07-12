package com.xingcheng.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AssginMenuDto {
    // userId必须
    private Long roleId;				// 角色id
    private List<Map<String , Number>> menuIdList;		// 菜单id
}

