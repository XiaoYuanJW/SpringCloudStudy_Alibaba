package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by YuanJW on 2022/5/29.
 */
@RestController
@RefreshScope
public class UserController {
    @Resource
    UserService userService;
    @Value("${config.info}")
    String info;

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
        logger.info("根据id获取用户信息，用户id为：{}", id);
        return userService.getUserById(id);
    }

    @GetMapping("/configInfo")
    public String getConfigInfo () {
        return info;
    }
}
