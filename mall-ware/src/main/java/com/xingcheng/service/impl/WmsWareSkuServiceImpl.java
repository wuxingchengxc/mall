package com.xingcheng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.domain.WmsWareInfo;
import com.xingcheng.mapper.WmsWareSkuMapper;
import com.xingcheng.domain.WmsWareSku;
import com.xingcheng.service.WmsWareInfoService;
import com.xingcheng.service.WmsWareSkuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * 商品库存(WmsWareSku)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-20 18:48:55
 */
@Service("wmsWareSkuServiceImpl")
public class WmsWareSkuServiceImpl extends ServiceImpl<WmsWareSkuMapper, WmsWareSku> implements WmsWareSkuService {


    @Override
    public void testAREQUIRED() {

    }

    @Override
    public void testAREQUIREDNEW() {

    }

    public void testAMANDATORY() {
//        wmsWareInfoService.testAMANDATORY();
        WmsWareSku wmsWareSku = new WmsWareSku();
        wmsWareSku.setSkuName("名称哈哈");
        wmsWareSku.setStock(11);
        save(wmsWareSku);
    }



}

