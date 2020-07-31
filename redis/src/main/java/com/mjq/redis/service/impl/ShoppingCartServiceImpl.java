package com.mjq.redis.service.impl;

import com.mjq.common.web.redis.RedisManager;
import com.mjq.redis.dto.ShoppingCartDTO;
import com.mjq.redis.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private RedisManager<ShoppingCartDTO> redisManager;

    private static final String SHOPPING_CART_KEY = "study:shoppingcart:%s";

    @Override
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        String key = String.format(SHOPPING_CART_KEY, shoppingCartDTO.getUserId());
        //redis 中添加购物车商品  k= userId  hk= commodityId   v=quantity
        redisManager.hashIncrement(key, String.valueOf(shoppingCartDTO.getCommodityId()), shoppingCartDTO.getQuantity());
    }
}
