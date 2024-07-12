package com.xingcheng.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.PmsCategory;
import com.xingcheng.service.PmsCategoryService;
import com.xingcheng.vo.PmsCategoryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

import java.io.Serializable;
import java.util.List;

/**
 * 商品三级分类(PmsCategory)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-19 01:33:50
 */
@RestController
@RequestMapping("/pmsCategory")
@Tag(name = " 商品三级分类表控制层")
public class PmsCategoryController extends BaseController<PmsCategory> {

    /**
     * 服务对象
     */
    @Resource
    private PmsCategoryService pmsCategoryService;

    /**
     * 获取所有分类列表
     */
    @Operation(summary = "获取所有分类列表" )
    @GetMapping("/all/category")
    public Result<List<PmsCategoryVO>> selectAllCategory() {
        List<PmsCategoryVO> pmsCategoryVOS = pmsCategoryService.selectAllCategory();
        return success(pmsCategoryVOS);
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param pmsCategory 查询实体
     * @return 所有数据
     */
    @Operation(summary = "分页查询所有数据" )
    @GetMapping("/all/list")
    public Result selectAll(Page<PmsCategory> page, PmsCategory pmsCategory) {
        return success(this.pmsCategoryService.page(page, new QueryWrapper<>(pmsCategory)));
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
        return success(this.pmsCategoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsCategory 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@RequestBody PmsCategory pmsCategory) {
        return success(this.pmsCategoryService.save(pmsCategory));
    }

    /**
     * 修改数据
     *
     * @param pmsCategory 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody PmsCategory pmsCategory) {
        return success(this.pmsCategoryService.updateById(pmsCategory));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @Operation(summary = "删除结果" )
    @DeleteMapping("/delete")
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pmsCategoryService.removeByIds(idList));
    }
}

