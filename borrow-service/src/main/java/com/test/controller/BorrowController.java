package com.test.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.test.entity.*;
import com.test.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by YuanJW on 2022/5/29.
 */
@RestController
public class BorrowController {
    @Resource
    BorrowService borrowService;

    @RequestMapping("/borrow/user/{uid}")
    public UserBorrowDetail getBorrowByUser(@PathVariable("uid") Long uid){
        return borrowService.getBorrowByUser(uid);
    }

    @RequestMapping("/borrow/book/{bid}")
    public BookBorrowDetail getBorrowByBook(@PathVariable("bid") Long bid){
        return borrowService.getBorrowByBook(bid);
    }

    @RequestMapping("/borrow")
    public BorrowDetail getBorrow(@RequestParam(value = "uid", required = true) Long uid,
                                  @RequestParam(value = "bid", required = true) Long bid){
        return borrowService.getBorrow(uid, bid);
    }

    /**
     * 热点参数限流测试
     */
    @RequestMapping("/param")
    @SentinelResource("param")
    public String getParam(@RequestParam(value = "param1", required = false) String param1,
                           @RequestParam(value = "param2", required = false) String param2) {
        return "param1:" + param1 + ",param2:" + param2;
    }
}
