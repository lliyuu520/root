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
 * 仓库启动器
 *
 * @author lliyuu520
 * @create 2018/1/22
 */

@EnableFeignClients(basePackages = "com.lliyuu520.root.feign")
@EnableCircuitBreaker
@EnableTransactionManagement
@SpringBootApplication
@EnableDiscoveryClient
public class SeataStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStockApplication.class, args);
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
