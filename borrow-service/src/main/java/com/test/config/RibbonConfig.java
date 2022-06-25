package com.test.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate注册配置类
 * Created by YuanJW on 2022/6/25.
 */
@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced
    @SentinelRestTemplate/*使用@SentinelRestTemplate包装RestTemplate实例*/
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
