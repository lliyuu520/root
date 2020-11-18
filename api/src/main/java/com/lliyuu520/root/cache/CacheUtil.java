package com.lliyuu520.root.cache;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * CacheUtil
 *
 * @author lliyuu520
 * @since 2020/11/17:下午1:38
 */
@Component
@RequiredArgsConstructor
public class CacheUtil<T> {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * 获取list
     *
     * @param key
     * @return
     */
    public List<T> rangeAll(String key, Class<T> tClass) {
        List<Object> range = redisTemplate.opsForList().range(key, 0, -1);

        final List<T> collect = range.stream().map(m -> {
            final JSONObject jsonObject = (JSONObject) JSONObject.toJSON(m);
            final T o = jsonObject.toJavaObject(tClass);
            return o;
        }).collect(Collectors.toList());


        return collect;
    }

    /**
     * 保存list
     *
     * @param key
     * @param list
     */
    public void pushAll(String key, List<T> list) {
        redisTemplate.delete(key);
        list.forEach(m -> {
            redisTemplate.opsForList().leftPush(key, m);

        });
        //如果这样写会导致序列化成jsonarray
//        redisTemplate.opsForList().leftPushAll(key, list);
    }
}
