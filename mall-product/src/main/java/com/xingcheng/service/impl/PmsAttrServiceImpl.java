package com.xingcheng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.mapper.PmsAttrMapper;
import com.xingcheng.domain.PmsAttr;
import com.xingcheng.service.PmsAttrService;
import org.springframework.stereotype.Service;

/**
 * 商品属性(PmsAttr)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-30 18:05:37
 */
@Service("pmsAttrServiceImpl")
public class PmsAttrServiceImpl extends ServiceImpl<PmsAttrMapper, PmsAttr> implements PmsAttrService {

}

