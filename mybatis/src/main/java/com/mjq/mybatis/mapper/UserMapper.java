package com.mjq.mybatis.mapper;

import com.github.pagehelper.Page;
import com.mjq.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Insert("INSERT INTO `user`(`user_name`, `password`, `birthday`) VALUES (#{user.userName}, #{user.password}, #{user.birthday})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "user.id")
    int insert(@Param("user") User user);

    @Select("SELECT * FROM `user`")
    List<User> queryUser();
}
