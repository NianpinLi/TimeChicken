package com.dandelion.base;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName: BaseException
 * @Date      2019/9/23 18:07
 * @Author    puyiliang
 * @description: 异常拦截类
 */
@ControllerAdvice
public class BaseException {

    /**
     * Shiro 无权限拦截
     * @param e Exception
     * @return String
     */
    @ExceptionHandler(UnauthorizedException.class)
    public String handleException(Exception e) {
        return "error/500";
    }
    /**
     * Shiro 无权限拦截
     * @param e Exception
     * @return String
     */
    @ExceptionHandler(AuthorizationException.class)
    public String AuthorizationException(Exception e) {
        return "error/500";
    }

}
