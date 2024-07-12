package com.xingcheng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.domain.WmsWareSku;
import com.xingcheng.mapper.WmsWareInfoMapper;
import com.xingcheng.domain.WmsWareInfo;
import com.xingcheng.service.WmsWareInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 仓库信息(WmsWareInfo)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-05-12 18:35:20
 */
@Service("wmsWareInfoServiceImpl")
public class WmsWareInfoServiceImpl extends ServiceImpl<WmsWareInfoMapper, WmsWareInfo> implements WmsWareInfoService {
    static WmsWareInfo wmsWareInfo;
    static WmsWareSku wmsWareSku;
    static {
        wmsWareInfo = new WmsWareInfo();
        wmsWareInfo.setAddress("123");
        wmsWareInfo.setAreacode("12412");
        wmsWareInfo.setName("哈哈哈");
        wmsWareSku = new WmsWareSku();
        wmsWareSku.setSkuName("名称哈哈");
        wmsWareSku.setStock(11);

    }
    @Override
    public void testWmsInfoSave() {
        save(wmsWareInfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void testAREQUIREDNEW() {
        save(wmsWareInfo);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public void testAMANDATORY() {
        save(wmsWareInfo);
    }
}

