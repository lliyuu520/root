package com.lliyuu520.root.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * IntegralFeign
 * @author lliyuu520*/
@FeignClient(value = "provider")
public interface ProviderIntegralFeign {
    /**
     * 加积分
     * @param integralId
     * @param frozen
     */
    @PostMapping(value = "/provider-integral/add")
    void addIntegral(@RequestParam("integralId") Long integralId,@RequestParam("frozen") Integer frozen);
}



