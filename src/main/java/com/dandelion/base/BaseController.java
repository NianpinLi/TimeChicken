package com.dandelion.base;

import com.dandelion.bean.Admin;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName: BaseController
 * date:      2019/8/13 10:28
 * author:    puyiliang
 * description: 公共Controller
 */
@Controller
public class BaseController {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    /**
     * 返回当前调用方法的类名与方法名，做为VIEW的地址
     * @return current class/method
     */
    @RequestMapping("common/login")
    public String toLogin() {
        return "common/login";
    }
    @RequestMapping("common/noAuthority")
    public String noAuthority() {
        return "common/noAuthority";
    }
    @RequestMapping("index/index")
    public String index() {
        return "index/index";
    }
    @RequestMapping("common/error")
    public String error() {
        return "common/error";
    }
    @RequestMapping("common/welcome")
    public String welcome() {
        return "common/welcome";
    }

    public Admin getAdmin(){
        return (Admin)getSession().getAttribute("ADMIN");
    }

    /**
     * setAttribute 存入作用域
     * @param name String
     * @param value Object
     */
    public void setAttribute(String name, Object value) {
        this.getRequest().setAttribute(name, value);
    }

    /**
     * 取参数
     * @param argName String
     * @return String
     */
    public String getParameter(String argName) {
        return this.getRequest().getParameter(argName);
    }

    /**
     * 获取请求作用域
     * @return HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 获取响应作用域
     * @return HttpServletResponse
     */
    public HttpServletResponse getResponse() {
        ServletWebRequest servletContainer = (ServletWebRequest) RequestContextHolder.getRequestAttributes();
        return servletContainer.getResponse();
    }

    /**
     * 获取Session作用域
     * @return HttpServletResponse
     */
    public HttpSession getSession() {
        return this.getRequest().getSession();
    }

    public String disPlay(){
        String[] class_str = this.getClass().getName().split("\\.");
        //方法名称
        String action = class_str[class_str.length - 1].replace("Controller", "");
        String method = new Exception().getStackTrace()[1].getMethodName();
        return action + "/" + method;
    }
}
