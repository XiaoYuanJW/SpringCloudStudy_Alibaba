package com.test.dao;

import com.test.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by YuanJW on 2022/5/29.
 */
@Mapper
public interface BorrowMapper {
    List<Borrow> getBorrow(Long uid, Long bid);
}
