package com.dandelion.base;

import com.dandelion.service.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: BaseAspect
 * date:      2019/8/19 14:04
 * author:    puyiliang
 * description: 切面类 切入Controller实现操作操作记录 或者 权限过滤
 */
@Aspect
@Component
@Slf4j
public class BaseAspect {

    @Resource
    private AuthorityService authorityService;

    /**
     * 2. 指定切点
     * 匹配com.dandelion.base.BaseController所有方法
     */
    @Pointcut("execution(* com.dandelion.*.*Controller.*(..))")
    public void executeController(){

    }

    @Around("executeController()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        Boolean authority;
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        String fileName = sourceLocation.getFileName();
        System.out.println(fileName);
        HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取请求路径
        String requestURI = request.getRequestURI();
        //验证权限
        if("/toPage".equals(requestURI)){
            String url = request.getParameter("url");
            authority = authorityService.verifyAuthority(url);
        }else{
            authority = authorityService.verifyAuthority(requestURI);
        }
        if (!authority){
            //权限不足 跳转提示页面
            HttpServletResponse response= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            String realPath = request.getSession().getServletContext().getContextPath();
            response.sendRedirect(realPath+"/toPage?url='base/noAuthority'");
            return null;
        }
        return joinPoint.proceed();
    }

}
