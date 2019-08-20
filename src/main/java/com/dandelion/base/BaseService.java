package com.dandelion.base;

import com.dandelion.utils.ObjectUtil;
import com.dandelion.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;

import java.io.Serializable;
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

    protected void getSearchExample(Map<String, String> paramsMap, Object object, String beanName) throws Exception{
//        Class clazz = getClass();
//        String name = clazz.getSimpleName();
//        name = name.replace("Service","");
        //获取实体BeanClass
        Class beanClass = Class.forName("com.dandelion.bean." + beanName);
        for (String key : paramsMap.keySet()) {
            StringBuffer methodBuffer = new StringBuffer("and");
            if (ObjectUtil.isNull(paramsMap.get(key))){
                continue;
            }
            Map methodMap = getMethodMap(key);
            String[] methodArray = (String[]) methodMap.get("methodArray");
            int like = (int) methodMap.get("like");
            if (ObjectUtil.isNull(methodArray[0])){
                continue;
            }
            if (like == 2){
                continue;
            }
            methodBuffer.append(methodArray[0]).append(methodArray[1]);
            String attribute = StringUtil.stringFirstLowCase(methodArray[0]);
            //获取属性类型Class
            Class attributeType = beanClass.getDeclaredField(attribute).getType();
            Class criteriaClass = object.getClass();
            Method method = criteriaClass.getMethod(methodBuffer.toString(), attributeType);
            String value = paramsMap.get(key);
            if (like == 1){
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
//        Class clazz = getClass();
//        String name = clazz.getSimpleName();
//        name = name.replace("Service","");
        //获取实体BeanClass
        Class beanClass = Class.forName("com.dandelion.bean." + beanName);
        StringBuffer methodBuffer = new StringBuffer("and");
        Map methodMap = getMethodMap(params);
        String[] methodArray = (String[]) methodMap.get("methodArray");
        int like = (int) methodMap.get("like");
        if (ObjectUtil.isNull(methodArray[0])){
            return;
        }
        if (like == 2){
            return;
        }
        methodBuffer.append(methodArray[0]).append(methodArray[1]);
        String attribute = StringUtil.stringFirstLowCase(methodArray[0]);
        //获取属性类型Class
        Class attributeType = beanClass.getDeclaredField(attribute).getType();
        Class criteriaClass = object.getClass();
        Method method = criteriaClass.getMethod(methodBuffer.toString(), attributeType);
        if (like == 1){
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
        int like = 0;
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
        }else if (key.startsWith("notBetween")){
            methodArray[0] = key.substring(10,key.length());
            methodArray[1] = "NotBetween";
        }else if (key.startsWith("in")){
            methodArray[0] = key.substring(2,key.length());
            methodArray[1] = "In";
        }else if (key.startsWith("notIn")){
            methodArray[0] = key.substring(5,key.length());
            methodArray[1] = "NotIn";
        }else if (key.startsWith("isNull")){
            methodArray[0] = key.substring(6,key.length());
            methodArray[1] = "IsNull";
        }else if (key.startsWith("isNotNull")){
            methodArray[0] = key.substring(9,key.length());
            methodArray[1] = "IsNotNull";
        }else if (key.startsWith("like")){
            methodArray[0] = key.substring(4,key.length());
            methodArray[1] = "Like";
            like = 1;
        }else if (key.startsWith("notLike")){
            methodArray[0] = key.substring(7,key.length());
            methodArray[1] = "NotLike";
            like = 1;
        }else{
            like = 2;
        }
        HashMap<String, Object> methodMap = Maps.newHashMap();
        methodMap.put("like",like);
        methodMap.put("methodArray",methodArray);
        return methodMap;
    }

    public void startPage(Map<String, String> paramsMap){
        PageHelper.offsetPage(Integer.parseInt(paramsMap.get("offset")), Integer.parseInt(paramsMap.get("limit")));
    }

    /**
     * 分页List 返回
     * @param list List
     * @param total Long
     * @return map
     */
    public Map pageResult(List list, long total){
        HashMap resultMap = Maps.newHashMap();
        resultMap.put("rows", list);
        resultMap.put("total", total);
        return resultMap;
    }
    /**
     * 错误信息返回
     * @param code int
     * @param message String
     * @return map
     */
    public Map errorResult(int code, String message){
        HashMap resultMap = Maps.newHashMap();
        resultMap.put("code", code);
        resultMap.put("message", message);
        return resultMap;
    }
    /**
     * 错误信息返回
     * @param code int
     * @return map
     */
    public Map errorResult(int code){
        HashMap resultMap = Maps.newHashMap();
        resultMap.put("code", code);
        resultMap.put("message", CommonMessage.MESSAGE.get(code));
        return resultMap;
    }
    /**
     * 成功信息返回
     * @return map
     */
    public Map successResult(){
        HashMap resultMap = Maps.newHashMap();
        resultMap.put("code", CommonMessage.SUCCESS);
        resultMap.put("message", CommonMessage.MESSAGE.get(CommonMessage.SUCCESS));
        return resultMap;
    }
    /**
     * 成功信息返回
     * @param message String
     * @return map
     */
    public Map successResult(String message){
        HashMap resultMap = Maps.newHashMap();
        resultMap.put("code", CommonMessage.SUCCESS);
        resultMap.put("message", message);
        return resultMap;
    }
}
