package com.xingcheng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingcheng.domain.WmsWareInfo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 仓库信息(WmsWareInfo)表服务接口
 *
 * @author xingcheng.wu
 * @since 2024-05-12 18:35:20
 */
public interface WmsWareInfoService extends IService<WmsWareInfo> {
    public void testWmsInfoSave();

    void testAREQUIREDNEW();

    void testAMANDATORY();
}

