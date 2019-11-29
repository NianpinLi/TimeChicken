package com.dandelion.controller;

import com.dandelion.base.BaseController;
import com.dandelion.bean.Role;
import com.dandelion.service.RoleService;
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
 * AdminController
 * @date      2019/8/13 10:26
 * @author    puyiliang
 *  角色管理Controller
 */
@Controller
@RequestMapping("role")
public class RoleController extends BaseController{

    @Resource
    private RoleService roleService;

    /**
     * 跳转角色管理页面
     * @return String
     */
    @RequiresPermissions("/role/getRole")
    @RequestMapping(value = "getRole", method = RequestMethod.GET)
    public String getRole() throws Exception{
        return this.disPlay();
    }

    /**
     * 查询角色列表
     * @param map Map
     * @return Map
     */
    @RequiresPermissions("/role/getRoleList")
    @RequestMapping(value = "getRoleList", method = RequestMethod.GET)
    public @ResponseBody Map getRoleList(@RequestParam Map<String,String> map) throws Exception{
        return roleService.getRoleList(map);
    }

    /**
     * 跳转角色添加页面
     * @return String
     */
    @RequiresPermissions("/role/addRole")
    @RequestMapping(value = "addRole", method = RequestMethod.GET)
    public String addRole() throws Exception{
        return this.disPlay();
    }

    /**
     * 查询角色列表
     * @param map Map
     * @return Map
     */
    @RequiresPermissions(value = {"/role/addRole","/workOrder/addType","/workOrder/updateType"}, logical = Logical.OR)
    @RequestMapping(value = "getRolePageList", method = RequestMethod.GET)
    public @ResponseBody Map getRolePageList(@RequestParam Map<String,String> map) throws Exception{
        return roleService.getRolePageList(map);
    }
    /**
     * 跳转角色修改页面
     * @return String
     */
    @RequiresPermissions("/role/updateRole")
    @RequestMapping(value = "updateRole", method = RequestMethod.GET)
    public String updateRole(@RequestParam Map<String, String> paramsMap) throws Exception{
        //查询权限数据并存入作用域
        Role role = roleService.getRoleById(paramsMap);
        this.setAttribute("role",role);
        return this.disPlay();
    }

    /**
     * 新增/修改 角色
     */
    @RequiresPermissions(value = {"/role/addRole","/role/updateRole"},logical= Logical.OR)
    @RequestMapping(value = "saveRole", method = RequestMethod.POST)
    public @ResponseBody Map saveRole(@RequestParam Map<String, String> paramsMap) throws Exception{
        return roleService.saveRole(paramsMap);
    }

    /**
     * 删除角色
     */
    @RequiresPermissions(value = {"/role/deleteRole"})
    @RequestMapping(value = "deleteRole", method = RequestMethod.POST)
    public @ResponseBody Map deleteRole(@RequestParam Map<String, String> paramsMap) throws Exception{
        return roleService.deleteRole(paramsMap);
    }
    /**
     * 跳转角色分配权限页面
     */
    @RequiresPermissions(value = {"/role/empowermentAuthority"})
    @RequestMapping(value = "empowermentAuthority", method = RequestMethod.GET)
    public String empowermentAuthority(@RequestParam Map<String, String> paramsMap) throws Exception{
        this.setAttribute("roleId", paramsMap.get("roleId"));
        return this.disPlay();
    }
    /**
     * 角色拥有权限回显
     */
    @RequiresPermissions(value = {"/role/empowermentAuthority"})
    @RequestMapping(value = "getRoleAuthorityTree", method = RequestMethod.GET)
    public @ResponseBody Map getRoleAuthorityTree(@RequestParam Map<String, String> paramsMap) throws Exception{
        //查询(现有权限,所有权限并组成树形结构)
        return roleService.empowermentAuthority(paramsMap);
    }
    /**
     * 角色分配权限
     */
    @RequiresPermissions(value = {"/role/empowermentAuthority"})
    @RequestMapping(value = "saveEmpowermentAuthority", method = RequestMethod.POST)
    public @ResponseBody Map saveEmpowermentAuthority(@RequestParam Map<String, Object> paramsMap) throws Exception{
        return roleService.saveEmpowermentAuthority(paramsMap);
    }
}
