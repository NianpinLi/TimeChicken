package com.dandelion.controller;

import com.dandelion.base.BaseController;
import com.dandelion.service.AuthorityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

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
    @RequestMapping(value = "authorityPage", method = RequestMethod.GET)
    public String authorityPage(){
        return this.disPlay();
    }

}
