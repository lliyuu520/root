package com.lliyuu520.configclient.feign.consumer;

import com.lliyuu520.api.response.AjaxResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "provider", fallbackFactory = ProviderFeignFallbackFactory.class)
public interface ProviderFeign {

    @GetMapping(value = "/provider/test")
    AjaxResult test();
}

@Component
@Slf4j
class ProviderFeignFallbackFactory implements FallbackFactory<ProviderFeign> {

    @Override
    public ProviderFeign create(Throwable throwable) {
        return () -> AjaxResult.errorMail();
    }
}


