package com.luobin.demo.edu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Doraemon
 * @date 2022/4/28 3:54 下午
 * @version 1.0
 */
@Configuration
@MapperScan("com.luobin.demo.edu.mapper") // 扫描 mybatis 的mapper 文件
public class EduConfig {

    /**
     * 逻辑删除的插件
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
