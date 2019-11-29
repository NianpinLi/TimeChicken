package com.dandelion.utils;

import com.dandelion.base.CommonConstant;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    /**
     * 向Redis中存数据 默认过期时间三十分钟
     * @param key String
     * @param value T
     * @param <T> T
     * @return T
     */
    public <T> boolean set(String key ,T value){
        try {
            //任意类型转换成String
            String val = StringUtil.beanToString(value);
            if(val==null||val.length()<=0){
                return false;
            }
            stringRedisTemplate.opsForValue().set(key,val, CommonConstant.THIRTY_MINUTE_BY_MILLISECOND, TimeUnit.MILLISECONDS);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 向Redis中存数据, 并设置过期时间 单位毫秒
     * @param key String
     * @param value T
     * @param overdue long
     * @param <T> T
     * @return T
     */
    public <T> boolean set(String key ,T value, Long overdue){
        try {
            //任意类型转换成String
            String val = StringUtil.beanToString(value);
            if(val==null||val.length()<=0){
                return false;
            }
            stringRedisTemplate.opsForValue().set(key,val, overdue, TimeUnit.MILLISECONDS);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 向Redis中存数据 不设置失效
     * @param key String
     * @param value T
     * @param <T> T
     * @return T
     */
    public <T> boolean setNoFailure(String key ,T value){
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

    /**
     * 从Redis中获取数据
     * @param key String
     * @param clazz T
     * @param <T> T
     * @return T
     */
    public <T> T get(String key, Class<T> clazz){
        try {
            String value = stringRedisTemplate.opsForValue().get(key);
            return StringUtil.stringToBean(value, clazz);
        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }
    /**
     * 从Redis中获取数据
     * @param key String
     * @param clazz T
     * @param <T> T
     * @return T
     */
    public <T> List<T> getList(String key, Class<T> clazz){
        try {
            String value = stringRedisTemplate.opsForValue().get(key);
            return StringUtil.stringToListBean(value, clazz);
        }catch (Exception e){
            return null ;
        }
    }

    /**
     * 从Redis中获取String类型数据
     * @param key String
     * @return String
     */
    public String get(String key){
        try {
            return stringRedisTemplate.opsForValue().get(key);
        }catch (Exception e){
            return null ;
        }
    }

    /**
     * 删除缓存
     * @param key
     */
    public void delete(String key){
        try {
            stringRedisTemplate.delete(key);
        }catch (Exception e){}
    }

}
