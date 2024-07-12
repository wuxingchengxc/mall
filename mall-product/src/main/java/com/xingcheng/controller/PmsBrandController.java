package com.xingcheng.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.PmsBrand;
import com.xingcheng.service.PmsBrandService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 品牌(PmsBrand)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-28 19:43:18
 */
@RestController
@Tag(name = "品牌控制层")
@RequestMapping("/pmsBrand")
public class PmsBrandController extends BaseController<PmsBrand> {

    /**
     * 服务对象
     */
    @Resource
    private PmsBrandService pmsBrandService;

    /**
     * 分页查询所有数据
     *
     * @param pmsBrand 查询实体
     * @return 所有数据
     */
    @Operation(summary = "分页查询数据" )
    @PostMapping("/page/list")
    public Result pageList(HttpSession httpSession) {
        startPage();
        httpSession.getAttribute("213");
        return success(getPageInfo(this.pmsBrandService.list(new LambdaQueryWrapper<>())));
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
        return success(this.pmsBrandService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pmsBrand 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据" )
    @PostMapping("/insert")
    public Result insert(@RequestBody PmsBrand pmsBrand) {
        return success(this.pmsBrandService.save(pmsBrand));
    }

    /**
     * 修改数据
     *
     * @param pmsBrand 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据" )
    @PutMapping("/update")
    public Result update(@RequestBody PmsBrand pmsBrand) {
        return success(this.pmsBrandService.updateById(pmsBrand));
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
        return success(this.pmsBrandService.removeByIds(idList));
    }
}

