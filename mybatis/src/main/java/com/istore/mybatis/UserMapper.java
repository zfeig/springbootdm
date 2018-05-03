package com.istore.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface  UserMapper {
    @Select("select * from user where name = #{name}")
    List<User> findByName(String name);

    @Select("select * from user where id= #{id} limit 1")
    User findById(int id);
}
