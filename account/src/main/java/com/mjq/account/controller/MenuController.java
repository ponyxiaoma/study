package com.mjq.account.controller;

import com.mjq.account.entity.Menu;
import com.mjq.account.service.MenuService;
import com.mjq.common.web.bean.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/save")
    public Result<Object> save(@RequestBody Menu menu) {
        menu = menuService.save(menu);
        return Result.successResult(menu);
    }

    @PostMapping("/saveBatch")
    public Result<Object> saveBatch(@RequestBody Menu menu) {
        List<Menu> list = new ArrayList<>();
        list.add(menu);
        Menu menu1 = new Menu();
        BeanUtils.copyProperties(menu, menu1);
        list.add(menu1);
        menuService.saveBatch(list);
        return Result.successResult(list);
    }

    @PostMapping("/update")
    public Result<Object> update(@RequestBody Menu menu) {
        menu = menuService.update(menu);
        return Result.successResult(menu);
    }
}
