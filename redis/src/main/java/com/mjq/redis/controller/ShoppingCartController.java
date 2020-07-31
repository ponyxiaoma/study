package com.mjq.redis.controller;

import com.mjq.common.model.bean.Result;
import com.mjq.redis.dto.ShoppingCartDTO;
import com.mjq.redis.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 购物车
 * @Author: majingqiang
 * @Date: 2019-04-30 17:26
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public Result<Object> add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.addShoppingCart(shoppingCartDTO);
        return Result.successResult(null);
    }
}
