package com.lliyuu520.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * 文件上传服务
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.lliyuu520.root.feign")
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableTransactionManagement
public class ProviderApplication {



    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    /**
     * 支持Ribbon负载均衡
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }
}
