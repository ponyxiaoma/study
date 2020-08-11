package com.mjq.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.mjq.mybatis.entity.User;
import com.mjq.mybatis.mapper.UserMapper;
import com.mjq.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public PageInfo<User> queryUser(Page<User> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<User> list = userMapper.queryUser();
        return new PageInfo<>(list);

    }
}
