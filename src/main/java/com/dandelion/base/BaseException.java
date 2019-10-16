package com.dandelion.base;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * BaseException 异常拦截类
 * @date      2019/9/23 18:07
 * @author    puyiliang
 *
 */
@ControllerAdvice
public class BaseException {

    /**
     * 拦截未经授权异常
     * @param e Exception
     * @return String
     */
    @ExceptionHandler(UnauthorizedException.class)
    public String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        //如果是Ajax请求
        if(isAjax(request)){
            HashMap resultMap = Maps.newHashMap();
            resultMap.put("code", CommonMessage.PERMISSION_ERROR);
            resultMap.put("close", false);
            resultMap.put("msg", CommonMessage.MESSAGE.get(CommonMessage.PERMISSION_ERROR));
            returnJson(response, resultMap);
        }
        return "error/500";
    }
    /**
     * 拦截授权异常
     * @param e Exception
     * @return String
     */
    @ExceptionHandler(AuthorizationException.class)
    public String authorizationException(HttpServletRequest request, HttpServletResponse response,Exception e) {
        //如果是Ajax请求
        if(isAjax(request)){
            HashMap resultMap = Maps.newHashMap();
            resultMap.put("msg", CommonMessage.MESSAGE.get(CommonMessage.PERMISSION_ERROR));
            resultMap.put("code", CommonMessage.PERMISSION_ERROR);
            resultMap.put("close", false);
            returnJson(response, resultMap);
        }
        return "error/500";
    }

    /**
     * 判断是否是Ajax请求
     * @param request HttpServletRequest
     * @return boolean
     */
    public boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }

    public void returnJson(HttpServletResponse response, Object object){
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            out.write(JSONObject.toJSONString(object));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
