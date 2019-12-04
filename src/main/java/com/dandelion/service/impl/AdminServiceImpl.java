package com.dandelion.service.impl;

import com.alibaba.fastjson.JSON;
import com.dandelion.annotation.ReadOnlyConnection;
import com.dandelion.base.BaseRedisKey;
import com.dandelion.base.BaseServiceImpl;
import com.dandelion.base.CommonMessage;
import com.dandelion.bean.Admin;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;
import com.dandelion.bean.example.AdminExample;
import com.dandelion.dao.generator.AdminMapper;
import com.dandelion.dao.self.AdminSelfMapper;
import com.dandelion.service.AdminService;
import com.dandelion.utils.EncryptionUtil;
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
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AdminService
 *
 * @author puyiliang
 * AdminService
 * @date 2019/8/13 10:54
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, Integer> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private AdminSelfMapper adminSelfMapper;

    @Resource
    private RedisUtil redisUtil;

    private String managerId = "1";
    private String fieldName = "adminId";

    /**
     * 用户登录
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    @Override
    @ReadOnlyConnection
    public Map loginAdmin(Map<String, String> paramsMap) throws Exception {
        String adminName = paramsMap.get("adminName");
        String adminPassword = paramsMap.get("adminPassword");
        UsernamePasswordToken token = new UsernamePasswordToken(adminName, adminPassword);
        Subject subject = SecurityUtils.getSubject();
        try {
            //登陆
            subject.login(token);
        } catch (UnknownAccountException e) {
            return errorResult(CommonMessage.PARAMS_ERROR, "账号不存在", false);
        } catch (IncorrectCredentialsException e) {
            return errorResult(CommonMessage.PARAMS_ERROR, "密码不正确", false);
        } catch (AuthenticationException e) {
            return errorResult(CommonMessage.PARAMS_ERROR, "用户验证失败", false);
        }
        return successResult("登录成功", false);
    }

    /**
     * 通过用户Id 获取权限列表
     *
     * @param authorityParams Map
     * @return List
     */
    @Override
    @ReadOnlyConnection
    public List<Authority> getAuthorityByAdminId(Map<String, String> authorityParams, String page) throws Exception {
        String key = BaseRedisKey.ADMIN_AUTHORITY + page + authorityParams.get("adminId");
        List<Authority> list = redisUtil.getList(key, Authority.class);
        if (list != null) {
            return list;
        }
        //拥有所有权限
        if (managerId.equals(authorityParams.get(fieldName))) {
            authorityParams.put("adminId", null);
        }
        List<Authority> authorityList = adminSelfMapper.selectAuthorityByAdminId(authorityParams);
        redisUtil.set(key, authorityList);
        return authorityList;
    }

    /**
     * 通过用户Id 获取角色列表
     *
     * @param authorityParams Map
     * @return List
     */
    @Override
    @ReadOnlyConnection
    public List<Role> getRoleByAdminId(Map<String, String> authorityParams) throws Exception {
        String key = BaseRedisKey.ADMIN_ROLE + authorityParams.get("adminId");
        List<Role> list = redisUtil.getList(key, Role.class);
        if (list != null) {
            return list;
        }
        //拥有所有角色
        if (managerId.equals(authorityParams.get(fieldName))) {
            authorityParams.put("adminId", null);
        }
        List<Role> roleList = adminSelfMapper.selectRoleByAdminId(authorityParams);
        redisUtil.set(key, roleList);
        return roleList;
    }

    /**
     * 通过用户登录姓名 获取用户对象
     *
     * @param adminName String
     * @return Admin
     * @throws Exception e
     */
    @Override
    @ReadOnlyConnection
    public Admin getAdminByAdminName(String adminName) throws Exception {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        setExample("equalToAdminName", adminName, criteria, "Admin");
        setExample("equalToAdminStatus", "1", criteria, "Admin");
        List<Admin> adminList = adminMapper.selectByExample(example);
        if (ObjectUtil.isNull(adminList)) {
            return null;
        }
        return adminList.get(0);
    }

    /**
     * 查看所有用户
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    @Override
    @ReadOnlyConnection
    public Map getAdminList(Map<String, String> paramsMap) throws Exception {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        //查询条件
        this.setExample(paramsMap, criteria, "Admin");
        //分页
        startPage(paramsMap);
        List<Admin> adminList = adminMapper.selectByExample(example);
        PageInfo<Admin> pageInfo = new PageInfo<>(adminList);
        long total = pageInfo.getTotal();
        return pageResult(adminList, total);
    }

    /**
     * 新增 / 修改用户
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map saveAdmin(Map<String, String> paramsMap) throws Exception {
        Admin admin = JSON.parseObject(JSON.toJSONString(paramsMap), Admin.class);
        if (ObjectUtil.isNull(admin.getAdminId())) {
            //存入添加信息
            this.setCreateInfo(admin, this.getLoginAdmin());
            //对用户名进行加盐
            ByteSource salt = ByteSource.Util.bytes(admin.getAdminName());
            //密码加密
            admin.setAdminPassword(EncryptionUtil.encryptPassword("MD5", admin.getAdminPassword(), salt, 3));
            //判断是否存在角色ID 不存在新增
            adminMapper.insertSelective(admin);
        } else {
            //存在修改
            adminMapper.updateByPrimaryKeySelective(admin);
        }
        return this.successResult(true);
    }

    /**
     * 根据AdminId 查询Admin
     *
     * @param paramsMap Map
     * @return Admin
     * @throws Exception e
     */
    @Override
    @ReadOnlyConnection
    public Admin getAdminById(Map<String, String> paramsMap) throws Exception {
        return adminMapper.selectByPrimaryKey(Integer.parseInt(paramsMap.get("adminId")));
    }

    /**
     * 查询分配权限 回显
     *
     * @param paramsMap Map
     */
    @Override
    @ReadOnlyConnection
    public Map empowermentRole(Map<String, String> paramsMap) {
        //查询当前用户拥有的角色
        List<Integer> roleList = adminSelfMapper.selectRoleIdByAdminId(paramsMap);
        paramsMap.remove("adminId");
        if (this.getLoginAdmin().getAdminId() != 1) {
            //非顶级登录人,查询当前登录人拥有的角色
            paramsMap.put("adminId", String.valueOf(this.getLoginAdmin().getAdminId()));
        }
        List<Role> allRoleList = adminSelfMapper.selectRoleByAdminId(paramsMap);
        List<Map<String, Object>> zTreeNode = Lists.newArrayList();
        HashMap<Integer, Map<String, Object>> roleMap = Maps.newHashMap();
        allRoleList.forEach(role -> {
            Map<String, Object> map = Maps.newHashMap();
            map.put("value", role.getRoleId());
            map.put("title", role.getRoleName());
            map.put("data", Lists.newArrayList());
            map.put("parent", false);
            Integer parentId = role.getParentRoleId();
            Integer roleId = role.getRoleId();
            roleMap.put(roleId, map);
            if (roleList.contains(roleId)) {
                map.put("checked", true);
            }
            //非顶级菜单
            Map<String, Object> parent = roleMap.get(parentId);
            if (parent != null) {
                ((List<Map<String, Object>>) parent.get("data")).add(map);
            } else {
                zTreeNode.add(map);
            }
        });

        return this.successResult(zTreeNode, false);
    }

    /**
     * 用户分配角色
     *
     * @param paramsMap Map
     * @return Map
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map saveEmpowermentRole(Map<String, Object> paramsMap) {
        //删除用户所拥有所有角色
        Integer adminId = Integer.parseInt(String.valueOf(paramsMap.get("adminId")));
        adminSelfMapper.deleteRoleByAdminId(adminId);
        //添加新的权限
        String roleIds = String.valueOf(paramsMap.get("roleIds"));
        if (!ObjectUtil.isNull(roleIds)) {
            List<String> roleIdList = Lists.newArrayList();
            String splitRegex = ",";
            for (String roleId : roleIds.split(splitRegex)) {
                if (!ObjectUtil.isNull(roleId) && !"on".equals(roleId)) {
                    roleIdList.add(roleId);
                }
            }
            if (roleIdList.size() > 0) {
                paramsMap.put("roleIdList", roleIdList);
                adminSelfMapper.insertRoleByAdminId(paramsMap);
            }
        }
        return successResult(true);
    }

    /**
     * 用户启用/停用 修改用户状态
     *
     * @param paramsMap Map
     * @return Map
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map changeAdminStatus(Map<String, String> paramsMap) throws Exception {
        String adminIds = paramsMap.get("inAdminId");
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        //处理ID
        if (!ObjectUtil.isNull(adminIds)) {
            this.setExample(paramsMap, criteria, "Admin");
            adminSelfMapper.updateStatusByExample(adminExample);
        }
        return this.successResult(false);
    }

    /**
     * 删除用户
     *
     * @param paramsMap Map
     * @return Map
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map deleteAdmin(Map<String, String> paramsMap) throws Exception {
        String adminIds = paramsMap.get("inAdminId");
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        //处理ID
        if (!ObjectUtil.isNull(adminIds)) {
            this.setExample(paramsMap, criteria, "Admin");
            adminMapper.deleteByExample(adminExample);
        }
        return this.successResult(false);
    }

    /**
     * 查询登录人信息
     *
     * @return Map
     */
    @Override
    @ReadOnlyConnection
    public Map<String, Object> getIndexConfig() throws Exception {
        Map<String, Object> indexConfig = Maps.newHashMap();

        //清除缓存配置
        HashMap<String, Object> clearInfo = Maps.newHashMap();
        clearInfo.put("clearUrl", "/admin/clearCache");
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

        indexConfig.put("clearInfo", clearInfo);
        indexConfig.put("homeInfo", homeInfo);
        indexConfig.put("logoInfo", logoInfo);
        indexConfig.put("menuInfo", menuInfo);
        return indexConfig;
    }

    /**
     * 清除缓存
     *
     * @return Map
     * @throws Exception e
     */
    @Override
    public Map clearCache() throws Exception {
        Admin admin = this.getLoginAdmin();
        Integer adminId = admin.getAdminId();
        redisUtil.delete("admin_authority_all_" + adminId);
        redisUtil.delete("admin_authority_page_" + adminId);
        redisUtil.delete("admin_role_" + adminId);
        return successResult("清除服务器缓存成功", false);
    }

    /**
     * 修改密码
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @Override
    public Map savePassword(Map<String, String> paramsMap) throws Exception {
        String newPasswordKey = "newPassword";
        String againPasswordKey = "againPassword";
        if (!paramsMap.get(newPasswordKey).equals(paramsMap.get(againPasswordKey))) {
            return errorResult(CommonMessage.ERROR, "新密码不一致", false);
        }
        Admin admin = this.getLoginAdmin();
        //对用户名进行加盐
        ByteSource salt = ByteSource.Util.bytes(admin.getAdminName());
        //密码加密
        String password = EncryptionUtil.encryptPassword("MD5", paramsMap.get("oldPassword"), salt, 3);
        if (!password.equals(admin.getAdminPassword())) {
            return errorResult(CommonMessage.ERROR, "原密码错误", false);
        }
        Admin updateAdmin = new Admin();
        updateAdmin.setAdminId(admin.getAdminId());
        updateAdmin.setAdminPassword(EncryptionUtil.encryptPassword("MD5", paramsMap.get("newPassword"), salt, 3));
        adminMapper.updateByPrimaryKeySelective(updateAdmin);
        //清除缓存
        clearCache();
        return successResult(true);
    }

    /**
     * 获取当前登录用户的权限
     *
     * @return Map
     * @throws Exception e
     */
    @ReadOnlyConnection
    private Map getAuthority() throws Exception {
        Admin admin = (Admin) this.getSession("adminSession");
        //查询页面权限
        Map<String, String> authorityParams = Maps.newHashMap();
        authorityParams.put("adminId", String.valueOf(admin.getAdminId()));
        authorityParams.put("authorityType", "1");
        List<Authority> authorityList = this.getAuthorityByAdminId(authorityParams, "page_");
        HashMap<Integer, Map<String, Object>> authorityMap = Maps.newHashMap();
        HashMap<Integer, Map<String, Object>> authorityMenuMap = Maps.newHashMap();
        for (Authority authority : authorityList) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("title", authority.getAuthorityName());
            map.put("icon", authority.getAuthorityIcon());
            if (authority.getAuthorityUrl() != null && !"#".equals(authority.getAuthorityUrl())) {
                map.put("href", authority.getAuthorityUrl());
                map.put("target", "_self");
            } else {
                map.put("child", Lists.newArrayList());
            }
            Integer parentId = authority.getParentAuthorityId();
            Integer authorityId = authority.getAuthorityId();
            authorityMap.put(authorityId, map);
            if (parentId != -1) {
                //非顶级菜单
                Map parent = authorityMap.get(parentId);
                if (parent != null) {
                    ((List) parent.get("child")).add(map);
                }
            } else {
                //顶级菜单
                authorityMenuMap.put(authorityId, map);
            }
        }
        return authorityMenuMap;
    }
}
