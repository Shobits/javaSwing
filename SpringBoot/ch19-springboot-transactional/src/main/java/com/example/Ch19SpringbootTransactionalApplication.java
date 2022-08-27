package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @EnableTransactionManagement: 启用事务管理器
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.example.dao")
public class Ch19SpringbootTransactionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch19SpringbootTransactionalApplication.class, args);
    }

}
