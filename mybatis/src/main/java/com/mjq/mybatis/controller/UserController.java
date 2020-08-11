package com.mjq.mybatis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.mjq.common.web.bean.Result;
import com.mjq.mybatis.entity.User;
import com.mjq.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public Result save() {

        User user = new User();
        user.setUserName("mjq");
        user.setBirthday(LocalDateTime.now());
        user.setPassword("1234566");
        userService.save(user);
        return Result.successResult(user);
    }

    @GetMapping("/query")
    public Result queryUser() {
        Page<User> page = new Page<>(1, 10);
        PageInfo<User> pageInfo = userService.queryUser(page);
        return Result.successResult(pageInfo);
    }

}
