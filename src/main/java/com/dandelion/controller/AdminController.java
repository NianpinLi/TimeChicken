package com.dandelion.controller;

import com.alibaba.fastjson.JSONObject;
import com.dandelion.Base.BaseController;
import com.dandelion.bean.Admin;
import com.dandelion.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ClassName: AdminController
 * date:      2019/8/13 10:26
 * author:    puyiliang
 * description: 用户管理Controller
 */
@RestController
@RequestMapping("admin")
public class AdminController extends BaseController {

    @Resource
    private AdminService adminService;

    @RequestMapping("selectAdminPageList")
    public String selectAdminPageList(@RequestParam Map<String,String> paramsMap) throws Exception{
        List<Admin> result = adminService.selectAdminPageList(paramsMap);
        Object toJSON = JSONObject.toJSON(result);
        return toJSON.toString();
    }

}
