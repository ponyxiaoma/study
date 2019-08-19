package com.mjq.mybatis.controller;

import com.mjq.mybatis.mapper.UserMapper;
import com.mjq.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by majingqiang on 2018/11/9.
 */
@RestController
@RequestMapping("/study/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PutMapping("/save")
    public User save() {
        User user = new User();
        user.setUserName("mmm");
        user.setPassword("123456");
        userMapper.insert(user);
        return user;
    }

    @PostMapping("/update")
    public User update() {
        User user = new User();
        user.setId(1045923826636361736L);
        user.setUserName("mjq");
        user.setPassword("123456");
        userMapper.updateByPrimaryKey(user);
        return user;
    }

    @DeleteMapping("/delete")
    public String delete() {
        User user = new User();
        user.setId(1045923826636361736L);
        user.setUserName("mjq");
        user.setPassword("123456");
        userMapper.delete(user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @GetMapping("/getByUser")
    public List<User> getByUser(User user) {
        return userMapper.selectByUser(user);
    }

    @GetMapping("/getOne")
    public User getOne() {
        User user = new User();
        user.setId(1045923826636361734L);
        user = userMapper.selectOne(user);
        return user;
    }
}
