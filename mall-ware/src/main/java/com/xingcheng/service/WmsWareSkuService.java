package com.xingcheng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingcheng.domain.WmsWareSku;

import java.io.IOException;

/**
 * 商品库存(WmsWareSku)表服务接口
 *
 * @author xingcheng.wu
 * @since 2024-04-20 18:48:54
 */
public interface WmsWareSkuService extends IService<WmsWareSku> {

    public void testAREQUIRED();
    void testAREQUIREDNEW() ;

    void testAMANDATORY() ;



}

