package com.lliyuu520.root.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * FeignConfiguration
 *
 * @author lliyuu520
 * @since 2020/9/1717:11
 */
@Configuration
public class FeignConfiguration implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {

        requestTemplate.header("xxx", "xxxx");
    }
}
