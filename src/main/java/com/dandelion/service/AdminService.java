package com.dandelion.service;

import com.dandelion.base.BaseService;
import com.dandelion.base.CommonMessage;
import com.dandelion.bean.Admin;
import com.dandelion.bean.AdminExample;
import com.dandelion.dao.AdminMapper;
import com.dandelion.utils.ObjectUtil;
import com.dandelion.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ClassName: AdminService
 * date:      2019/8/13 10:54
 * author:    puyiliang
 * description: AdminService
 */
@Service
public class AdminService extends BaseService<Admin, Integer>{

    @Resource
    private AdminMapper adminMapper;

    /**
     * 查看所有用户
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    public Map selectAdminPageList(Map<String,String> paramsMap) throws Exception{
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        //查询条件
        this.getSearchExample(paramsMap, criteria,"Admin");
        //分页
        startPage(paramsMap);
        List<Admin> adminList = adminMapper.selectByExample(example);
        PageInfo<Admin> pageInfo = new PageInfo<>(adminList);
        long total = pageInfo.getTotal();
        return pageResult(adminList, total);
    }

    /**
     * 用户登录
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    public Map loginAdmin(Map<String, String> paramsMap) throws Exception{
        String adminName = paramsMap.get("adminName");
        String adminPassword = paramsMap.get("adminPassword");
        if (ObjectUtil.isNull(adminName) || ObjectUtil.isNull(adminPassword)){
            return errorResult(CommonMessage.PARAMSERROR,"用户名和密码不能为空");
        }
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        getSearchExample("equalToAdminName",adminName,criteria,"Admin");
        List<Admin> adminList = adminMapper.selectByExample(example);
        if (ObjectUtil.isNull(adminList)){
            return errorResult(CommonMessage.PARAMSERROR,"用户名错误");
        }
        Admin admin = adminList.get(0);
        if(!StringUtil.verify(adminPassword, admin.getAdminPassword())){
            return errorResult(CommonMessage.PARAMSERROR,"密码错误");
        }
        return successResult("登录成功");
    }
}
