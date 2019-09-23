package com.dandelion.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: ObjectUtil
 * date:      2019/8/14 15:34
 * author:    puyiliang
 * description: 对象工具类
 */
public class ObjectUtil {

    /**
     * 判断对象是否为空
     * @param obj Object
     * @return boolean
     */
    public static boolean isNull(Object obj) {
        if(obj != null) {
            if (obj instanceof java.lang.String && "".equals(obj)){
                return true;
            }
            if (obj instanceof java.util.List){
                List list = (List)obj;
                if (list.size() == 0){
                    return true;
                }
            }
            if (obj instanceof java.util.Map){
                Map map = (Map)obj;
                if (map.size() == 0){
                    return true;
                }
            }
            if (obj instanceof java.util.Set){
                Set set = (Set)obj;
                if (set.size() == 0){
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
