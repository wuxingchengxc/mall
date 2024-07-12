package com.xingcheng.controller;



import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingcheng.domain.PmsAttrAttrgroupRelation;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.PmsAttr;
import com.xingcheng.dto.PmsAttrDTO;
import com.xingcheng.dto.PmsAttrSearchDTO;
import com.xingcheng.service.PmsAttrAttrgroupRelationService;
import com.xingcheng.service.PmsAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品属性(PmsAttr)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-30 18:05:37
 */
@RestController
@Tag(name = "商品属性控制层")
@RequestMapping("/pmsAttr")
public class PmsAttrController extends BaseController<PmsAttr> {

    /**
     * 服务对象
     */
    @Autowired
    private PmsAttrService pmsAttrService;

    @Resource
    private PmsAttrAttrgroupRelationService pmsAttrAttrgroupRelationService;
    /**
     * 分页查询所有数据
     *
     * @param pmsAttr 查询实体
     * @return 所有数据
     */
    @Operation(summary = "分页查询数据" )
    @PostMapping("/page/list")
    public Result pageList(@RequestBody PmsAttrSearchDTO pmsAttr) {
        startPage();
        LambdaQueryWrapper<PmsAttr> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(PmsAttr::getCatelogId,pmsAttr.getCatelogId());
        if (StrUtil.isNotBlank(pmsAttr.getSearchKey())) {
            lambdaQueryWrapper.eq(PmsAttr::getAttrName, pmsAttr.getSearchKey());
        }
        return success(getPageInfo(this.pmsAttrService.list(lambdaQueryWrapper)));
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
        return success(this.pmsAttrService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsAttr 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@RequestBody PmsAttrDTO pmsAttrDTO) {
        PmsAttr pmsAttr = new PmsAttr();
        BeanUtil.copyProperties(pmsAttrDTO, pmsAttr);
        this.pmsAttrService.save(pmsAttr);
        PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation = new PmsAttrAttrgroupRelation();
        pmsAttrAttrgroupRelation.setAttrId(pmsAttr.getAttrId());
        pmsAttrAttrgroupRelation.setAttrGroupId(pmsAttrDTO.getAttrGroupId());
        pmsAttrAttrgroupRelationService.save(pmsAttrAttrgroupRelation);

        return success();
    }

    /**
     * 修改数据
     *
     * @param pmsAttr 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody PmsAttr pmsAttr) {
        return success(this.pmsAttrService.updateById(pmsAttr));
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
        return success(this.pmsAttrService.removeByIds(idList));
    }
}

