package com.test.service;

import com.test.entity.Book;
import com.test.service.impl.BookFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YuanJW on 2022/6/11.
 */
@FeignClient(value = "book-service", fallback = BookFallBackService.class)
public interface BookService {
    @RequestMapping("/book/{id}")
    Book getBookById(@PathVariable("id") Long id);
}
