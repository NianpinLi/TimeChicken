package com.dandelion.service;

import com.dandelion.bean.Admin;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;

import java.util.List;
import java.util.Map;

/**
 * className AdminService
 * description
 * @author puyiliang
 * @date 2019/10/18 17:56
 */
public interface AdminService {
    /**
     * 用户登录
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    Map loginAdmin(Map<String, String> paramsMap) throws Exception;

    /**
     * 通过用户Id 获取权限列表
     * @param authorityParams Map
     * @return List
     */
    List<Authority> getAuthorityByAdminId(Map<String,String> authorityParams, String page) throws Exception;

    /**
     * 通过用户登录姓名 获取用户对象
     * @param adminName String
     * @return Admin
     * @throws Exception e
     */
    Admin getAdminByAdminName(String adminName) throws Exception;

    /**
     * 通过用户Id 获取角色列表
     * @param authorityParams Map
     * @return List
     */
    List<Role> getRoleByAdminId(Map<String,String> authorityParams) throws Exception;
    /**
     * 查询登录人信息
     * @return Map
     */
    Map getIndexConfig() throws Exception;
    /**
     * 查看所有用户
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    Map getAdminList(Map<String, String> paramsMap) throws Exception;
    /**
     * 查询分配权限 回显
     * @param paramsMap Map
     */
    void getAdminById(Map<String, String> paramsMap) throws Exception;
    /**
     * 新增 / 修改用户
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map saveAdmin(Map<String, String> paramsMap) throws Exception;
    /**
     * 查询分配权限 回显
     * @param paramsMap Map
     */
    Map empowermentRole(Map<String, String> paramsMap) throws Exception;
    /**
     * 用户分配角色
     * @param paramsMap Map
     * @return Map
     */
    Map saveEmpowermentRole(Map<String, Object> paramsMap) throws Exception;
    /**
     * 删除用户
     * @param paramsMap Map
     * @return Map
     */
    Map deleteAdmin(Map<String, String> paramsMap) throws Exception;
    /**
     * 用户启用/停用 修改用户状态
     * @param paramsMap Map
     * @return Map
     */
    Map changeAdminStatus(Map<String, String> paramsMap) throws Exception;
}
