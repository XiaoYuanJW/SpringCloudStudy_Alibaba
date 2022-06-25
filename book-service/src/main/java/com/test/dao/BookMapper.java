package com.test.dao;

import com.test.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**id
 * Created by YuanJW on 2022/5/29.
 */
@Mapper
public interface BookMapper {
    @Select("select * from book_info where id = #{id}")
    Book getBookById(Long id);
}
