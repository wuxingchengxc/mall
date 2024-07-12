package com.xingcheng.endpoint;

import com.xingcheng.domain.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

@FeignClient(value = "mall-wms", contextId = "contextId")
public interface WareTestEndpoint {

    @GetMapping("/wmsWareSku/list/{id}")
    public Result selectOne(@PathVariable("id") Serializable id);

}
