package com.mySpring.myapp.sns.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    @Select("SELECT COUNT(*) FROM testdb")
    int save(@Param("name") String name, @Param("age") String age);
}
