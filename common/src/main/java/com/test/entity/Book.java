package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by YuanJW on 2022/5/29.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    Long id;
    String title;
    String desc;
}
