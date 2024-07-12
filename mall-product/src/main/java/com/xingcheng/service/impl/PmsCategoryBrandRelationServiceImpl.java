package com.xingcheng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.mapper.PmsCategoryBrandRelationMapper;
import com.xingcheng.domain.PmsCategoryBrandRelation;
import com.xingcheng.service.PmsCategoryBrandRelationService;
import org.springframework.stereotype.Service;

/**
 * 品牌分类关联(PmsCategoryBrandRelation)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-30 13:12:25
 */
@Service("pmsCategoryBrandRelationServiceImpl")
public class PmsCategoryBrandRelationServiceImpl extends ServiceImpl<PmsCategoryBrandRelationMapper, PmsCategoryBrandRelation> implements PmsCategoryBrandRelationService {

}

