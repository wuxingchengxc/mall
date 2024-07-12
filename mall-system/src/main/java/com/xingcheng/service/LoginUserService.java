package com.xingcheng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingcheng.domain.SysUser;
import com.xingcheng.dto.LoginDto;
import com.xingcheng.vo.LoginVo;
import com.xingcheng.vo.ValidateCodeVo;

/**
 * 用户表(SysUser)表服务接口
 *
 * @author xingcheng.wu
 */
public interface LoginUserService extends IService<SysUser> {

    LoginVo login(LoginDto loginDto);

    void logout(String token);

    ValidateCodeVo generateValidateCode();
}

