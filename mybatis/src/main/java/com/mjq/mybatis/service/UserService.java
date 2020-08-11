package com.mjq.mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.mjq.mybatis.entity.User;

public interface UserService {

    int save(User user);

    PageInfo<User> queryUser(Page<User> page);
}
