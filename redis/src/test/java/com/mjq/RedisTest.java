package com.mjq;

import com.mjq.redis.RedisManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: majingqiang
 * @Date: 2019-04-25 16:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisManager redisManager;


    @Test
    public void save() {
        redisManager.hashPut("a", "b", "c");
    }

    @Test
    public void getForHash() {
        Object v = redisManager.hashGet("a", "b");
        System.out.println(v);
    }

    @Test
    public void rightPush() {
        redisManager.listRightPush("c", "b");
        redisManager.listRightPush("c", "b");
    }

    @Test
    public void rightPop() {
        redisManager.listRightPop("c");
    }

    @Test
    public void setAndGetBit() {
        redisManager.setBit("number", 10000, true);
        System.out.println(redisManager.getBit("number", 10000));
        System.out.println(redisManager.getBit("number", 100000));
    }
}
