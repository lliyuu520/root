package com.lliyuu520.consumer.feign.consumer;

import com.lliyuu520.api.response.AjaxResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "provider")
public interface ProviderFeign {

    @GetMapping(value = "/provider/test")
    AjaxResult test();
}



