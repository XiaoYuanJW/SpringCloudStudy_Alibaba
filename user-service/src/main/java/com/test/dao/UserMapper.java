package com.test.dao;

import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by YuanJW on 2022/5/29.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user_info where id = #{id}")
    User getUserById(Long id);
}
