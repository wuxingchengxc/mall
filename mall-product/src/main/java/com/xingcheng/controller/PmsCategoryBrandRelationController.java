package com.xingcheng.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingcheng.domain.PmsCategory;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.PmsCategoryBrandRelation;
import com.xingcheng.service.PmsCategoryBrandRelationService;
import com.xingcheng.service.PmsCategoryService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 品牌分类关联(PmsCategoryBrandRelation)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-30 13:12:25
 */
@RestController
@Tag(name = "品牌分类关联控制层")
@RequestMapping("/pmsCategoryBrandRelation")
public class PmsCategoryBrandRelationController extends BaseController<PmsCategoryBrandRelation> {

    /**
     * 服务对象
     */
    @Resource
    private PmsCategoryBrandRelationService pmsCategoryBrandRelationService;

    @Resource
    private PmsCategoryService pmsCategoryService;

    /**
     * 分页查询所有数据
     *
     * @param pmsCategoryBrandRelation 查询实体
     * @return 所有数据
     */
    @Operation(summary = "分页查询数据" )
    @PostMapping("/page/list")
    public Result pageList(@RequestBody PmsCategoryBrandRelation pmsCategoryBrandRelation) {
        startPage();
        return success(getPageInfo(this.pmsCategoryBrandRelationService.list(new LambdaQueryWrapper<>(pmsCategoryBrandRelation))));
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
        return success(this.pmsCategoryBrandRelationService.getById(id));
    }

    /**
     * 通过品牌id查询关联数据
     *
     * @return 集合数据
     */
    @Operation(summary = "通过主键查询集合数据" )
    @GetMapping("/brandId/list/{brandId}")
    public Result selectByBrandId(@PathVariable("brandId") Serializable brandId) {
        LambdaQueryWrapper<PmsCategoryBrandRelation> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(PmsCategoryBrandRelation::getBrandId, brandId);
        return success(this.pmsCategoryBrandRelationService.list(lambdaQueryWrapper));
    }

    /**
     * 新增数据
     *
     * @param pmsCategoryBrandRelation 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@RequestBody PmsCategoryBrandRelation pmsCategoryBrandRelation) {
        pmsCategoryBrandRelation.setCatelogName(pmsCategoryService.getById(pmsCategoryBrandRelation.getCatelogId()).getName());
        return success(this.pmsCategoryBrandRelationService.save(pmsCategoryBrandRelation));
    }

    /**
     * 修改数据
     *
     * @param pmsCategoryBrandRelation 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody PmsCategoryBrandRelation pmsCategoryBrandRelation) {
        return success(this.pmsCategoryBrandRelationService.updateById(pmsCategoryBrandRelation));
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
        return success(this.pmsCategoryBrandRelationService.removeByIds(idList));
    }
}

