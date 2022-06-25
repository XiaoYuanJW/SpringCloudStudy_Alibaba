package com.test.service.impl;

import com.test.dao.UserMapper;
import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by YuanJW on 2022/5/29.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }
}
