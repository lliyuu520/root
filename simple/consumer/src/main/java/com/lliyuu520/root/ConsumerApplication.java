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
 * 启动器
 *
 * @author lliyuu520
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.lliyuu520.root.feign")
@EnableTransactionManagement
public class ConsumerApplication {

    public static void main(String[] args) {
        new StartCommand(args);

        SpringApplication.run(ConsumerApplication.class, args);
    }

    /**
     * 支持ribbon
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }


}
