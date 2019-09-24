package com.dandelion.controller;

import com.dandelion.base.BaseController;
import com.dandelion.service.AuthorityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ClassName: AuthorityController
 * date:      2019/9/20 17:17
 * author:    puyiliang
 * description: 权限控制管理模块
 */
@RequestMapping("/authority")
@Controller
public class AuthorityController extends BaseController {
    @Resource
    private AuthorityService authorityService;

    /**
     * 跳转权限管理页面
     * @return String
     */
    @RequiresPermissions("/authority/authorityPage")
    @RequestMapping(value = "authorityPage", method = RequestMethod.GET)
    public String authorityPage(){
        return this.disPlay();
    }
    /**
     * 跳转添加权限页面
     * @return String
     */
    @RequiresPermissions("/authority/addAuthorityPage")
    @RequestMapping(value = "addAuthorityPage", method = RequestMethod.GET)
    public String addAuthorityPage(){
        return this.disPlay();
    }
    /**
     * 查询所有权限列表
     */
    @RequiresPermissions("/authority/authorityList")
    @RequestMapping(value = "authorityList", method = RequestMethod.GET)
    public @ResponseBody Map authorityList(@RequestParam Map<String, String> paramsMap) throws Exception{
        return authorityService.authorityList(paramsMap);
    }
    /**
     * 查询分页权限列表
     */
    @RequestMapping(value = "authorityPageList", method = RequestMethod.GET)
    public @ResponseBody Map authorityPageList(@RequestParam Map<String, String> paramsMap) throws Exception{
        return authorityService.authorityPageList(paramsMap);
    }
    /**
     * 新增权限
     */
    @RequiresPermissions("/authority/addAuthorityPage")
    @RequestMapping(value = "saveAuthority", method = RequestMethod.POST)
    public @ResponseBody Map saveAuthority(@RequestParam Map<String, String> paramsMap) throws Exception{
        return authorityService.saveAuthority(paramsMap);
    }

    /**
     * 删除权限
     */
    @RequestMapping(value = "deleteAuthority", method = RequestMethod.POST)
    public @ResponseBody Map deleteAuthority(@RequestParam Map<String, String> paramsMap) throws Exception{
        return authorityService.deleteAuthority(paramsMap);
    }

    /**
     * 跳转修改权限页面
     * @return String
     */
    @RequiresPermissions("/authority/updateAuthorityPage")
    @RequestMapping(value = "updateAuthorityPage", method = RequestMethod.GET)
    public String updateAuthorityPage(@RequestParam Map<String, String> paramsMap){
        //查询权限数据并存入作用域
        authorityService.getAuthorityById(paramsMap);
        return this.disPlay();
    }

    /**
     * 跳转添加权限页面
     * @return String
     */
    @RequiresPermissions("/authority/updateAuthority")
    @RequestMapping(value = "updateAuthority", method = RequestMethod.GET)
    public String updateAuthority(){
        return this.disPlay();
    }

}
