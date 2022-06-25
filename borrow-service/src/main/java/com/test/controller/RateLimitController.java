package com.test.controller;

import com.test.domain.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义限流处理Controller
 * Created by YuanJW on 2022/6/24.
 */
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {
    /**
     * 自定义通用的限流处理逻辑
     */
    @GetMapping("/customBlockHandler")
    public CommonResult blockHandler() {
        return new CommonResult("限流成功", 200);
    }
}
