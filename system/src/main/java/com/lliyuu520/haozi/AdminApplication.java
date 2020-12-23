package com.lliyuu520.haozi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * gateway
 *
 * @author lliyuu520
 */
@SpringCloudApplication
@EnableTransactionManagement
@MapperScan("com/lliyuu520/haozi/modular/system/mapper")
public class AdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class, args);
    }



}
