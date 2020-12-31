package com.lliyuu520.haozi;


import com.lliyuu520.haozi.utils.StartUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * hero启动器
 *
 * @author lliyuu520
 */
@SpringCloudApplication
public class HeroApplication {

    public static void main(String[] args) {
        new StartUtil(args);
        SpringApplication.run(HeroApplication.class, args);
    }


}
