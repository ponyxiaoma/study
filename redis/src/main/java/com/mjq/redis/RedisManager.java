package com.mjq.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: majingqiang
 * @Date: 2019-04-25 15:59
 */
@Component
public class RedisManager {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // valueOperate


    public void set(String k, Object v) {
        redisTemplate.opsForValue().set(k, v);
    }

    public Object get(String k) {
        return redisTemplate.opsForValue().get(k);
    }

    public void set(String k, Object v, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(k, v, timeout, unit);
    }

    public void setBit(String k, long offset, boolean value) {
        redisTemplate.opsForValue().setBit(k, offset, value);
    }

    public boolean getBit(String k, long offset) {
        return redisTemplate.opsForValue().getBit(k, offset);
    }


    //hashOperate


    public void hashPut(String k, String hk, String hv) {
        redisTemplate.opsForHash().put(k, hk, hv);
    }

    public Object hashGet(String k, String hk) {
        return redisTemplate.opsForHash().get(k, hk);
    }


    //listOperate


    public Object listIndex(String k, long index) {
        return redisTemplate.opsForList().index(k, index);
    }

    public Long listLeftPush(String k, Object v) {
        return redisTemplate.opsForList().leftPush(k, v);
    }

    public Long listRightPush(String k, Object v) {
        return redisTemplate.opsForList().rightPush(k, v);
    }

    public Object listLeftPop(String k) {
        return redisTemplate.opsForList().leftPop(k);
    }

    public Object listRightPop(String k) {
        return redisTemplate.opsForList().rightPop(k);
    }

    //setOperate

    public Long setAdd(String k, String v) {
        return redisTemplate.opsForSet().add(k, v);
    }

    public Object setPop(String k) {
        return redisTemplate.opsForSet().pop(k);
    }

}
