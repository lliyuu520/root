package com.lliyuu520.root.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件
 *
 * @author liliangyu
 * @date 2019-08-05
 */
@Component
@ConfigurationProperties("xlyy")
@Data
public class XlyyProperties {
    /**
     * 默认密码
     */
    private String defaultPassword="123456";


    /**
     * JWT过期时间
     */
    private Long jwtExpirationTime=432000000L;


    /**
     * JWT密钥
     */
    private String jwtSecret = "QPg&1#45WnWt";
}
