package com.test.service;

import com.test.entity.User;
import com.test.service.impl.UserFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YuanJW on 2022/6/11.
 */
@FeignClient(value = "user-service", fallback = UserFallBackService.class)
public interface UserService {
    @RequestMapping("/user/{id}")
    User getUserById(@PathVariable("id") Long id);
}
