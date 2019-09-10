package com.dandelion.controller;

import com.dandelion.base.BaseController;
import com.dandelion.base.CommonMessage;
import com.dandelion.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ClassName: AdminController
 * date:      2019/8/13 10:26
 * author:    puyiliang
 * description: 用户管理Controller
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

    @Resource
    private AdminService adminService;

    /**
     * 用户登录
     * @param paramsMap Map
     * @return String
     * @throws Exception e
     */
    @RequestMapping("login")
    public String loginAdmin(@RequestParam Map<String,String> paramsMap) throws Exception{
        Map map = adminService.loginAdmin(paramsMap);
        if (CommonMessage.SUCCESS.equals(map.get("code"))){
            return "index/index";
        }else{
            setAttribute("error",map.get("message"));
            return "common/login";
        }
    }

    /**
     * 用户管理页面跳转
     * @return String
     * @throws Exception e
     */
    @RequestMapping(value = "adminPage", method = RequestMethod.GET)
    public String adminPage() throws Exception{
        return this.disPlay();
    }

    /**
     * 查看用户列表
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @RequestMapping(value = "selectAdminPageList", method = RequestMethod.GET)
    public @ResponseBody Map selectAdminPageList(@RequestParam Map<String,String> paramsMap) throws Exception{
        Map result = adminService.selectAdminPageList(paramsMap);
        return result;
    }

}
