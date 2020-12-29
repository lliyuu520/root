package com.lliyuu520.haozi;


import com.lliyuu520.haozi.util.ApiUtil;
import com.lliyuu520.haozi.utils.StartUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * gateway
 *
 * @author lliyuu520
 */
@SpringCloudApplication
public class AreaApplication {

    public static void main(String[] args) {
        new StartUtil(args);

        final ConfigurableApplicationContext run = SpringApplication.run(AreaApplication.class, args);
        final String applicationName = run.getApplicationName();
        ApiUtil.initApDoc(applicationName);
    }


}
