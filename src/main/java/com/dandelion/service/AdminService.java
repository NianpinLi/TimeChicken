package com.dandelion.service;

import com.dandelion.base.BaseService;
import com.dandelion.base.CommonMessage;
import com.dandelion.bean.Admin;
import com.dandelion.bean.AdminExample;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;
import com.dandelion.dao.generator.AdminMapper;
import com.dandelion.dao.self.AdminSelfMapper;
import com.dandelion.utils.ObjectUtil;
import com.dandelion.utils.RedisUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

    @Resource
    private AdminSelfMapper adminSelfMapper;

    @Resource
    private RedisUtil redisUtil;

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
        UsernamePasswordToken token = new UsernamePasswordToken(adminName, adminPassword);
        Subject subject = SecurityUtils.getSubject();
        try {
            //登陆
            subject.login(token);
            //查询权限 将其存入session 中
        }catch (UnknownAccountException e){
            return errorResult(CommonMessage.PARAMSERROR,"账号不存在");
        }catch (IncorrectCredentialsException e){
            return errorResult(CommonMessage.PARAMSERROR,"密码不正确");
        }catch (AuthenticationException e) {
            return errorResult(CommonMessage.PARAMSERROR,"用户验证失败");
        }
        return successResult("登录成功");
    }

    /**
     * 通过用户Id 获取权限列表
     * @param adminId Integer
     */
    public List<Authority> getAuthorityByAdminId(Integer adminId){
        return adminSelfMapper.selectAuthorityByAdminId(adminId);
    }

    /**
     * 通过用户Id 获取角色列表
     * @param adminId Integer
     */
    public List<Role> getRoleByAdminId(Integer adminId){
        return adminSelfMapper.selectRoleByAdminId(adminId);
    }

    public Admin getAdminByAdminName(String adminName) throws Exception{
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        getSearchExample("equalToAdminName",adminName,criteria,"Admin");
        List<Admin> adminList = adminMapper.selectByExample(example);
        if (ObjectUtil.isNull(adminList)){
            return null;
        }
        return adminList.get(0);
    }
}
