package com.mySpring.myapp.sns.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO testdb(test_data, test_dates) values (#{name}, #{age})")
    void save(@Param("name") String name, @Param("age") String age);
}
