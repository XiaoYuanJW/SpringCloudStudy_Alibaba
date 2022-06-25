package com.test.service;

import com.test.entity.BookBorrowDetail;
import com.test.entity.BorrowDetail;
import com.test.entity.UserBorrowDetail;

/**
 * Created by YuanJW on 2022/5/29.
 */
public interface BorrowService {
    UserBorrowDetail getBorrowByUser(Long uid);

    BookBorrowDetail getBorrowByBook(Long bid);

    BorrowDetail getBorrow(Long uid, Long bid);
}
