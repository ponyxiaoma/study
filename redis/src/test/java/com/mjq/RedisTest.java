package com.mjq;

import com.mjq.common.web.redis.RedisManager;
import com.mjq.dto.User;
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
    private RedisManager<User> userRedisManager;
    @Autowired
    private RedisManager<String> redisManager;

    @Test
    public void save() {
        User user = new User();
        user.setUserId(1L);
        user.setUserName("pony");
        user.setAge(25);
        userRedisManager.hashPut("a", "b", user);
    }

    @Test
    public void getForHash() {
        User v = userRedisManager.hashGet("a", "b");
        System.out.println(v.getUserName());
    }

    @Test
    public void rightPush() {
        User user = new User();
        user.setUserId(1L);
        user.setUserName("pony");
        user.setAge(25);
        userRedisManager.listRightPush("c", user);
        userRedisManager.listRightPush("c", user);
    }

    @Test
    public void listIndex() {
        User user = userRedisManager.listIndex("c", 0);
        System.out.println(user.getUserName());
    }

    @Test
    public void rightPop() {
        userRedisManager.listRightPop("c");
    }

    @Test
    public void setAndGetBit() {
        redisManager.setBit("number", 10000, true);
        System.out.println(redisManager.getBit("number", 10000));
        System.out.println(redisManager.getBit("number", 100000));
    }
}
