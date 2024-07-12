package com.xingcheng.dto;

import lombok.Data;

import java.util.List;
@Data
public class AssginRoleDto {
    // userId必须
    private Long userId;				// 用户的id
    private List<Long> roleIdList;		// 角色id
}
