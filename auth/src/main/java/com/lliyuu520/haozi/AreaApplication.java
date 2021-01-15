package com.lliyuu520.haozi;


import com.lliyuu520.haozi.utils.StartUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * gateway
 *
 * @author lliyuu520
 */
@SpringCloudApplication
public class AreaApplication {

    public static void main(String[] args) {
        new StartUtil(args);
        SpringApplication.run(AreaApplication.class, args);
    }


}
