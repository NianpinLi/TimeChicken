package com.dandelion.base;

import com.alibaba.fastjson.JSONObject;
import com.dandelion.annotation.ReadOnlyConnection;
import com.dandelion.dao.DataSourceContextHolder;
import com.dandelion.utils.DateUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.http.HttpServletResponseWrapper;
import java.util.Arrays;
import java.util.Map;

/**
 * BaseAop Spring AOP 异常拦截
 * @date      2019/9/23 17:43
 * @author    puyiliang
 */
@Aspect
@Component
@Slf4j
public class BaseAop {
    /**
     * Controller方法切点
     */
    @Pointcut("execution(* com.dandelion.controller..*.*(..))")

    public void controllerException() {}


    /**
     * 环绕通知：
     *   环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     *   环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("controllerException()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        // 参数名
        String[] argNames = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterNames();
        Map<String, Object> paramMap = Maps.newHashMap();
        for (int i = 0; i < args.length; i++) {
            if (!(args[i] instanceof ExtendedServletRequestDataBinder) && !(args[i] instanceof HttpServletResponseWrapper)) {
                paramMap.put(argNames[i], args[i]);
            }
        }
        if (paramMap.size() > 0) {
            log.info("\n[{}]\n方法:{};\n参数:{}", "时间："+ DateUtil.getNowTimeCn(), proceedingJoinPoint.getSignature(), JSONObject.toJSONString(paramMap));
        }
        try {
            //执行方法
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            //异常拦截
            throwable.printStackTrace();
            //返回异常页面
        }
        return null;
    }

    /**
     * 从库方法AOP 如果Service方法中添加注解 @ReadOnlyConnection 查询走从库
     * @param proceedingJoinPoint ProceedingJoinPoint
     * @param readOnlyConnection ReadOnlyConnection
     * @return Object
     * @throws Throwable e
     */
    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint,ReadOnlyConnection readOnlyConnection) throws Throwable {
        try {
            Signature signature = proceedingJoinPoint.getSignature();
            String[] noLogMethod = {"getRoleByAdminId","getAuthorityByAdminId"};
            if (!Arrays.asList(noLogMethod).contains(signature.getName())){
                log.info("从库查询，查询方法:{}",signature);
            }
            DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DataSourceType.SLAVE);
            return proceedingJoinPoint.proceed();
        }finally {
            DataSourceContextHolder.clearDataSourceType();
        }
    }

}
