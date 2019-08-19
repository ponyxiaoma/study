package com.mjq.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: majingqiang
 * @Date: 2019-04-30 17:26
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Data
    public class Test {

        @JsonSerialize(using = BigDecimalJsonSerialize.class)
        private BigDecimal money;
    }


    @GetMapping("/bigDecimal")
    public Object test() {
        Test t = new Test();
        t.setMoney(BigDecimal.valueOf(123.154));
        return t;
    }
}
