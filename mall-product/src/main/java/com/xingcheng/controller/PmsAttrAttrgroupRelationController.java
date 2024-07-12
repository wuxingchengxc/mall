package com.xingcheng.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.PmsAttrAttrgroupRelation;
import com.xingcheng.service.PmsAttrAttrgroupRelationService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 属性&属性分组关联(PmsAttrAttrgroupRelation)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-30 20:33:38
 */
@RestController
@Tag(name = "属性&属性分组关联控制层")
@RequestMapping("/pmsAttrAttrgroupRelation")
public class PmsAttrAttrgroupRelationController extends BaseController<PmsAttrAttrgroupRelation> {

    /**
     * 服务对象
     */
    @Resource
    private PmsAttrAttrgroupRelationService pmsAttrAttrgroupRelationService;

    /**
     * 分页查询所有数据
     *
     * @param pmsAttrAttrgroupRelation 查询实体
     * @return 所有数据
     */
    @Operation(summary = "分页查询数据" )
    @PostMapping("/page/list")
    public Result pageList(@RequestBody PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        startPage();
        return success(getPageInfo(this.pmsAttrAttrgroupRelationService.list(new LambdaQueryWrapper<>(pmsAttrAttrgroupRelation))));
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
        return success(this.pmsAttrAttrgroupRelationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsAttrAttrgroupRelation 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@RequestBody PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        return success(this.pmsAttrAttrgroupRelationService.save(pmsAttrAttrgroupRelation));
    }

    /**
     * 修改数据
     *
     * @param pmsAttrAttrgroupRelation 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        return success(this.pmsAttrAttrgroupRelationService.updateById(pmsAttrAttrgroupRelation));
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
        return success(this.pmsAttrAttrgroupRelationService.removeByIds(idList));
    }


}

