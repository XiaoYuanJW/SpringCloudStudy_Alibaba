package com.test.service.impl;

import com.test.dao.BookMapper;
import com.test.entity.Book;
import com.test.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by YuanJW on 2022/5/29.
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public Book getBookById(Long id) {
        return bookMapper.getBookById(id);
    }
}
