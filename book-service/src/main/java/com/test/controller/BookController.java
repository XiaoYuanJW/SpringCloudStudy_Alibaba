package com.test.controller;

import com.test.entity.Book;
import com.test.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by YuanJW on 2022/5/29.
 */
@RestController
public class BookController {
    @Resource
    BookService bookService;

    public static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @RequestMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        logger.info("根据id获取书籍信息，书籍id为：{}", id);
        return bookService.getBookById(id);
    }
}
