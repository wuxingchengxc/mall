package com.xingcheng.controller;

import com.xingcheng.domain.Result;
import com.xingcheng.domain.SysUser;
import com.xingcheng.dto.LoginDto;
import com.xingcheng.service.LoginUserService;
import com.xingcheng.service.SysMenuService;
import com.xingcheng.service.SysUserService;
import com.xingcheng.util.AuthContextUtil;
import com.xingcheng.vo.LoginVo;
import com.xingcheng.vo.SysMenuVo;
import com.xingcheng.vo.ValidateCodeVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "用户登录接口")
@RequestMapping("/admin/system/index")
public class IndexController extends BaseController{

    /**
     * 登录相关
     */
    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 登录
     */
    @Operation(summary = "登录" )
    @PostMapping("/login")
    public Result<LoginVo> lgoin(@RequestBody LoginDto loginDto) {
        return success(this.loginUserService.login(loginDto));
    }

    /**
     * 退出
     */
    @Operation(summary = "退出" )
    @GetMapping("/logout")
    public Result logout(@RequestHeader(name = "token") String token) {
        this.loginUserService.logout(token);
        return success();
    }

    /**
     * 获取验证码
     */
    @Operation(summary = "获取验证码" )
    @GetMapping("/generate/validateCode")
    public Result<ValidateCodeVo> generateValidateCode() {
        return success(loginUserService.generateValidateCode());
    }

    /**
     * 获取用户信息
     */
    @Operation(summary = "获取用户信息" )
    @GetMapping("/getUserInfo")
    public Result getUserInfo() {
        return success(AuthContextUtil.get());
    }

    @GetMapping("/menus")
    public Result menus() {
        SysUser sysUser = AuthContextUtil.get();
        // 获取当前登录用户的id
        Long userId = sysUser.getId();
        return Result.success(sysMenuService.selectListByUserId(userId));
    }
}
