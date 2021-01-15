package com.lliyuu520.haozi;

import com.lliyuu520.haozi.utils.StartCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 文件上传服务
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.lliyuu520.haozi.feign")
public class SeataOrderApplication {

    public static void main(String[] args) {
        new StartCommand(args);
        SpringApplication.run(SeataOrderApplication.class, args);
    }

}
