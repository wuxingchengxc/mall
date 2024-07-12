package com.xingcheng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingcheng.domain.SysMenu;
import com.xingcheng.vo.SysMenuVo;

import java.util.List;

/**
 * 菜单表(SysMenu)表服务接口
 *
 * @author xingcheng.wu
 * @since 2024-04-24 23:00:29
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenuVo> findNodes();

    List<SysMenuVo> selectListByUserId(Long userId);
}

