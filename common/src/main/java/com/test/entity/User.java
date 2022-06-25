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
public class User {
    Long id;
    String name;
    String sex;
}
