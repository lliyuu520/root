package com.lliyuu520.haozi;

import com.lliyuu520.haozi.utils.StartCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 仓库启动器
 *
 * @author lliyuu520
 * @create 2018/1/22
 */

@EnableFeignClients(basePackages = "com.lliyuu520.haozi.feign")
@SpringCloudApplication
public class SeataStockApplication {

    public static void main(String[] args) {
        new StartCommand(args);
        SpringApplication.run(SeataStockApplication.class, args);
    }

}
