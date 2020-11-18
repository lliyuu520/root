package com.lliyuu520.root;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * gateway
 *
 * @author lliyuu520
 */
@SpringCloudApplication
public class AdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
