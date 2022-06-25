package com.test.service.impl;

import com.test.entity.Book;
import com.test.service.BookService;

/**
 * Created by YuanJW on 2022/6/11.
 */
public class BookFallBackService implements BookService {
    @Override
    public Book getBookById(Long id) {
        return new Book(-1L, "defaultTitle", "drfaultDesc");
    }
}
