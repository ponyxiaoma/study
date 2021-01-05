package com.mjq.mybatis.mapper;

import com.mjq.mybatis.base.BaseMapper;
import com.mjq.mybatis.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM `user`")
    List<User> queryUser();
}
