package com.dandelion.shiro;

import com.dandelion.bean.Admin;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;
import com.dandelion.service.AdminService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * UserRealm
 * @date      2019/8/21 18:07
 * @author    puyiliang
 *  Shiro 自定义Realm
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    private AdminService adminService;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken){
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String adminName = token.getUsername();
        String adminPassword = String.valueOf(token.getPassword());
        Admin reqAdmin = new Admin();
        reqAdmin.setAdminName(adminName);
        reqAdmin.setAdminPassword(adminPassword);
        // 从数据库获取对应用户名密码的用户
        Admin admin = null;
        try {
            admin = adminService.getAdminByAdminName(adminName);
        } catch (Exception e) {
            log.error("系统错误", e);
        }
        if (admin == null){
            throw new UnknownAccountException();
        }
        // 存入用户信息
        Object principal = adminName;
        //对用户名进行加盐
        ByteSource salt = ByteSource.Util.bytes(adminName);
        //验证密码
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, admin.getAdminPassword(), salt, getName());
        //当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("adminSession", admin);

        return authenticationInfo;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object principal = principals.oneByType(Admin.class);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof Admin) {
            Admin admin = (Admin) principal;
            Map<String,String> authorityParams = Maps.newHashMap();
            authorityParams.put("adminId",String.valueOf(admin.getAdminId()));
            List<Role> roleList = adminService.getRoleByAdminId(authorityParams);
            for (Role role : roleList) {
                //存入角色名称
                authorizationInfo.addRole(role.getRoleName());
            }
            authorityParams.put("adminId",String.valueOf(admin.getAdminId()));
            List<Authority> authorityList = adminService.getAuthorityByAdminId(authorityParams,"all_");
            for (Authority authority : authorityList) {
                //存入权限
                authorizationInfo.addStringPermission(authority.getAuthorityUrl());
            }
        }
        return authorizationInfo;
    }

}
