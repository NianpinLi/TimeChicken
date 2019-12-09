package com.dandelion.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringUtil
 * @date      2019/8/14 15:44
 * @author    puyiliang
 *  字符串操作工具类
 */
public class StringUtil {

    private static Pattern underLine = Pattern.compile("_(\\w)");

    private static Pattern upCase = Pattern.compile("[A-Z]");

    public static String nullStr = "null";

    /**
     * 下划线转驼峰
     * @param str String
     * @return String
     */
    public static String camel(String str) {
        //利用正则删除下划线，把下划线后一位改成大写
        Matcher matcher = underLine.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            sb = new StringBuffer();
            //将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
            //正则之前的字符和被替换的字符
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            //把之后的也添加到StringBuffer对象里
            matcher.appendTail(sb);
        } else {
            return sb.toString();
        }
        return camel(sb.toString());
    }

    /**
     * 驼峰转下划线
     * @param str String
     * @return String
     */
    public static String underline(String str) {

        Matcher matcher = upCase.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if(matcher.find()) {
            sb = new StringBuffer();
            //将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
            //正则之前的字符和被替换的字符
            matcher.appendReplacement(sb,"_"+matcher.group(0).toLowerCase());
            //把之后的也添加到StringBuffer对象里
            matcher.appendTail(sb);
        }else {
            return sb.toString();
        }
        return underline(sb.toString());
    }


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

    /**
     * 判断字符串如果是null 将其转换为" "
     * @param str String
     * @return String
     */
    public static String castStringNullToEmpty(String str){
        if (ObjectUtil.isNull(str) || nullStr.equals(str.toLowerCase())){
            return " ";
        }else {
            return str;
        }
    }

    /**
     * Json to bean
     * @param value String
     * @param clazz Class
     * @param <T> t
     * @return T
     */
    public static <T> T stringToBean(String value, Class<T> clazz) {
        if(value==null||value.length()<=0||clazz==null){
            return null;
        }
        if(clazz ==int.class ||clazz==Integer.class){
            return (T)Integer.valueOf(value);
        }
        else if(clazz==long.class||clazz==Long.class){
            return (T)Long.valueOf(value);
        }
        else if(clazz==String.class){
            return (T)value;
        }else {
            return JSON.toJavaObject(JSON.parseObject(value),clazz);
        }
    }

    /**
     * Json to list bean
     * @param value String
     * @param clazz Class
     * @param <T> t
     * @return T
     */
    public static <T> List<T> stringToListBean(String value, Class<T> clazz) {
        if(value==null||value.length()<=0||clazz==null){
            return null;
        }
        return JSONArray.parseArray(value, clazz);
    }

    /**
     * bean to json
     * @param value T values
     * @return String
     */
    public static <T> String beanToString(T value) {
        if(value==null){
            return null;
        }
        return JSON.toJSONString(value);
    }
}
