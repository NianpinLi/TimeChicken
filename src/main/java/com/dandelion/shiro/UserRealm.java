package com.dandelion.shiro;

import com.dandelion.bean.Admin;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;
import com.dandelion.service.AdminService;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * ClassName: UserRealm
 * date:      2019/8/21 18:07
 * author:    puyiliang
 * description: Shiro 自定义Realm
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
        Admin user = new Admin();
        user.setAdminName(adminName);
        user.setAdminPassword(adminPassword);
        ByteSource salt = ByteSource.Util.bytes(user.getAdminName());//对用户名进行加盐
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
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
            token.getPrincipal(), //用户名
            admin.getAdminPassword(),//密码
            salt,//加盐
            getName()  //realm name
        );
        return authenticationInfo;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof Admin) {
            Admin admin = (Admin) principal;
            Set<String> roles = Sets.newHashSet();
            List<Role> roleList = adminService.getRoleByAdminId(admin.getAdminId());
            for (Role role : roleList) {
                roles.add(role.getRoleName());
            }
            //存入角色名称
            authorizationInfo.addRoles(roles);
            Set<String> permissions = Sets.newHashSet();
            List<Authority> authorityList = adminService.getAuthorityByAdminId(admin.getAdminId());
            for (Authority authority : authorityList) {
                permissions.add(authority.getAuthorityUrl());
            }
            //存入权限
            authorizationInfo.addStringPermissions(permissions);
        }
        return authorizationInfo;
    }
}