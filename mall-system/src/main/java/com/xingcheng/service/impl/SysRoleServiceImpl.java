package com.xingcheng.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.mapper.SysRoleMapper;
import com.xingcheng.domain.SysRole;
import com.xingcheng.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色(SysRole)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 14:26:52
 */
@Service("sysRoleServiceImpl")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public Boolean checkUniqueRoleName(SysRole role) {
        Long roleId = role.getId() == null ? -1L : role.getId();
        LambdaQueryWrapper<SysRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRole::getRoleName, role.getRoleName());
        List<SysRole> list = list(lambdaQueryWrapper);
        if (CollUtil.isNotEmpty(list) && !roleId.equals(list.get(0).getId())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

