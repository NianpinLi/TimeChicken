package com.dandelion.base;

import com.dandelion.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName BaseAop
 * @Date      2019/9/23 17:43
 * @Author    puyiliang
 * @Description: Spring AOP 异常拦截
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
//        logger.info("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
        log.info("进入方法："+proceedingJoinPoint.getSignature().getName()+" 时间："+ DateUtil.getNowTime_CN());
        try {
            //执行方法
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Exception e){
            e.printStackTrace();
        } catch (Throwable throwable) {
            //异常拦截
            throwable.printStackTrace();
            //返回异常页面
        }
        return null;
    }


}
