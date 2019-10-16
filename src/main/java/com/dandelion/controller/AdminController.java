package com.dandelion.controller;

import com.dandelion.base.BaseController;
import com.dandelion.base.CommonMessage;
import com.dandelion.service.AdminService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName: AdminController
 * @date:      2019/8/13 10:26
 * @author:    puyiliang
 * @description: 用户管理Controller
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
        Object code = map.get("code");
        if (CommonMessage.SUCCESS.equals(code)){
            return "index/index";
        }else{
            setAttribute("error",map.get("message"));
            return "common/login";
        }
    }

    /**
     * 获取登录配置
     * @return Map
     */
    @RequestMapping(value = "getIndexConfig", method = RequestMethod.GET)
    public @ResponseBody Map getIndexConfig() throws Exception{
        return adminService.getIndexConfig();
    }

    /**
     * 用户管理页面跳转
     * @return String
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/admin/getAdmin"})
    @RequestMapping(value = "getAdmin", method = RequestMethod.GET)
    public String getAdmin() throws Exception{
        return this.disPlay();
    }

    /**
     * 查看用户列表
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/admin/getAdminList"})
    @RequestMapping(value = "getAdminList", method = RequestMethod.GET)
    public @ResponseBody Map getAdminList(@RequestParam Map<String,String> paramsMap) throws Exception{
        Map result = adminService.getAdminList(paramsMap);
        return result;
    }

    /**
     * 用户新增页面跳转
     * @return String
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/admin/addAdmin"})
    @RequestMapping(value = "addAdmin", method = RequestMethod.GET)
    public String addAdmin() throws Exception{
        return this.disPlay();
    }

    /**
     * 用户新增页面跳转
     * @return String
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/admin/updateAdmin"})
    @RequestMapping(value = "updateAdmin", method = RequestMethod.GET)
    public String updateAdmin(@RequestParam Map<String, String> paramsMap) throws Exception{
        adminService.getAdminById(paramsMap);
        return this.disPlay();
    }

    /**
     * 新增 / 修改 用户
     * @return String
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/admin/addAdmin","/admin/updateAdmin"},logical= Logical.OR)
    @RequestMapping(value = "saveAdmin", method = RequestMethod.POST)
    public @ResponseBody Map saveAdmin(@RequestParam Map<String, String> paramsMap) throws Exception{
        return adminService.saveAdmin(paramsMap);
    }

    /**
     * 分配角色页面跳转
     * @return String
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/admin/empowermentRole"})
    @RequestMapping(value = "empowermentRole", method = RequestMethod.GET)
    public String empowermentRole(@RequestParam Map<String, String> paramsMap) throws Exception{
        this.setAttribute("adminId", paramsMap.get("adminId"));
        return this.disPlay();
    }

    /**
     * 分配角色页面跳转
     * @return String
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/admin/empowermentRole"})
    @RequestMapping(value = "getRoleTree", method = RequestMethod.GET)
    public @ResponseBody Map getRoleTree(@RequestParam Map<String, String> paramsMap) throws Exception{
        //查询(现有权限,所有权限并组成树形结构)
        return adminService.empowermentRole(paramsMap);
    }
    /**
     * 用户分配角色
     */
    @RequiresPermissions(value = {"/admin/empowermentRole"})
    @RequestMapping(value = "saveEmpowermentRole", method = RequestMethod.POST)
    public @ResponseBody Map saveEmpowermentRole(@RequestParam Map<String, Object> paramsMap) throws Exception{
        return adminService.saveEmpowermentRole(paramsMap);
    }

    /**
     * 删除用户
     */
    @RequiresPermissions(value = {"/admin/deleteAdmin"})
    @RequestMapping(value = "deleteAdmin", method = RequestMethod.POST)
    public @ResponseBody Map deleteAdmin(@RequestParam Map<String, String> paramsMap) throws Exception{
        return adminService.deleteAdmin(paramsMap);
    }


    /**
     * 启用停用用户
     */
    @RequiresPermissions(value = {"/admin/changeAdminStatus"})
    @RequestMapping(value = "changeAdminStatus", method = RequestMethod.POST)
    public @ResponseBody Map changeAdminStatus(@RequestParam Map<String, String> paramsMap) throws Exception{
        return adminService.changeAdminStatus(paramsMap);
    }
}
