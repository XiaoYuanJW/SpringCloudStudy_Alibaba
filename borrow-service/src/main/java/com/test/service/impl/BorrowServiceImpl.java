package com.test.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.test.dao.BorrowMapper;
import com.test.entity.*;
import com.test.service.BookService;
import com.test.service.BorrowService;
import com.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YuanJW on 2022/5/29.
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper borrowMapper;
    @Resource
    UserService userService;
    @Resource
    BookService bookService;

    @Override
    public UserBorrowDetail getBorrowByUser(Long uid) {
        List<Borrow> borrows = borrowMapper.getBorrow(uid,null);
        User user = userService.getUserById(uid);
        List<Book> books = borrows.stream().map(borrow -> bookService.getBookById(borrow.getBid())).collect(Collectors.toList());
        return new UserBorrowDetail(user, books);
    }

    @SentinelResource(value = "getBorrowByBook", blockHandler = "handlerExceptionByMethod")/*开启方法限流监控*/
    @Override
    public BookBorrowDetail getBorrowByBook(Long bid) {
        List<Borrow> borrows = borrowMapper.getBorrow(null,bid);
        List<User> users = borrows.stream().map(borrow -> userService.getUserById(borrow.getUid())).collect(Collectors.toList());
        Book book = bookService.getBookById(bid);
        return new BookBorrowDetail(users, book);
    }

    @Override
    public BorrowDetail  getBorrow(Long uid, Long bid) {
        List<Borrow> borrows = borrowMapper.getBorrow(uid, bid);
        List<User> users = borrows.stream().map(borrow -> userService.getUserById(borrow.getUid())).collect(Collectors.toList());
        List<Book> books = borrows.stream().map(borrow -> bookService.getBookById(borrow.getBid())).collect(Collectors.toList());
        return new BorrowDetail(users, books);
    }

    public BookBorrowDetail handlerExceptionByMethod(Long bid , BlockException exception){
        return new BookBorrowDetail(Collections.emptyList(), null);
    }
}
