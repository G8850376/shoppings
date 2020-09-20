package com.mapper;

import com.pojo.Commodity;
import com.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users")
    List<Users> getUser();

    @Select("SELECT * FROM commodity")
    List<Commodity> getCom();

    @Insert("INSERT INTO users (name,password) VALUES (#{name},#{password})")
    Integer add(Users us);


}
