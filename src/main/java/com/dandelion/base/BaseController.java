package com.dandelion.base;

import com.dandelion.bean.Admin;
import com.dandelion.utils.PictureVerificationCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * BaseController  公共Controller
 * @date      2019/8/13 10:28
 * @author   puyiliang
 */
@Controller
public class BaseController {

    /**
     * 返回当前调用方法的类名与方法名，做为VIEW的地址
     * @return current class/method
     */
    @RequestMapping("common/login")
    public String toLogin() {
        return "common/login";
    }

    /**
     * @author jiaqing.xu@hand-china.com
     * @date 2017/8/23
     * @description 生成图片验证码
     */
    @RequestMapping(value = "/common/verification", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public void verification(HttpServletResponse response) throws IOException {
         // 设置响应的类型格式为图片格式
          response.setContentType("image/jpeg");
          // 禁止图像缓存。
          response.setHeader("Pragma", "no-cache");
          response.setHeader("Cache-Control", "no-cache");
          response.setDateHeader("Expires", 0);
          //实例生成验证码对象
          PictureVerificationCodeUtil instance = new PictureVerificationCodeUtil();
          //将验证码存入session
          this.setSession("verification", instance.getCode());
          //向页面输出验证码图片
          instance.write(response.getOutputStream());
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

    public Admin getLoginAdmin(){
        return (Admin)getSession().getAttribute("adminSession");
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
     * setSession 存入Session作用域
     * @param name String
     * @param value Object
     */
    public void setSession(String name, Object value) {
        this.getRequest().getSession().setAttribute(name, value);
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
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取响应作用域
     * @return HttpServletResponse
     */
    protected HttpServletResponse getResponse() {
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
        String[] classStr = this.getClass().getName().split("\\.");
        //方法名称
        String action = classStr[classStr.length - 1].replace("Controller", "");
        String method = new Exception().getStackTrace()[1].getMethodName();
        return action + "/" + method;
    }
}
