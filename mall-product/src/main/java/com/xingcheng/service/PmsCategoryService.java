package com.xingcheng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingcheng.domain.PmsCategory;
import com.xingcheng.vo.PmsCategoryVO;

import java.util.List;

/**
 * 商品三级分类(PmsCategory)表服务接口
 *
 * @author xingcheng.wu
 * @since 2024-04-19 01:33:52
 */
public interface PmsCategoryService extends IService<PmsCategory> {

    List<PmsCategoryVO> selectAllCategory();
}

