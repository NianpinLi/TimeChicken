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
import com.dandelion.vo.AuthorityVo;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
     * @param authorityParams Map
     */
    public List<Authority> getAuthorityByAdminId(Map<String,Integer> authorityParams){
        return adminSelfMapper.selectAuthorityByAdminId(authorityParams);
    }

    /**
     * 通过用户Id 获取角色列表
     * @param adminId Integer
     */
    public List<Role> getRoleByAdminId(Integer adminId){
        return adminSelfMapper.selectRoleByAdminId(adminId);
    }

    /**
     * 通过用户登录姓名 获取用户对象
     * @param adminName String
     * @return Admin
     * @throws Exception e
     */
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
     * 查询登录人信息
     * @return Map
     */
    public Map getIndexConfig() throws Exception{
        Map indexConfig = Maps.newHashMap();

        //清除缓存配置
        HashMap<String, Object> clearInfo = Maps.newHashMap();
        clearInfo.put("clearUrl", "/layui/api/clear.json");
        //欢迎页面配置
        HashMap<String, Object> homeInfo = Maps.newHashMap();
        homeInfo.put("title", "首页");
        homeInfo.put("icon", "fa fa-home");
        homeInfo.put("href", "/common/welcome");
        //Logo配置
        HashMap<String, Object> logoInfo = Maps.newHashMap();
        logoInfo.put("title", "Family");
        logoInfo.put("image", "/layui/images/logo.png");
        logoInfo.put("href", "");
        //菜单权限配置
        Map menuInfo = this.getAuthority();

        indexConfig.put("clearInfo",clearInfo);
        indexConfig.put("homeInfo",homeInfo);
        indexConfig.put("logoInfo",logoInfo);
        indexConfig.put("menuInfo",menuInfo);
        return indexConfig;
    }

    //获取权限
    private Map getAuthority(){
        Subject subject = SecurityUtils.getSubject();
        Admin admin = subject.getPrincipals().oneByType(Admin.class);
        //查询页面权限
        Map<String,Integer> authorityParams = Maps.newHashMap();
        authorityParams.put("adminId",admin.getAdminId());
        authorityParams.put("authorityType",1);
        List<Authority> AuthorityList = this.getAuthorityByAdminId(authorityParams);
        HashMap<Integer, Map> authorityMap = Maps.newHashMap();
        HashMap<Integer, Map> authorityMenuMap = Maps.newHashMap();
        for (Authority authority : AuthorityList) {
            Map map = getAuthorityMap(authority);
            Integer parentId = authority.getParentAuthorityId();
            Integer authorityId = authority.getAuthorityId();
            authorityMap.put(authorityId, map);
            if (parentId != 0){
                //非顶级菜单
                Map parent = authorityMap.get(parentId);
                if (parent != null){
                    ((List)parent.get("child")).add(map);
                }
            }else{
                //顶级菜单
                authorityMenuMap.put(authorityId,map);
            }
        }
        return authorityMenuMap;
    }

    private Map getAuthorityMap(Authority authority){
        Map authorityMap = Maps.newHashMap();
        authorityMap.put("title",authority.getAuthorityName());
        authorityMap.put("icon",authority.getAuthorityIcon());
        if (authority.getAuthorityUrl() != null && !"#".equals(authority.getAuthorityUrl())){
            authorityMap.put("href",authority.getAuthorityUrl());
            authorityMap.put("target","_self");
        }else {
            authorityMap.put("child",Lists.newArrayList());
        }
        return authorityMap;
    }
}
