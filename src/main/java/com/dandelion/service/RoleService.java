package com.dandelion.service;

import com.dandelion.bean.Role;

import java.util.Map;

/**
 * className RoleService
 * description
 * @author puyiliang
 * @date 2019/10/18 17:56
 */
public interface RoleService {
    /**
     * 角色列表 不带分页
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map getRoleList(Map<String,String> paramsMap) throws Exception;
    /**
     * 角色列表 带分页
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map getRolePageList(Map<String,String> paramsMap) throws Exception;
    /**
     * 根据角色ID查询角色信息 存入Session中
     * @param paramsMap Map
     * @return Role
     * @throws Exception e
     */
    Role getRoleById(Map<String, String> paramsMap) throws Exception;
    /**
     * 新增/修改 角色
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map saveRole(Map<String, String> paramsMap) throws Exception;
    /**
     * 删除角色
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map deleteRole(Map<String, String> paramsMap) throws Exception;
    /**
     * 角色分配权限回显
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map empowermentAuthority(Map<String, String> paramsMap) throws Exception;
    /**
     * 角色分配权限
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map saveEmpowermentAuthority(Map<String, Object> paramsMap) throws Exception;
}
