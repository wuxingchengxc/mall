package com.xingcheng.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.convert.SysMenuConvert;
import com.xingcheng.domain.SysRoleMenu;
import com.xingcheng.mapper.SysMenuMapper;
import com.xingcheng.domain.SysMenu;
import com.xingcheng.service.SysMenuService;
import com.xingcheng.service.SysRoleMenuService;
import com.xingcheng.service.SysUserRoleService;
import com.xingcheng.util.TreeUtil;
import com.xingcheng.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单表(SysMenu)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 23:00:29
 */
@Service("sysMenuServiceImpl")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    //
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public List<SysMenuVo> findNodes() {
        // 获取第一层级的菜单
        List<SysMenu> list = list();
        // 先查询第一级
        List<SysMenuVo> allMenus = SysMenuConvert.INSTANCT.converListObject(list);
        return TreeUtil.buildTree(allMenus);
    }

    @Override
    public List<SysMenuVo> selectListByUserId(Long userId) {
        // 用户查询相关角色
        List<Long> roleIds = sysUserRoleService.findRoleIdByUserId(userId);
        if (CollUtil.isEmpty(roleIds)) {
            return new ArrayList<>();
        }
        // 根据角色id查询相关菜单
        List<Long> menuIds = sysRoleMenuService.findMenuIdByRoleIds(roleIds);
        if (CollUtil.isEmpty(menuIds)) {
            return new ArrayList<>();
        }
        // 根据菜单id查询菜单信息并转换
        List<SysMenu> sysMenus = listByIds(menuIds);
        if (CollUtil.isEmpty(sysMenus)) {
            return new ArrayList<>();
        }
        List<SysMenuVo> allMenus = SysMenuConvert.INSTANCT.converListObject(sysMenus);
        return TreeUtil.buildTree(allMenus);
    }


}

