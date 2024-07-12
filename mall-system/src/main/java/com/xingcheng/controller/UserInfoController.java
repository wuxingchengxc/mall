package com.xingcheng.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.UserInfo;
import com.xingcheng.service.UserInfoService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 会员表(UserInfo)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-24 00:19:22
 */
@RestController
@Tag(name = "会员表控制层")
@RequestMapping("/userInfo")
public class UserInfoController extends BaseController<UserInfo> {

    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 分页查询所有数据
     *
     * @param userInfo 查询实体
     * @return 所有数据
     */
    @Operation(summary = "分页查询数据" )
    @PostMapping("/page/list")
    public Result pageList(@RequestBody UserInfo userInfo) {
        startPage();
        return success(getPageInfo(this.userInfoService.list(new QueryWrapper<>(userInfo))));
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
        return success(this.userInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param userInfo 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@RequestBody UserInfo userInfo) {
        return success(this.userInfoService.save(userInfo));
    }

    /**
     * 修改数据
     *
     * @param userInfo 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody UserInfo userInfo) {
        return success(this.userInfoService.updateById(userInfo));
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
        return success(this.userInfoService.removeByIds(idList));
    }
}

