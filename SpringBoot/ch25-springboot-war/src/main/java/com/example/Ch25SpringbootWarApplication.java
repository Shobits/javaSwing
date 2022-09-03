package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * SpringBootServletInitializer 要继承这个类，才能使用独立的 tomcat 服务器
 */
@SpringBootApplication
public class Ch25SpringbootWarApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Ch25SpringbootWarApplication.class, args);
    }

    /**
     * 使用独立的 tomcat 需要加这一段
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Ch25SpringbootWarApplication.class);
    }
}
