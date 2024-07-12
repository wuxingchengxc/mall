package com.xingcheng.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.SysRole;
import com.xingcheng.dto.AssginRoleDto;
import com.xingcheng.dto.SysRoleDto;
import com.xingcheng.enums.ReturnCodeEnum;
import com.xingcheng.service.SysRoleService;
import com.xingcheng.service.SysUserRoleService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色(SysRole)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-24 14:26:52
 */
@RestController
@Tag(name = "角色控制层")
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController<SysRole> {

    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 分页查询所有数据
     *
     * @param sysRole 查询实体
     * @return 所有数据
     */
    @Operation(summary = "分页查询数据" )
    @PostMapping("/page/list")
    public Result pageList(@RequestBody SysRoleDto sysRole) {
        startPage();
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(SysRole::getRoleName, sysRole.getRoleName());
        return success(getPageInfo(this.sysRoleService.list(queryWrapper)));
    }


    /**
     * 查询所有角色数据
     */
    @Operation(summary = "查询所有角色数据" )
    @GetMapping("/findAllRoles/{userId}")
    public Result findAllRoles(@PathVariable(value = "userId") Long userId) {
        List<SysRole> list = sysRoleService.list();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("allRolesList", list);
        resultMap.put("sysUserRoles", sysUserRoleService.findRoleIdByUserId(userId));
        return success(resultMap);
    }

    /**
     * 分配角色
     * @param assginRoleDto
     * @return
     */
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginRoleDto assginRoleDto) {
        sysUserRoleService.doAssign(assginRoleDto) ;
        return success();
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
        return success(this.sysRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRole 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@RequestBody SysRole sysRole) {
        // 唯一性校验
        if (Boolean.FALSE.equals(sysRoleService.checkUniqueRoleName(sysRole))) {
            return error(ReturnCodeEnum.REPEAT_ROLE_NAME_ERROR);
        }
        return success(this.sysRoleService.save(sysRole));
    }

    /**
     * 修改数据
     *
     * @param sysRole 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody SysRole sysRole) {
        // 唯一性校验
        if (Boolean.FALSE.equals(sysRoleService.checkUniqueRoleName(sysRole))) {
            return error(ReturnCodeEnum.REPEAT_ROLE_NAME_ERROR);
        }
        return success(this.sysRoleService.updateById(sysRole));
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
        return success(this.sysRoleService.removeByIds(idList));
    }
}

