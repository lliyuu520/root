package com.lliyuu520.haozi;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动器
 *
 * @author lliyuu520
 * @create 2018/1/22
 */

@SpringCloudApplication
@EnableFeignClients(basePackages = "com.lliyuu520.haozi.**.feign")
public class SeataAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication.class, args);
    }

}
