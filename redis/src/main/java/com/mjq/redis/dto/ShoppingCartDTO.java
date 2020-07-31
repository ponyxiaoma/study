package com.mjq.redis.dto;

import lombok.Data;

@Data
public class ShoppingCartDTO {

    private Long userId;

    private Long commodityId;

    private Long quantity;
}
