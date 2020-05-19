package com.lliyuu520.consumer.feign.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider")
public interface IntegralFeign {

    @GetMapping(value = "/integral/add")
    void add(@RequestParam("integralId") Long integralId,@RequestParam("score") Integer score);
}



