package com.xingcheng.controller;



import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.SysUser;
import com.xingcheng.dto.SysUserDto;
import com.xingcheng.service.SysUserService;
import com.xingcheng.util.StringUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(SysUser)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-24 19:48:18
 */
@RestController
@Tag(name = "用户表控制层")
@RequestMapping("/sysUser")
public class SysUserController extends BaseController<SysUser> {

    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询所有数据
     * @return 所有数据
     */
    @Operation(summary = "分页查询数据" )
    @PostMapping("/page/list")
    public Result pageList(@RequestBody SysUserDto sysUserDto) {
        startPage();
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(sysUserDto.getKeyword())) {
            lambdaQueryWrapper
                    .like(SysUser::getName, sysUserDto.getKeyword());
        }
        if (StrUtil.isNotBlank(sysUserDto.getCreateTimeBegin()) &&  StrUtil.isNotBlank(sysUserDto.getCreateTimeEnd()) ) {
            lambdaQueryWrapper
                    .ge(SysUser::getCreateTime, sysUserDto.getCreateTimeBegin())
                    .le(SysUser::getCreateTime, sysUserDto.getCreateTimeEnd());
        }
        return success(getPageInfo(this.sysUserService.list(lambdaQueryWrapper)));
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Operation(summary = "通过主键查询单条数据" )
    @GetMapping("/list/{id}")
    public Result selectOne(@PathVariable("id") Serializable id) {
        return success(this.sysUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@RequestBody SysUser sysUser) {
        sysUser.setPassword(DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes()));
        return success(this.sysUserService.save(sysUser));
    }

    /**
     * 修改数据
     *
     * @param sysUser 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody SysUser sysUser) {
        return success(this.sysUserService.updateById(sysUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @Operation(summary = "删除数据" )
    @DeleteMapping("/delete")
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysUserService.removeByIds(idList));
    }
}

