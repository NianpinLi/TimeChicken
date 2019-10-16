package com.dandelion.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * RedisUtil
 * @date      2019/8/19 16:12
 * @author    puyiliang
 *  redis操作工具类
 */
@Service
public class RedisUtil {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    public <T> boolean set(String key ,T value){
        try {
            //任意类型转换成String
            String val = StringUtil.beanToString(value);
            if(val==null||val.length()<=0){
                return false;
            }
            stringRedisTemplate.opsForValue().set(key,val);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public <T> T get(String key,Class<T> clazz){
        try {
            String value = stringRedisTemplate.opsForValue().get(key);

            return StringUtil.stringToBean(value,clazz);
        }catch (Exception e){
            return null ;
        }
    }
}
