package com.dandelion.base;

import com.dandelion.bean.Admin;
import com.dandelion.utils.DateUtil;
import com.dandelion.utils.ObjectUtil;
import com.dandelion.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
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
 * BaseService
 * @date      2019/8/13 10:32
 * @author    puyiliang
 *  公共service
 */
public class BaseServiceImpl<T, PK extends Serializable> {

    private String stringClass = "java.lang.String";
    private String intClass = "java.lang.Integer";
    private String intName = "int";
    private String floatClass = "java.lang.Float";
    private String floatName = "float";
    private String doubleClass = "java.lang.Double";
    private String doubleName = "double";
    private String longClass = "java.lang.Long";
    private String longName = "long";
    private String charClass = "java.lang.Character";
    private String charName = "char";
    private String shortClass = "java.lang.Short";
    private String shortName = "short";
    private String byteClass = "java.lang.Byte";
    private String byteName = "byte";
    private String booleanClass = "java.lang.Boolean";
    private String booleanName = "boolean";
    private String bigDecimalClass = "java.math.BigDecimal";
    private String bigIntegerClass = "java.math.BigInteger";

    protected void setOrderByClause(Map<String, String> paramsMap, Object example, String beanName) throws Exception{
        String fieldSort = "field";
        String orderSort = "order";
        if(!ObjectUtil.isNull(paramsMap.get(fieldSort)) && !ObjectUtil.isNull(paramsMap.get(orderSort))){
            String field = paramsMap.get(fieldSort);
            String order = paramsMap.get(orderSort);
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

    protected void setExample(Map<String, String> paramsMap, Object object, String beanName) throws Exception{
        //获取实体BeanClass
        Class beanClass = Class.forName("com.dandelion.bean." + beanName);
        for (String key : paramsMap.keySet()) {
            StringBuilder methodBuilder = new StringBuilder("and");
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
            methodBuilder.append(methodArray[0]).append(methodArray[1]);
            Class criteriaClass = object.getClass();
            //方法名
            String attribute = StringUtil.stringFirstLowCase(methodArray[0]);
            //获取属性类型Class
            Class attributeType = beanClass.getDeclaredField(attribute).getType();
            String value = String.valueOf(paramsMap.get(key));
            if(type == 2){
                // isNull
                Method method = criteriaClass.getMethod(methodBuilder.toString());
                method.invoke(object);
                return;
            }
            if (type == 3){
                // in
                Method method = criteriaClass.getMethod(methodBuilder.toString(), List.class);
                invokeListMethod(method,attributeType,object,value);
                return;
            }
            Method method = criteriaClass.getMethod(methodBuilder.toString(), attributeType);
            if(type == 1){
                method.invoke(object,"%"+value+"%");
            }else{
                invokeMethod(method,attributeType,object,value);
            }
        }
    }

    protected void setExample(String params, String value, Object object, String beanName) throws Exception{
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
        int isNullType = 2;
        int inType = 3;
        if(type == isNullType){
            // isNull
            Method method = criteriaClass.getMethod(methodBuffer.toString());
            method.invoke(object);
            return;
        }
        if (type == inType){
            // in
            Method method = criteriaClass.getMethod(methodBuffer.toString(), List.class);
            invokeListMethod(method,attributeType,object,value);
            return;
        }
        Method method = criteriaClass.getMethod(methodBuffer.toString(), attributeType);
        switch (type){
            case 1:method.invoke(object,"%"+value+"%");break;
            default:invokeMethod(method,attributeType,object,value);break;
        }
    }
    private void invokeListMethod(Method method,Class attributeType, Object object, String value) throws Exception{
        String attributeTypeString = attributeType.getTypeName();
        String[] valueStr = value.split(",");
        if(stringClass.equals(attributeTypeString)){
            List<String> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(values);
            }
            method.invoke(object, valueList);
        }else if (intName.equals(attributeTypeString) || intClass.equals(attributeTypeString)){
            List<Integer> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(Integer.parseInt(values));
            }
            method.invoke(object, valueList);
        }else if (floatName.equals(attributeTypeString) || floatClass.equals(attributeTypeString)){
            List<Float> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(Float.parseFloat(values));
            }
            method.invoke(object, valueList);
        }else if (doubleName.equals(attributeTypeString) || doubleClass.equals(attributeTypeString)){
            List<Double> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(Double.parseDouble(values));
            }
            method.invoke(object, valueList);
        }else if (longName.equals(attributeTypeString) || longClass.equals(attributeTypeString)){
            List<Long> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(Long.parseLong(values));
            }
            method.invoke(object, valueList);
        }else if (charName.equals(attributeTypeString) || charClass.equals(attributeTypeString)){
            List<Character> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(values.charAt(0));
            }
            method.invoke(object, valueList);
        }else if (shortName.equals(attributeTypeString) || shortClass.equals(attributeTypeString)){
            List<Short> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(Short.parseShort(values));
            }
            method.invoke(object, valueList);
        }else if (byteName.equals(attributeTypeString) || byteClass.equals(attributeTypeString)){
            List<Byte> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(Byte.parseByte(values));
            }
            method.invoke(object, valueList);
        }else if (booleanName.equals(attributeTypeString) || booleanClass.equals(attributeTypeString)){
            List<Boolean> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(Boolean.parseBoolean(values));
            }
            method.invoke(object, valueList);
        }else if (bigDecimalClass.equals(attributeTypeString)){
            List<BigDecimal> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(new BigDecimal(values));
            }
            method.invoke(object, valueList);
        }else if (bigIntegerClass.equals(attributeTypeString)){
            List<BigInteger> valueList = Lists.newArrayList();
            for (String values : valueStr) {
                valueList.add(new BigInteger(values));
            }
            method.invoke(object, valueList);
        }
    }

    private void invokeMethod(Method method,Class attributeType, Object object, String value) throws Exception{
        String attributeTypeString = attributeType.getTypeName();
        //获取属性的get方法
        if(stringClass.equals(attributeTypeString)){
            method.invoke(object, value);
        }else if (intName.equals(attributeTypeString) || intClass.equals(attributeTypeString)){
            method.invoke(object, Integer.parseInt(value));
        }else if (floatName.equals(attributeTypeString) || floatClass.equals(attributeTypeString)){
            method.invoke(object, Float.parseFloat(value));
        }else if (doubleName.equals(attributeTypeString) || doubleClass.equals(attributeTypeString)){
            method.invoke(object, Double.parseDouble(value));
        }else if (longName.equals(attributeTypeString) || longClass.equals(attributeTypeString)){
            method.invoke(object, Long.parseLong(value));
        }else if (charName.equals(attributeTypeString) || charClass.equals(attributeTypeString)){
            method.invoke(object, value.charAt(0));
        }else if (shortName.equals(attributeTypeString) || shortClass.equals(attributeTypeString)){
            method.invoke(object, Short.parseShort(value));
        }else if (byteName.equals(attributeTypeString) || byteClass.equals(attributeTypeString)){
            method.invoke(object, Byte.parseByte(value));
        }else if (booleanName.equals(attributeTypeString) || booleanClass.equals(attributeTypeString)){
            method.invoke(object, Boolean.parseBoolean(value));
        }else if (bigDecimalClass.equals(attributeTypeString)){
            method.invoke(object, new BigDecimal(value));
        }else if (bigIntegerClass.equals(attributeTypeString)){
            method.invoke(object, new BigInteger(value));
        }
    }

    private Map getMethodMap(String key){
        String equalTo= "equalTo";
        String notEqualTo= "notEqualTo";
        String greaterThanOrEqualTo= "greaterThanOrEqualTo";
        String greaterThan= "greaterThan";
        String lessThanOrEqualTo= "lessThanOrEqualTo";
        String lessThan= "lessThan";
        String between= "between";
        String notBetween= "notBetween";
        String in= "in";
        String notIn= "notIn";
        String isNull= "isNull";
        String isNotNull= "isNotNull";
        String like= "like";
        String notLike= "notLike";
        int likeType = 1;
        int type = 0;
        int length = key.length();

        String[] methodArray = new String[2];
        if (key.startsWith(equalTo)){
            methodArray[0] = key.substring(7,length);
            methodArray[1] = "EqualTo";
        }else if (key.startsWith(notEqualTo)){
            methodArray[0] = key.substring(10,length);
            methodArray[1] = "NotEqualTo";
        }else if (key.startsWith(greaterThanOrEqualTo)){
            methodArray[0] = key.substring(20,length);
            methodArray[1] = "GreaterThanOrEqualTo";
        }else if (key.startsWith(greaterThan)){
            methodArray[0] = key.substring(11,length);
            methodArray[1] = "GreaterThan";
        }else if (key.startsWith(lessThanOrEqualTo)){
            methodArray[0] = key.substring(17,length);
            methodArray[1] = "LessThanOrEqualTo";
        }else if (key.startsWith(lessThan)){
            methodArray[0] = key.substring(8,length);
            methodArray[1] = "LessThan";
        }else if (key.startsWith(between)){
            methodArray[0] = key.substring(7,length);
            methodArray[1] = "Between";
            type = 4;
        }else if (key.startsWith(notBetween)){
            methodArray[0] = key.substring(10,length);
            methodArray[1] = "NotBetween";
            type = 4;
        }else if (key.startsWith(in)){
            methodArray[0] = key.substring(2,length);
            methodArray[1] = "In";
            type = 3;
        }else if (key.startsWith(notIn)){
            methodArray[0] = key.substring(5,length);
            methodArray[1] = "NotIn";
            type = 3;
        }else if (key.startsWith(isNull)){
            methodArray[0] = key.substring(6,length);
            methodArray[1] = "IsNull";
            type = 2;
        }else if (key.startsWith(isNotNull)){
            methodArray[0] = key.substring(9,length);
            methodArray[1] = "IsNotNull";
            type = 2;
        }else if (key.startsWith(like)){
            methodArray[0] = key.substring(4,length);
            methodArray[1] = "Like";
            type = likeType;
        }else if (key.startsWith(notLike)){
            methodArray[0] = key.substring(7,length);
            methodArray[1] = "NotLike";
            type = likeType;
        }else{
            type = -1;
        }
        HashMap<String, Object> methodMap = Maps.newHashMap();

        //参数类型 -1 不支持 1 like 2 isNull 3 in 4 between
        methodMap.put("type",type);
        methodMap.put("methodArray",methodArray);
        return methodMap;
    }

    protected void setCreateInfo(Object object, Admin admin) throws Exception{
        Class<?> clazz = object.getClass();
        Method setCreateId = clazz.getMethod("setCreateId", Integer.class);
        Method setCreateName = clazz.getMethod("setCreateName", String.class);
        Method setCreateTime = clazz.getMethod("setCreateTime", String.class);
        setCreateId.invoke(object, admin.getAdminId());
        setCreateName.invoke(object, admin.getAdminName());
        setCreateTime.invoke(object, DateUtil.getNowDateEn());
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

    public Admin getLoginAdmin(){
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
        HashMap<String, Object> resultMap = Maps.newHashMap();
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
        HashMap<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("code", code);
        resultMap.put("msg", message);
        resultMap.put("close", flag);
        return resultMap;
    }
    /**
     * 错误信息返回
     * @param code int
     * @param flag boolean
     * @return map
     */
    public Map errorResult(Integer code, boolean flag){
        HashMap<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("code", code);
        resultMap.put("msg", CommonMessage.MESSAGE.get(code));
        resultMap.put("close", flag);
        return resultMap;
    }

    /**
     * 错误信息返回
     * @param flag boolean
     * @return map
     */
    public Map errorResult( boolean flag){
        HashMap<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("code", CommonMessage.ERROR);
        resultMap.put("msg", CommonMessage.MESSAGE.get(CommonMessage.ERROR));
        resultMap.put("close", flag);
        return resultMap;
    }
    /**
     * 成功信息返回
     * @return map
     */
    public Map successResult(boolean flag){
        HashMap<String, Object> resultMap = Maps.newHashMap();
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
        HashMap<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("code", CommonMessage.SUCCESS);
        resultMap.put("msg", message);
        resultMap.put("close", flag);
        return resultMap;
    }

    /**
     * 成功信息返回
     * @param data Object
     * @return map
     */
    public Map successResult(Object data, boolean flag){
        HashMap<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("code", CommonMessage.SUCCESS);
        resultMap.put("data", data);
        resultMap.put("close", flag);
        return resultMap;
    }
}
