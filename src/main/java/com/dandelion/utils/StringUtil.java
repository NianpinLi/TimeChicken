package com.dandelion.utils;


import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: StringUtil
 * date:      2019/8/14 15:44
 * author:    puyiliang
 * description: 字符串操作工具类
 */
public class StringUtil {

    /**
     * 下划线转驼峰
     * @param str String
     * @return String
     */
    public static String camel(String str) {
        //利用正则删除下划线，把下划线后一位改成大写
        Pattern pattern = Pattern.compile("_(\\w)");
        Matcher matcher = pattern.matcher(str);
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
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(str);
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
     * 字符串MD5加密，加盐
     * @param str String
     * @return String
     */
    public static String getMD5(String str) throws Exception{
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        str = md5Hex(str + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = str.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = str.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     * @param str String
     * @return String
     */
    public static String md5Hex(String str) throws Exception{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bs = md5.digest(str.getBytes());
        return new String(new Hex().encode(bs));
    }

    /**
     * 校验String 和 加密之后的 md5 是否相同
     * @param str String
     * @return String
     */
    public static boolean verify(String str, String md5) throws Exception{
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(str + salt).equals(new String(cs1));
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
     * bean to json
     * @param value T values
     * @return String
     */
    public static <T> String beanToString(T value) {
        if(value==null){
            return null;
        }
        Class <?> clazz = value.getClass();
        if(clazz==int.class||clazz==Integer.class){
            return ""+value;
        }
        else if(clazz==long.class||clazz==Long.class){
            return ""+value;
        }
        else if(clazz==String.class){
            return (String)value;
        }else {
            return JSON.toJSONString(value);
        }
    }
}
