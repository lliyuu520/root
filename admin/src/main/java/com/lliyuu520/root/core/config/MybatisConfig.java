package com.lliyuu520.root.core.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
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
