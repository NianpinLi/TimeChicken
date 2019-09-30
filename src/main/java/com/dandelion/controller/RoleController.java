package com.dandelion.controller;

import com.dandelion.base.BaseController;
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
 * ClassName: AdminController
 * date:      2019/8/13 10:26
 * author:    puyiliang
 * description: 角色管理Controller
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
    @RequiresPermissions("/role/getRolePage")
    @RequestMapping(value = "getRolePage", method = RequestMethod.GET)
    public String getRolePage() throws Exception{
        return this.disPlay();
    }

    /**
     * 查询角色列表
     * @param map Map
     * @return Map
     */
    @RequiresPermissions("/role/getRoleList")
    @RequestMapping(value = "getRoleList", method = RequestMethod.GET)
    public @ResponseBody Map getRoleList(@RequestParam Map map) throws Exception{
        return roleService.getRoleList(map);
    }

    /**
     * 跳转角色添加页面
     * @return String
     */
    @RequiresPermissions("/role/addRolePage")
    @RequestMapping(value = "addRolePage", method = RequestMethod.GET)
    public String addRolePage() throws Exception{
        return this.disPlay();
    }

    /**
     * 跳转角色修改页面
     * @return String
     */
    @RequiresPermissions("/role/updateRolePage")
    @RequestMapping(value = "updateRolePage", method = RequestMethod.GET)
    public String updateRolePage(@RequestParam Map<String, String> paramsMap){
        //查询权限数据并存入作用域
        roleService.getRoleById(paramsMap);
        return this.disPlay();
    }

    /**
     * 新增/修改 权限
     */
    @RequiresPermissions(value = {"/role/addRolePage","/role/updateRolePage"},logical= Logical.OR)
    @RequestMapping(value = "saveRole", method = RequestMethod.POST)
    public @ResponseBody Map saveRole(@RequestParam Map<String, String> paramsMap) throws Exception{
        return roleService.saveRole(paramsMap);
    }

    /**
     * 删除权限
     */
    @RequestMapping(value = "deleteRole", method = RequestMethod.POST)
    public @ResponseBody Map deleteRole(@RequestParam Map<String, String> paramsMap) throws Exception{
        return roleService.deleteRole(paramsMap);
    }
}
