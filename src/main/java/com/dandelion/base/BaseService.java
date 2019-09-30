package com.dandelion.base;

import com.dandelion.bean.Admin;
import com.dandelion.utils.ObjectUtil;
import com.dandelion.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: BaseService
 * date:      2019/8/13 10:32
 * author:    puyiliang
 * description: 公共service
 */
public class BaseService<T, PK extends Serializable> {

    protected void setOrderByClause(Map<String, String> paramsMap, Object example, String beanName) throws Exception{
        if(!ObjectUtil.isNull(paramsMap.get("field")) && !ObjectUtil.isNull(paramsMap.get("order"))){
            String field = paramsMap.get("field");
            String order = paramsMap.get("order");
            //获取实体BeanClass
            Class beanClass = Class.forName("com.dandelion.bean." + beanName);
            for (Field fieldName : beanClass.getDeclaredFields()) {
                if(field.equals(fieldName.getName())){
                    //实体存在属性，执行，防止SQL注入
                    Class<?> exampleClass = example.getClass();
                    String value = StringUtil.underline(field) + " " + order;
                    Method method = exampleClass.getMethod("setOrderByClause", String.class);
                    method.invoke(example, value);
                    return;
                }
            }
        }
    }

    protected void getSearchExample(Map<String, String> paramsMap, Object object, String beanName) throws Exception{
        //获取实体BeanClass
        Class beanClass = Class.forName("com.dandelion.bean." + beanName);
        for (String key : paramsMap.keySet()) {
            StringBuffer methodBuffer = new StringBuffer("and");
            if (ObjectUtil.isNull(paramsMap.get(key))){
                continue;
            }
            Map methodMap = getMethodMap(key);
            String[] methodArray = (String[]) methodMap.get("methodArray");
            int type = (int) methodMap.get("type");
            if (ObjectUtil.isNull(methodArray[0])){
                continue;
            }
            if (type == -1){
                //不支持的参数
                continue;
            }
            methodBuffer.append(methodArray[0]).append(methodArray[1]);
            //方法名
            methodBuffer.append(methodArray[0]).append(methodArray[1]);
            String attribute = StringUtil.stringFirstLowCase(methodArray[0]);
            //获取属性类型Class
            Class attributeType = beanClass.getDeclaredField(attribute).getType();
            Class criteriaClass = object.getClass();
            String value = String.valueOf(paramsMap.get(key));
            if(type == 2){
                // isNull
                Method method = criteriaClass.getMethod(methodBuffer.toString());
                method.invoke(object);
                return;
            }
            Method method = criteriaClass.getMethod(methodBuffer.toString(), attributeType);
            if(type == 1){
                // like
                method.invoke(object,"%"+value+"%");
            }else {
                invokeMethod(method,attributeType,object,value);
            }
        }
    }

    protected void getSearchExample(String params, String value, Object object, String beanName) throws Exception{
        if (ObjectUtil.isNull(params)){
            return;
        }
        //获取实体BeanClass
        Class beanClass = Class.forName("com.dandelion.bean." + beanName);
        StringBuffer methodBuffer = new StringBuffer("and");
        Map methodMap = getMethodMap(params);
        String[] methodArray = (String[]) methodMap.get("methodArray");
        int type = (int) methodMap.get("type");
        if (ObjectUtil.isNull(methodArray[0])){
            return;
        }
        if (type == -1){
            //不支持的参数
            return;
        }
        //方法名
        methodBuffer.append(methodArray[0]).append(methodArray[1]);
        String attribute = StringUtil.stringFirstLowCase(methodArray[0]);
        //获取属性类型Class
        Class attributeType = beanClass.getDeclaredField(attribute).getType();
        Class criteriaClass = object.getClass();
        if(type == 2){
            // isNull
            Method method = criteriaClass.getMethod(methodBuffer.toString());
            method.invoke(object);
            return;
        }
        Method method = criteriaClass.getMethod(methodBuffer.toString(), attributeType);
        if(type == 1){
            // like
            method.invoke(object,"%"+value+"%");
        }else {
            invokeMethod(method,attributeType,object,value);
        }
    }
    private static void invokeMethod(Method method,Class attributeType, Object object, String value) throws Exception{
        String attributeTypeString = attributeType.getTypeName();
        //获取属性的get方法
        if("java.lang.String".equals(attributeTypeString)){
            method.invoke(object, value);
        }else if ("int".equals(attributeTypeString) || "java.lang.Integer".equals(attributeTypeString)){
            method.invoke(object, Integer.parseInt(value));
        }else if ("float".equals(attributeTypeString) || "java.lang.Float".equals(attributeTypeString)){
            method.invoke(object, Float.parseFloat(value));
        }else if ("double".equals(attributeTypeString) || "java.lang.Double".equals(attributeTypeString)){
            method.invoke(object, Double.parseDouble(value));
        }else if ("long".equals(attributeTypeString) || "java.lang.Long".equals(attributeTypeString)){
            method.invoke(object, Long.parseLong(value));
        }else if ("char".equals(attributeTypeString) || "java.lang.Character".equals(attributeTypeString)){
            method.invoke(object, value.charAt(0));
        }else if ("short".equals(attributeTypeString) || "java.lang.Short".equals(attributeTypeString)){
            method.invoke(object, Short.parseShort(value));
        }else if ("java.math.BigDecimal".equals(attributeTypeString)){
            method.invoke(object, new BigDecimal(value));
        }else if ("java.math.BigInteger".equals(attributeTypeString)){
            method.invoke(object, new BigInteger(value));
        }
    }

