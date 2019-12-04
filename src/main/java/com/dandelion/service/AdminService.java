package com.dandelion.service;

import com.dandelion.bean.Admin;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;

import java.util.List;
import java.util.Map;

/**
 * className AdminService
 * description Admin管理Service
 *
 * @author puyiliang
 * @date 2019/10/18 17:56
 */
public interface AdminService {
    /**
     * 用户登录
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    Map loginAdmin(Map<String, String> paramsMap) throws Exception;

    /**
     * 通过用户Id 获取权限列表
     *
     * @param authorityParams Map
     * @param type            String
     * @return List
     * @throws Exception Exception
     */
    List<Authority> getAuthorityByAdminId(Map<String, String> authorityParams, String type) throws Exception;

    /**
     * 通过用户登录姓名 获取用户对象
     *
     * @param adminName String
     * @return Admin
     * @throws Exception e
     */
    Admin getAdminByAdminName(String adminName) throws Exception;

    /**
     * 通过用户Id 获取角色列表
     *
     * @param authorityParams Map
     * @return List
     * @throws Exception Exception
     */
    List<Role> getRoleByAdminId(Map<String, String> authorityParams) throws Exception;

    /**
     * 查看所有用户
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    Map getAdminList(Map<String, String> paramsMap) throws Exception;

    /**
     * 查询分配权限 回显
     *
     * @param paramsMap Map
     * @return Admin
     * @throws Exception Exception
     */
    Admin getAdminById(Map<String, String> paramsMap) throws Exception;

    /**
     * 新增 / 修改用户
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map saveAdmin(Map<String, String> paramsMap) throws Exception;

    /**
     * 查询分配权限 回显
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    Map empowermentRole(Map<String, String> paramsMap) throws Exception;

    /**
     * 用户分配角色
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    Map saveEmpowermentRole(Map<String, Object> paramsMap) throws Exception;

    /**
     * 删除用户
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    Map deleteAdmin(Map<String, String> paramsMap) throws Exception;

    /**
     * 用户启用/停用 修改用户状态
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception Exception
     */
    Map changeAdminStatus(Map<String, String> paramsMap) throws Exception;

    /**
     * 查询登录信息
     *
     * @return Map
     * @throws Exception Exception
     */
    Map getIndexConfig() throws Exception;

    /**
     * 清除服务器缓存
     *
     * @return Map
     * @throws Exception e
     */
    Map clearCache() throws Exception;

    /**
     * 修改密码
     *
     * @param paramsMap
     * @return Map
     * @throws Exception e
     */
    Map savePassword(Map<String, String> paramsMap) throws Exception;
}
