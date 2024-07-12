package com.xingcheng.controller;



import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.PmsAttrGroup;
import com.xingcheng.dto.PmsAttrGroupDTO;
import com.xingcheng.service.PmsAttrGroupService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 属性分组(PmsAttrGroup)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-28 22:18:18
 */
@RestController
@Tag(name = "属性分组控制层")
@RequestMapping("/pmsAttrGroup")
public class PmsAttrGroupController extends BaseController<PmsAttrGroup> {

    /**
     * 服务对象
     */
    @Resource
    private PmsAttrGroupService pmsAttrGroupService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @Operation(summary = "分页查询数据" )
    @PostMapping("/page/list")
    public Result pageList(@Valid @RequestBody PmsAttrGroupDTO pmsAttrGroupDTO) {
        startPage();
        LambdaQueryWrapper<PmsAttrGroup> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(PmsAttrGroup::getCatelogId,pmsAttrGroupDTO.getCatelogId());
        if (StrUtil.isNotBlank(pmsAttrGroupDTO.getSearchKey())) {
            lambdaQueryWrapper.eq(PmsAttrGroup::getAttrGroupId, pmsAttrGroupDTO.getSearchKey())
                    .or().like(PmsAttrGroup::getAttrGroupName,pmsAttrGroupDTO.getSearchKey());
        }
        return success(getPageInfo(this.pmsAttrGroupService.list(lambdaQueryWrapper)));
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
        return success(this.pmsAttrGroupService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsAttrGroup 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@Valid @RequestBody PmsAttrGroup pmsAttrGroup) {
        return success(this.pmsAttrGroupService.save(pmsAttrGroup));
    }

    /**
     * 修改数据
     *
     * @param pmsAttrGroup 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody PmsAttrGroup pmsAttrGroup) {
        return success(this.pmsAttrGroupService.updateById(pmsAttrGroup));
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
        return success(this.pmsAttrGroupService.removeByIds(idList));
    }
}

