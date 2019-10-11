package com.dandelion.service;

import com.alibaba.fastjson.JSON;
import com.dandelion.base.BaseService;
import com.dandelion.base.CommonMessage;
import com.dandelion.bean.Admin;
import com.dandelion.bean.AdminExample;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;
import com.dandelion.dao.generator.AdminMapper;
import com.dandelion.dao.self.AdminSelfMapper;
import com.dandelion.utils.DateUtil;
import com.dandelion.utils.ObjectUtil;
import com.dandelion.utils.RedisUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
            return errorResult(CommonMessage.PARAMS_ERROR,"账号不存在",false);
        }catch (IncorrectCredentialsException e){
            return errorResult(CommonMessage.PARAMS_ERROR,"密码不正确",false);
        }catch (AuthenticationException e) {
            return errorResult(CommonMessage.PARAMS_ERROR,"用户验证失败",false);
        }
        return successResult("登录成功",false);
    }

    /**
     * 通过用户Id 获取权限列表
     * @param authorityParams Map
     * @return List
     */
    public List<Authority> getAuthorityByAdminId(Map<String,String> authorityParams){
        //拥有所有权限
        if("1".equals(authorityParams.get("adminId"))){
            authorityParams.put("adminId",null);
        }
        return adminSelfMapper.selectAuthorityByAdminId(authorityParams);
    }

    /**
     * 通过用户Id 获取角色列表
     * @param authorityParams Map
     * @return List
     */
    public List<Role> getRoleByAdminId(Map<String,String> authorityParams){
        //拥有所有角色
        if("1".equals(authorityParams.get("adminId"))){
            authorityParams.put("adminId",null);
        }
        return adminSelfMapper.selectRoleByAdminId(authorityParams);
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
        Map<String,String> authorityParams = Maps.newHashMap();
        authorityParams.put("adminId",String.valueOf(admin.getAdminId()));
        authorityParams.put("authorityType","1");
        List<Authority> AuthorityList = this.getAuthorityByAdminId(authorityParams);
        HashMap<Integer, Map> authorityMap = Maps.newHashMap();
        HashMap<Integer, Map> authorityMenuMap = Maps.newHashMap();
        for (Authority authority : AuthorityList) {
            Map map  = Maps.newHashMap();
            map.put("title",authority.getAuthorityName());
            map.put("icon",authority.getAuthorityIcon());
            if (authority.getAuthorityUrl() != null && !"#".equals(authority.getAuthorityUrl())){
                map.put("href",authority.getAuthorityUrl());
                map.put("target","_self");
            }else {
                map.put("child",Lists.newArrayList());
            }
            Integer parentId = authority.getParentAuthorityId();
            Integer authorityId = authority.getAuthorityId();
            authorityMap.put(authorityId, map);
            if (parentId != -1){
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


    /**
     * 查看所有用户
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    public Map getAdminList(Map<String,String> paramsMap) throws Exception{
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
     * 新增 / 修改用户
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    public Map saveAdmin(Map<String, String> paramsMap) throws Exception{
        Admin admin = JSON.parseObject(JSON.toJSONString(paramsMap), Admin.class);
        if(ObjectUtil.isNull(admin.getAdminId())){
            //存入添加信息
            admin.setCreateName(this.getLoginAdmin().getRealName());
            admin.setCreateId(this.getLoginAdmin().getAdminId());
            admin.setCreateTime(DateUtil.getNowDate_EN());
            //判断是否存在角色ID 不存在新增
            adminMapper.insertSelective(admin);
        }else{
            //存在修改
            adminMapper.updateByPrimaryKeySelective(admin);
        }
        return this.successResult(true);
    }

    /**
     * 根据AdminId 查询Admin
     * @param paramsMap Map
     */
    public void getAdminById(Map<String, String> paramsMap) throws Exception{
        Admin admin = adminMapper.selectByPrimaryKey(Integer.parseInt(paramsMap.get("adminId")));
        this.setAttribute("admin",admin);
    }

    /**
     * 查询分配权限 回显
     * @param paramsMap Map
     */
    public Map empowermentRole(Map<String, String> paramsMap) {
        //查询当前用户拥有的角色
        List<Integer> roleList = adminSelfMapper.selectRoleIdByAdminId(paramsMap);

        if(this.getLoginAdmin().getAdminId() != 1){
            //非顶级登录人,查询当前登录人拥有的角色
            paramsMap.put("adminId",String.valueOf(this.getLoginAdmin().getAdminId()));
        }
        List<Role> allRoleList = adminSelfMapper.selectRoleByAdminId(paramsMap);
        List zTreeNode = Lists.newArrayList();
        HashMap<Integer, Map> roleMap = Maps.newHashMap();
        allRoleList.forEach(role -> {
            Map<String, Object> map = Maps.newHashMap();
            map.put("value",role.getRoleId());
            map.put("title",role.getRoleName());
            map.put("data",Lists.newArrayList());
            Integer parentId = role.getParentRoleId();
            Integer roleId = role.getRoleId();
            roleMap.put(roleId,map);
            if (roleList.contains(roleId.intValue())){
                map.put("checked",true);
            }
            //非顶级菜单
            Map parent = roleMap.get(parentId);
            if (parent != null){
                ((List)parent.get("data")).add(map);
            }else{
                zTreeNode.add(map);
            }
        });

        return this.successResult(zTreeNode,false);
    }

    public Map saveEmpowermentRole(Map<String, Object> paramsMap) {
        //删除用户所拥有所有角色
        Integer adminId = Integer.parseInt(String.valueOf(paramsMap.get("adminId")));
        adminSelfMapper.deleteRoleByAdminId(adminId);
        //添加新的权限
        String roleIds = String.valueOf(paramsMap.get("roleIds"));
        if (!ObjectUtil.isNull(roleIds)){
            List roleIdList = Lists.newArrayList();
            for (String roleId : roleIds.split(",")) {
                if (!ObjectUtil.isNull(roleId) && !"on".equals(roleId)){
                    roleIdList.add(roleId);
                }
            }
            if (roleIdList.size() > 0){
                paramsMap.put("roleIdList",roleIdList);
                adminSelfMapper.insertRoleByAdminId(paramsMap);
            }
        }
        return successResult(true);
    }
}
