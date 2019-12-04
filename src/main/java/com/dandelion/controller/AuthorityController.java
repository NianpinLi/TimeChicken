package com.dandelion.controller;

import com.dandelion.base.BaseController;
import com.dandelion.bean.Authority;
import com.dandelion.service.AuthorityService;
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
 * AuthorityController
 *
 * @author puyiliang
 * 权限控制管理模块
 * @date 2019/9/20 17:17
 */
@RequestMapping("/authority")
@Controller
public class AuthorityController extends BaseController {
    @Resource
    private AuthorityService authorityService;

    /**
     * 跳转权限管理页面
     *
     * @return String
     */
    @RequiresPermissions("/authority/getAuthority")
    @RequestMapping(value = "getAuthority", method = RequestMethod.GET)
    public String getAuthority() throws Exception {
        return this.disPlay();
    }

    /**
     * 查询所有权限列表
     */
    @RequiresPermissions("/authority/getAuthorityList")
    @RequestMapping(value = "getAuthorityList", method = RequestMethod.GET)
    public @ResponseBody
    Map getAuthorityList(@RequestParam Map<String, String> paramsMap) throws Exception {
        return authorityService.getAuthorityList(paramsMap);
    }

    /**
     * 跳转添加权限页面
     *
     * @return String
     */
    @RequiresPermissions("/authority/addAuthority")
    @RequestMapping(value = "addAuthority", method = RequestMethod.GET)
    public String addAuthority() {
        return this.disPlay();
    }

    /**
     * 查询分页权限列表
     */
    @RequiresPermissions("/authority/addAuthority")
    @RequestMapping(value = "getAuthorityPageList", method = RequestMethod.GET)
    public @ResponseBody
    Map getAuthorityPageList(@RequestParam Map<String, String> paramsMap) throws Exception {
        return authorityService.getAuthorityPageList(paramsMap);
    }

    /**
     * 跳转修改权限页面
     *
     * @return String
     */
    @RequiresPermissions("/authority/updateAuthority")
    @RequestMapping(value = "updateAuthority", method = RequestMethod.GET)
    public String updateAuthority(@RequestParam Map<String, String> paramsMap) throws Exception {
        //查询权限数据并存入作用域
        Authority authority = authorityService.getAuthorityById(paramsMap);
        this.setAttribute("authority", authority);
        return this.disPlay();
    }

    /**
     * 新增/修改 权限
     */
    @RequiresPermissions(value = {"/authority/addAuthority", "/authority/updateAuthority"}, logical = Logical.OR)
    @RequestMapping(value = "saveAuthority", method = RequestMethod.POST)
    public @ResponseBody
    Map saveAuthority(@RequestParam Map<String, String> paramsMap) throws Exception {
        return authorityService.saveAuthority(paramsMap);
    }

    /**
     * 删除权限
     */
    @RequestMapping(value = "deleteAuthority", method = RequestMethod.POST)
    public @ResponseBody
    Map deleteAuthority(@RequestParam Map<String, String> paramsMap) throws Exception {
        return authorityService.deleteAuthority(paramsMap);
    }
}
