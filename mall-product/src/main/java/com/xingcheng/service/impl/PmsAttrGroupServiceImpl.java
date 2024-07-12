package com.xingcheng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.mapper.PmsAttrGroupMapper;
import com.xingcheng.domain.PmsAttrGroup;
import com.xingcheng.service.PmsAttrGroupService;
import org.springframework.stereotype.Service;

/**
 * 属性分组(PmsAttrGroup)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-28 22:18:18
 */
@Service("pmsAttrGroupServiceImpl")
public class PmsAttrGroupServiceImpl extends ServiceImpl<PmsAttrGroupMapper, PmsAttrGroup> implements PmsAttrGroupService {

}

