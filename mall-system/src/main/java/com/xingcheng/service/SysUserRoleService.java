package com.xingcheng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingcheng.domain.SysUserRole;
import com.xingcheng.dto.AssginRoleDto;

import java.util.List;

/**
 * 用户角色(SysUserRole)表服务接口
 *
 * @author xingcheng.wu
 * @since 2024-04-24 22:23:14
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    void doAssign(AssginRoleDto assginRoleDto);

    List<Long> findRoleIdByUserId(Long userId);
}

