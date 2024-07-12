package com.xingcheng.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.WmsWareSku;
import com.xingcheng.service.WmsWareSkuService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品库存(WmsWareSku)表控制层
 *
 * @author xingcheng.wu
 * @since 2024-04-20 18:48:53
 */
@RestController
@RequestMapping("/wmsWareSku")
public class WmsWareSkuController extends BaseController<WmsWareSku> {

    /**
     * 服务对象
     */
    @Resource
    private WmsWareSkuService wmsWareSkuService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param wmsWareSku 查询实体
     * @return 所有数据
     */
    @GetMapping("/all/list")
    public Result selectAll(Page<WmsWareSku> page, WmsWareSku wmsWareSku) {
        return success(this.wmsWareSkuService.page(page, new QueryWrapper<>(wmsWareSku)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/list/{id}")
    public Result selectOne(@PathVariable("id") Serializable id) {
        return success(this.wmsWareSkuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param wmsWareSku 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody WmsWareSku wmsWareSku) {
        return success(this.wmsWareSkuService.save(wmsWareSku));
    }

    /**
     * 修改数据
     *
     * @param wmsWareSku 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public Result update(@RequestBody WmsWareSku wmsWareSku) {
        return success(this.wmsWareSkuService.updateById(wmsWareSku));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return success(this.wmsWareSkuService.removeByIds(idList));
    }



    @GetMapping("/test")
    public Result test() {
        this.wmsWareSkuService.testAMANDATORY();
        return success();
    }

    @GetMapping("/select")
    public Result select() {
//        List<WmsWareSku> list = this.wmsWareSkuService.list();
        return success();
    }

}

