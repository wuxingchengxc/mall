package com.xingcheng.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.dto.AssginRoleDto;
import com.xingcheng.mapper.SysUserRoleMapper;
import com.xingcheng.domain.SysUserRole;
import com.xingcheng.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色(SysUserRole)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 22:23:14
 */
@Service("sysUserRoleServiceImpl")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {


    @Override
    public void doAssign(AssginRoleDto assginRoleDto) {
        if (null != assginRoleDto.getUserId()) {
            // 先删除该用户所有关联对象
            LambdaQueryWrapper<SysUserRole> userRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userRoleLambdaQueryWrapper.eq(SysUserRole::getUserId, assginRoleDto.getUserId());
            remove(userRoleLambdaQueryWrapper);
        }
        // 批量生成对象
        List<SysUserRole> sysUserRoleList = assginRoleDto.getRoleIdList().stream().map(roleId -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(assginRoleDto.getUserId());
            return  sysUserRole;
        }).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(sysUserRoleList)) {
            saveBatch(sysUserRoleList);
        }
    }

    @Override
    public List<Long> findRoleIdByUserId(Long userId) {
        LambdaQueryWrapper<SysUserRole> userRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userRoleLambdaQueryWrapper.eq(SysUserRole::getUserId, userId);
        List<SysUserRole> list = list(userRoleLambdaQueryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            return list.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}

