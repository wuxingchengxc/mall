package com.xingcheng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingcheng.domain.SysRoleMenu;
import com.xingcheng.dto.AssginMenuDto;
import com.xingcheng.dto.AssginRoleDto;

import java.util.List;

/**
 * 角色菜单(SysRoleMenu)表服务接口
 *
 * @author xingcheng.wu
 * @since 2024-04-24 23:00:43
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    List<Long> findMenuIdByRoleId(Long roleId);

    List<Long> findMenuIdByRoleIds(List<Long> roleId);

    void doAssign(AssginMenuDto assginMenuDto);
}

