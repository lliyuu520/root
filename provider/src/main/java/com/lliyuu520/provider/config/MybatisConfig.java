package com.lliyuu520.provider.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * mybatis 配置
 * @author liliangyu
 * @date 2019/6/20
 */
@Configuration
//@EnableTransactionManagement
@MapperScan("com.lliyuu520.provider.modular.**.mapper")
public class MybatisConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
