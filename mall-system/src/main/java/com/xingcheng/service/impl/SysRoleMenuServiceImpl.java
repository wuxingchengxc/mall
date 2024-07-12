package com.xingcheng.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.domain.SysUserRole;
import com.xingcheng.dto.AssginMenuDto;
import com.xingcheng.dto.AssginRoleDto;
import com.xingcheng.mapper.SysRoleMenuMapper;
import com.xingcheng.domain.SysRoleMenu;
import com.xingcheng.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色菜单(SysRoleMenu)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 23:00:43
 */
@Service("sysRoleMenuServiceImpl")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    // 获取菜单
    @Override
    public List<Long> findMenuIdByRoleId(Long roleId) {
        LambdaQueryWrapper<SysRoleMenu> userRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userRoleLambdaQueryWrapper.eq(SysRoleMenu::getRoleId, roleId);
        List<SysRoleMenu> list = list(userRoleLambdaQueryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            return list.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public List<Long> findMenuIdByRoleIds(List<Long> roleIds) {
        LambdaQueryWrapper<SysRoleMenu> userRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userRoleLambdaQueryWrapper.in(SysRoleMenu::getRoleId, roleIds);
        List<SysRoleMenu> list = list(userRoleLambdaQueryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            return list.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public void doAssign(AssginMenuDto assginMenuDto) {
        if (null != assginMenuDto.getRoleId()) {
            // 先删除该用户所有关联对象
            LambdaQueryWrapper<SysRoleMenu> userRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userRoleLambdaQueryWrapper.eq(SysRoleMenu::getRoleId, assginMenuDto.getRoleId());
            remove(userRoleLambdaQueryWrapper);
        }
        // 批量生成对象
        List<SysRoleMenu> sysRoleMenus = assginMenuDto.getMenuIdList().stream().map(item -> {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(assginMenuDto.getRoleId());
            sysRoleMenu.setIsHalf(item.get("isHalf").intValue());
            sysRoleMenu.setMenuId(item.get("id").longValue());
            return  sysRoleMenu;
        }).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(sysRoleMenus)) {
            saveBatch(sysRoleMenus);
        }
    }
}

