package com.mjq.common.web.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: majingqiang
 * @Date: 2019-04-25 15:59
 */
@Component
public class RedisManager<T> {

    @Autowired
    private RedisTemplate<String, T> redisTemplate;

    // valueOperate


    public void set(String k, T v) {
        redisTemplate.opsForValue().set(k, v);
    }

    public T get(String k) {
        return redisTemplate.opsForValue().get(k);
    }

    public void set(String k, T v, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(k, v, timeout, unit);
    }

    public void setBit(String k, long offset, boolean value) {
        redisTemplate.opsForValue().setBit(k, offset, value);
    }

    public boolean getBit(String k, long offset) {
        return redisTemplate.opsForValue().getBit(k, offset);
    }


    //hashOperate


    public void hashPut(String k, String hk, T hv) {
        redisTemplate.opsForHash().put(k, hk, hv);
    }

    public T hashGet(String k, String hk) {
        HashOperations<String, String, T> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get(k, hk);
    }

    public long hashIncrement(String k, String hk, long delta) {
        return redisTemplate.opsForHash().increment(k, hk, delta);
    }


    //listOperate


    public T listIndex(String k, long index) {
        return redisTemplate.opsForList().index(k, index);
    }

    public Long listLeftPush(String k, T v) {
        return redisTemplate.opsForList().leftPush(k, v);
    }

    public Long listRightPush(String k, T v) {
        return redisTemplate.opsForList().rightPush(k, v);
    }

    public T listLeftPop(String k) {
        return redisTemplate.opsForList().leftPop(k);
    }

    public T listRightPop(String k) {
        return redisTemplate.opsForList().rightPop(k);
    }

    //setOperate

    public Long setAdd(String k, T v) {
        return redisTemplate.opsForSet().add(k, v);
    }

    public T setPop(String k) {
        return redisTemplate.opsForSet().pop(k);
    }

}
