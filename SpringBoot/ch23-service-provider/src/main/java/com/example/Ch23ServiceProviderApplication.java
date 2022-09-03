package com.example;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @EnableDubbo 启用 dubbo 配置
 * @EnableDubboConfig 这个也可以，只是上面的包含这个
 * @DubboComponentScan
 */
@SpringBootApplication
@EnableDubbo
public class Ch23ServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch23ServiceProviderApplication.class, args);
    }

}
