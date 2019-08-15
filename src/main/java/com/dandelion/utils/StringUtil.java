package com.dandelion.utils;

/**
 * ClassName: StringUtil
 * date:      2019/8/14 15:44
 * author:    puyiliang
 * description:
 */
public class StringUtil {
    /**
     * 将String字符串的首字母变成大写
     * @param str String
     * @return String
     */
    public static String stringFirstUpCase(String str){
        if (ObjectUtil.isNull(str)){
            return str;
        }
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
    /**
     * 将String字符串的首字母变成小写
     * @param str String
     * @return String
     */
    public static String stringFirstLowCase(String str){
        if (ObjectUtil.isNull(str)){
            return str;
        }
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }
}
