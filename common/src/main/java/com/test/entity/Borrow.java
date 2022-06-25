package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by YuanJW on 2022/5/29.
 */
@Data
@AllArgsConstructor
public class Borrow {
    Long id;
    Long uid;
    Long bid;
}
