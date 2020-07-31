package com.mjq.redis.service;

import com.mjq.redis.dto.ShoppingCartDTO;

public interface ShoppingCartService {

    /**
     * 添加购物车
     *
     * @param shoppingCartDTO 购物车
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
