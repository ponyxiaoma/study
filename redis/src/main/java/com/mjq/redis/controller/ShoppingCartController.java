package com.mjq.redis.controller;

import com.alibaba.fastjson.JSON;
import com.mjq.common.web.bean.Result;
import com.mjq.redis.dto.ShoppingCartDTO;
import com.mjq.redis.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 购物车
 * @Author: majingqiang
 * @Date: 2019-04-30 17:26
 */
@RestController
@RequestMapping("/shoppingCart")
@Slf4j
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public Result<Object> add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("添加购物车shoppingCartDTO:{}", JSON.toJSONString(shoppingCartDTO));
        shoppingCartService.addShoppingCart(shoppingCartDTO);
        return Result.successResult(null);
    }
}
