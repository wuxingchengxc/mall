package com.xingcheng.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.SysMenu;
import com.xingcheng.domain.SysRole;
import com.xingcheng.domain.SysUser;
import com.xingcheng.dto.AssginMenuDto;
import com.xingcheng.dto.AssginRoleDto;
import com.xingcheng.service.SysMenuService;
import com.xingcheng.service.SysRoleMenuService;
import com.xingcheng.util.AuthContextUtil;
import com.xingcheng.vo.SysMenuVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单表(SysMenu)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-24 23:00:28
 */
@RestController
@Tag(name = "菜单表控制层")
@RequestMapping("/sysMenu")
public class SysMenuController extends BaseController<SysMenu> {

    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    @GetMapping("/findNodes")
    public Result<List<SysMenuVo>> findNodes(HttpSession httpSession) {
        httpSession.setAttribute("213","312");
        List<SysMenuVo> list = sysMenuService.findNodes();
        return success(list);
    }

    /**
     * 分页查询所有数据
     *
     * @param sysMenu 查询实体
     * @return 所有数据
     */
    @Operation(summary = "分页查询数据" )
    @PostMapping("/page/list")
    public Result pageList(@RequestBody SysMenu sysMenu) {
        startPage();
        return success(getPageInfo(this.sysMenuService.list(new LambdaQueryWrapper<>(sysMenu))));
    }


    /**
     * 查询所有菜单数据
     */
    @Operation(summary = "查询所有菜单数据" )
    @GetMapping("/findAllRoles/{roleId}")
    public Result findAllRoles(@PathVariable(value = "roleId") Long userId) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sysMenuList", sysMenuService.findNodes());
        resultMap.put("roleMenuIds", sysRoleMenuService.findMenuIdByRoleId(userId));
        return success(resultMap);
    }

    /**
     * 分配菜单
     * @param assginMenuDto
     * @return
     */
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginMenuDto assginMenuDto) {
        sysRoleMenuService.doAssign(assginMenuDto) ;
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
        return success(this.sysMenuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysMenu 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@RequestBody SysMenu sysMenu) {
        return success(this.sysMenuService.save(sysMenu));
    }

    /**
     * 修改数据
     *
     * @param sysMenu 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody SysMenu sysMenu) {
        return success(this.sysMenuService.updateById(sysMenu));
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
        return success(this.sysMenuService.removeByIds(idList));
    }

}

