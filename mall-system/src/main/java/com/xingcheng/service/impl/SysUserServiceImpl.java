package com.xingcheng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.mapper.SysUserMapper;
import com.xingcheng.domain.SysUser;
import com.xingcheng.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-24 19:48:22
 */
@Service("sysUserServiceImpl")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}

