package com.xingcheng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.convert.PmsCategoryConvert;
import com.xingcheng.mapper.PmsCategoryMapper;
import com.xingcheng.domain.PmsCategory;
import com.xingcheng.service.PmsCategoryService;
import com.xingcheng.vo.PmsCategoryVO;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品三级分类(PmsCategory)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-19 01:33:53
 */
@Service("pmsCategoryServiceImpl")
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryMapper, PmsCategory> implements PmsCategoryService {

    @Override
    public List<PmsCategoryVO> selectAllCategory() {
        // 先查询第一级
        List<PmsCategory> list = list();
        List<PmsCategoryVO> pmsCategoryVOS = PmsCategoryConvert.INSTANCT.converListObject(list);
        return pmsCategoryVOS.stream().filter(i -> i.getParentCid().equals(0L)).map(root -> {
            root.setChildren(getChildren(pmsCategoryVOS, root));
            return root; // 转换
        }).sorted(Comparator.comparingInt(PmsCategoryVO::getSort)).collect(Collectors.toList());

    }

    private List<PmsCategoryVO> getChildren (List<PmsCategoryVO> allList , PmsCategoryVO pmsCategory) {
        return allList.stream().filter(root -> root.getParentCid().equals(pmsCategory.getCatId()))
                .map(item -> {
                    item.setChildren(getChildren(allList, item));
                    return item;
                })
                .collect(Collectors.toList());
    }



}

