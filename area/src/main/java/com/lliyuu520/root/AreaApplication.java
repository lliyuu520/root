package com.lliyuu520.root;


import com.lliyuu520.root.utils.StartCommand;
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
@MapperScan("com/lliyuu520/root/modular/**/mapper")
public class AreaApplication {

    public static void main(String[] args) {
        new StartCommand(args);
        SpringApplication.run(AreaApplication.class, args);
    }


}
