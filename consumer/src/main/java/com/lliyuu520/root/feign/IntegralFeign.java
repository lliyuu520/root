package com.lliyuu520.root.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider")
public interface IntegralFeign {

    @PostMapping(value = "/integral/add")
    void addIntegral(@RequestParam("integralId") Long integralId,@RequestParam("frozen") Integer frozen);
}



