package com.xingcheng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.mapper.PmsBrandMapper;
import com.xingcheng.domain.PmsBrand;
import com.xingcheng.service.PmsBrandService;
import org.springframework.stereotype.Service;

/**
 * 品牌(PmsBrand)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-28 19:43:18
 */
@Service("pmsBrandServiceImpl")
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {

}

