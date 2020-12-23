package com.lliyuu520.haozi.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Datasource
 *
 * @author lliyuu520
 * @since 2020/12/23:15:50
 */
@Data
@ConfigurationProperties("datasource")
public class Datasource {
    /**
     * 数据库名称
     */
    private String name;
}
