package com.xingcheng.util;

import com.xingcheng.vo.SysMenuVo;

import java.util.List;
import java.util.stream.Collectors;

public class TreeUtil {

    /**
     * 递归获取父级菜单
     */
    public static List<SysMenuVo> buildTree (List<SysMenuVo> allMenus) {
        return allMenus.stream().filter(menu -> menu.getParentId().equals(0L))
                .map(pmenu -> {
                    pmenu.setChildren(buildChlidrenTree(allMenus, pmenu));
                    pmenu.setName(pmenu.getComponent());
                    return pmenu;
                })
                .collect(Collectors.toList());
    }

    /**
     * 递归查询子菜单
     */
    public static List<SysMenuVo> buildChlidrenTree (List<SysMenuVo> allMenus, SysMenuVo menuVo) {
        return allMenus.stream().filter(pmenu -> pmenu.getParentId().equals(menuVo.getId()))
                .map(menu -> {
                    menu.setChildren(buildChlidrenTree(allMenus, menu));
                    menu.setName(menu.getComponent());
                    return menu;
                })
                .collect(Collectors.toList());
    }
}
