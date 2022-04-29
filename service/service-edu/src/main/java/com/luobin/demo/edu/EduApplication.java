package com.luobin.demo.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Doraemon
 * @date 2022/4/28 3:52 下午
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.luobin"}) // 将 Swagger 里面的配置信息进行扫描，否则 Swagger 里面的配置是无法加载的
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
