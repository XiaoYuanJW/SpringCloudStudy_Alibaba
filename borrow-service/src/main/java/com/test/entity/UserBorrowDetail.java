package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by YuanJW on 2022/5/29.
 */
@Data
@AllArgsConstructor
public class UserBorrowDetail {
    User user;
    List<Book> books;
}
