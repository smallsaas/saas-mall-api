package com.jfeat.am.module.product.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
        basePackages = {"com.jfeat.**.dao", "com.jfeat.**.mapper"}
)
public class MybatisConfig {
    public MybatisConfig() {
    }
}
