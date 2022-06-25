package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by YuanJW on 2022/5/28.
 */
@SpringBootApplication
@MapperScan("com.test.dao")
@EnableFeignClients
@EnableDiscoveryClient
public class BorrowApplication {
    public static void main(String[] args) {
        SpringApplication.run(BorrowApplication.class, args);
    }
}
