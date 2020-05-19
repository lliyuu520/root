package com.lliyuu520.consumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lliyuu520
 * @date 2020/5/2022:45
 */
@ConfigurationProperties("spring.datasource")
@Component
@Data
public class DataSourceProperties {
    private String driveClassName;
    private String url;
    private String username;
    private String password;

}
