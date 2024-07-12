package com.xingcheng.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.WmsWareInfo;
import com.xingcheng.service.WmsWareInfoService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 仓库信息(WmsWareInfo)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-05-12 18:35:20
 */
@RestController
@Tag(name = "仓库信息控制层")
@RequestMapping("/wmsWareInfo")
public class WmsWareInfoController extends BaseController<WmsWareInfo> {

    /**
     * 服务对象
     */
    @Resource
    private WmsWareInfoService wmsWareInfoService;

    /**
     * 分页查询所有数据
     *
     * @param wmsWareInfo 查询实体
     * @return 所有数据
     */
    @Operation(summary = "分页查询数据" )
    @PostMapping("/page/list")
    public Result pageList(@RequestBody WmsWareInfo wmsWareInfo) {
        startPage();
        return success(getPageInfo(this.wmsWareInfoService.list(new LambdaQueryWrapper<>(wmsWareInfo))));
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
        return success(this.wmsWareInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param wmsWareInfo 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@RequestBody WmsWareInfo wmsWareInfo) {
        return success(this.wmsWareInfoService.save(wmsWareInfo));
    }

    /**
     * 修改数据
     *
     * @param wmsWareInfo 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody WmsWareInfo wmsWareInfo) {
        return success(this.wmsWareInfoService.updateById(wmsWareInfo));
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
        return success(this.wmsWareInfoService.removeByIds(idList));
    }
}

