package com.lliyuu520.root.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lliyuu520
 * @date 2020/9/2223:08
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.lliyuu520.root.modular.**.mapper")
public class MybatisConfig {

}
