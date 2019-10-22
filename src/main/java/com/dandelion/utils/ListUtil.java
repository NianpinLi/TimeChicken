package com.dandelion.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * ListUtil
 * @date      2019/10/11 17:14
 * @author    puyiliang
 * 操作List 的工具类
 */
@Slf4j
public class ListUtil {

    /**
     * 将实体List 按指定字段为Key 转成 Map
     * @param list List
     * @param fieldName String
     * @param <K> object
     * @param <V> object
     * @return Map
     */
    public  static <K, V> Map<K, V> objectListToKeyMap(List<V> list, String fieldName){
        Map<K, V> map = Maps.newLinkedHashMap();
        if(list == null || list.size() == 0) {
            return map;
        }
        try {
            Method getter = getMethod(list.get(0).getClass(), fieldName, "get");
            for (V item : list) {
                K key = (K) getter.invoke(item);
                map.put(key, item);
            }
        } catch (Exception e) {
            log.error("makeEntityListMap error list is " + list, e);
            return map;
        }
        return map;
    }

    /**
     * 将实体List 按指定字段为Key 转成 Map
     * @param list List
     * @param fieldName String
     * @param <K> object
     * @param <V> object
     * @return Map
     */
    public  static <K, V> Map<K, List<V>> objectListToKeyMapList(List<V> list, String fieldName){
        Map<K, List<V>> map = Maps.newLinkedHashMap();
        if(list == null || list.size() == 0) {
            return map;
        }
        try {
            Method getter = getMethod(list.get(0).getClass(), fieldName, "get");
            for (V item : list) {
                K key = (K) getter.invoke(item);
                List<V> groupList = map.get(key);
                if (groupList == null) {
                    groupList = Lists.newArrayList();
                    map.put(key, groupList);
                }
                groupList.add(item);
            }
        } catch (Exception e) {
            log.error("makeEntityListMap error list is " + list, e);
            return map;
        }
        return map;
    }

    /**
     * 将Map List 按指定字段为Key 转成 Map
     * @param list List
     * @param fieldName String
     * @return Map
     */
    public  static Map<Object, Map> mapListToKeyMap(List<Map> list, Object fieldName){
        Map<Object, Map> map = Maps.newLinkedHashMap();
        if(list == null || list.size() == 0) {
            return map;
        }
        try {
            for (Map item : list) {
                Object key = item.get(fieldName);
                map.put(key, item);
            }
        } catch (Exception e) {
            log.error("makeEntityListMap error list is " + list, e);
            return map;
        }
        return map;
    }

    /**
     * 将Map List 按指定字段为Key 转成 Map
     * @param list List
     * @param fieldName String
     * @return Map
     */
    public  static Map<Object, List<Map>> mapListToKeyMapList(List<Map> list, Object fieldName){
        Map<Object, List<Map>> map = Maps.newLinkedHashMap();
        if(list == null || list.size() == 0) {
            return map;
        }
        try {
            for (Map item : list) {
                Object key = item.get(fieldName);
                List<Map> groupList = map.get(key);
                if (groupList == null) {
                    groupList = Lists.newArrayList();
                    map.put(key, groupList);
                }
                groupList.add(item);
            }
        } catch (Exception e) {
            log.error("makeEntityListMap error list is " + list, e);
            return map;
        }
        return map;
    }

    /**
     * 获取getter或setter
     */
    private static Method getMethod(Class clazz, String fieldName, String methodPrefix) throws NoSuchMethodException {
        String first = fieldName.substring(0, 1);
        String getterName = methodPrefix + fieldName.replaceFirst(first, first.toUpperCase());
        return clazz.getMethod(getterName);
    }

}