    private static Map getMethodMap(String key){
        int type = 0;
        String[] methodArray = new String[2];
        if (key.startsWith("equalTo")){
            methodArray[0] = key.substring(7,key.length());
            methodArray[1] = "EqualTo";
        }else if (key.startsWith("notEqualTo")){
            methodArray[0] = key.substring(10,key.length());
            methodArray[1] = "NotEqualTo";
        }else if (key.startsWith("greaterThanOrEqualTo")){
            methodArray[0] = key.substring(20,key.length());
            methodArray[1] = "GreaterThanOrEqualTo";
        }else if (key.startsWith("greaterThan")){
            methodArray[0] = key.substring(11,key.length());
            methodArray[1] = "GreaterThan";
        }else if (key.startsWith("lessThanOrEqualTo")){
            methodArray[0] = key.substring(17,key.length());
            methodArray[1] = "LessThanOrEqualTo";
        }else if (key.startsWith("lessThan")){
            methodArray[0] = key.substring(8,key.length());
            methodArray[1] = "LessThan";
        }else if (key.startsWith("between")){
            methodArray[0] = key.substring(7,key.length());
            methodArray[1] = "Between";
            type = 4;
        }else if (key.startsWith("notBetween")){
            methodArray[0] = key.substring(10,key.length());
            methodArray[1] = "NotBetween";
            type = 4;
        }else if (key.startsWith("in")){
            methodArray[0] = key.substring(2,key.length());
            methodArray[1] = "In";
            type = 3;
        }else if (key.startsWith("notIn")){
            methodArray[0] = key.substring(5,key.length());
            methodArray[1] = "NotIn";
            type = 3;
        }else if (key.startsWith("isNull")){
            methodArray[0] = key.substring(6,key.length());
            methodArray[1] = "IsNull";
            type = 2;
        }else if (key.startsWith("isNotNull")){
            methodArray[0] = key.substring(9,key.length());
            methodArray[1] = "IsNotNull";
            type = 2;
        }else if (key.startsWith("like")){
            methodArray[0] = key.substring(4,key.length());
            methodArray[1] = "Like";
            type = 1;
        }else if (key.startsWith("notLike")){
            methodArray[0] = key.substring(7,key.length());
            methodArray[1] = "NotLike";
            type = 1;
        }else{
            type = -1;
        }
        HashMap<String, Object> methodMap = Maps.newHashMap();

        //参数类型 -1 不支持 1 like 2 isNull 3 in 4 between
        methodMap.put("type",type);
        methodMap.put("methodArray",methodArray);
        return methodMap;
    }

    /**
     * setSession 存入Session作用域
     * @param name String
     * @param value Object
     *
     */
    public void setSession(String name, Object value) {
        HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute(name,value);
    }
    /**
     * getSession 获取Session作用域
     * @param name String
     * @return Object
     */
    public Object getSession(String name) {
        HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession().getAttribute(name);
    }

    /**
     * setAttribute 存入Session作用域
     * @param name String
     * @param value Object
     *
     */
    public void setAttribute(String name, Object value) {
        HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.setAttribute(name,value);
    }
    /**
     * getAttribute 获取Session作用域
     * @param name String
     * @return Object
     */
    public Object getAttribute(String name) {
        HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getAttribute(name);
    }

    public Admin getAdmin(){
        return (Admin)getSession("adminSession");
    }

    public void startPage(Map<String, String> paramsMap){
        PageHelper.startPage(Integer.parseInt(paramsMap.get("page")), Integer.parseInt(paramsMap.get("limit")));
    }

    /**
     * 分页List 返回
     * @param list List
     * @param total Long
     * @return map
     */
    public Map pageResult(List list, long total){
        HashMap resultMap = Maps.newHashMap();
        resultMap.put("data", list);
        resultMap.put("count", total);
        resultMap.put("code", 0);
        resultMap.put("msg", CommonMessage.MESSAGE.get(0));
        return resultMap;
    }
    /**
     * 错误信息返回
     * @param code int
     * @param message String
     * @param flag String 是否关闭当前页面 true管理 false不关闭
     * @return map
     */
    public Map errorResult(Integer code, String message,boolean flag){
        HashMap resultMap = Maps.newHashMap();
        resultMap.put("code", code);
        resultMap.put("msg", message);
        resultMap.put("close", flag);
        return resultMap;
    }
    /**
     * 错误信息返回
     * @param code int
     * @return map
     */
    public Map errorResult(Integer code, boolean flag){
        HashMap resultMap = Maps.newHashMap();
        resultMap.put("code", code);
        resultMap.put("msg", CommonMessage.MESSAGE.get(code));
        resultMap.put("close", flag);
        return resultMap;
    }
    /**
     * 成功信息返回
     * @return map
     */
    public Map successResult(boolean flag){
        HashMap resultMap = Maps.newHashMap();
        resultMap.put("code", CommonMessage.SUCCESS);
        resultMap.put("msg", CommonMessage.MESSAGE.get(CommonMessage.SUCCESS));
        resultMap.put("close", flag);
        return resultMap;
    }
    /**
     * 成功信息返回
     * @param message String
     * @return map
     */
    public Map successResult(String message, boolean flag){
        HashMap resultMap = Maps.newHashMap();
        resultMap.put("code", CommonMessage.SUCCESS);
        resultMap.put("msg", message);
        resultMap.put("close", flag);
        return resultMap;
    }
}
