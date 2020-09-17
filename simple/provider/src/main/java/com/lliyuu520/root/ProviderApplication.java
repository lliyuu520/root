package com.lliyuu520.root;

import com.lliyuu520.root.utils.StartCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;


/**
 * ProviderApplication
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@SpringCloudApplication
@EnableTransactionManagement
@EnableFeignClients(basePackages = "com.lliyuu520.root.feign")
public class ProviderApplication {


    public static void main(String[] args) {
        new StartCommand(args);
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
