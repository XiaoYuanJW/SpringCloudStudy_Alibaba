package com.test.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.test.domain.CommonResult;
import com.test.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 熔断功能测试Controller
 * Created by YuanJW on 2022/6/25.
 */
@RestController
@RequestMapping("/breaker")
public class CircleBreakerController {
    private static final Logger logger = LoggerFactory.getLogger(CircleBreakerController.class);
    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @RequestMapping("/fallback/{uid}")
    @SentinelResource(value = "fallback",fallback = "handleFallback")
    public CommonResult fallback(@PathVariable Long uid) {
        User user = restTemplate.getForObject("http://user-service/user/" + uid, User.class);
        return new CommonResult(user);
    }

    @RequestMapping("/fallbackException/{uid}")
    @SentinelResource(value = "fallbackException", fallback = "handleFallBackException", exceptionsToIgnore = {NullPointerException.class})
    public CommonResult fallbackException(@PathVariable Long uid) {
        if (uid == 1) {
            throw new IndexOutOfBoundsException();
        } else if (uid == 2) {
            throw new NullPointerException();
        }
        return new CommonResult(restTemplate.getForObject(userServiceUrl + "/user/" + uid, User.class));
    }

    public CommonResult handleFallBack(Long uid) {
        User defaultUser = new User(-1L, "defaultUser", null);
        return new CommonResult(defaultUser, "服务降级返回", 200);
    }

    public CommonResult handleFallBackException(Long uid, Throwable e) {
        logger.error("handleFallBackException uid:{},throwable class:{}", uid, e.getClass());
        User defaultUser = new User(-2L, "defaultUser", null);
        return new CommonResult(defaultUser, "服务降级返回", 200);
    }
}
