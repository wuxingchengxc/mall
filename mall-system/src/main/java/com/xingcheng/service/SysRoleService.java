package com.xingcheng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingcheng.domain.SysRole;

/**
 * 角色(SysRole)表服务接口
 *
 * @author xingcheng.wu
 * @since 2024-04-24 14:26:52
 */
public interface SysRoleService extends IService<SysRole> {
    // 唯一
    Boolean checkUniqueRoleName (SysRole role);

}

