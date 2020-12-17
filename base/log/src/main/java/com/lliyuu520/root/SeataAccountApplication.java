package com.lliyuu520.root;

import com.lliyuu520.root.utils.StartCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 启动器
 *
 * @author lliyuu520
 * @create 2018/1/22
 */

@SpringCloudApplication
@EnableFeignClients(basePackages = "com.lliyuu520.root.feign")
public class SeataAccountApplication {

    public static void main(String[] args) {
        new StartCommand(args);
        SpringApplication.run(SeataAccountApplication.class, args);
    }

}
