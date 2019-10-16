package com.dandelion.dao.self;

import com.dandelion.bean.Authority;

import java.util.List;
import java.util.Map;

/**
 * RoleSelfMapper
 * @date      2019/10/8 9:23
 * @author    puyiliang
 *  角色自定义Mapper
 */
public interface RoleSelfMapper {

    /**
     * 根据AdminId查询权限
     * @param authorityParams Map
     * @return List
     */
    List<Authority> selectAuthorityByAdminId(Map<String,String> authorityParams);

    /**
     * 根据roleId查询权限Id
     * @param authorityParams Map
     * @return List
     */
    List<Integer> selectAuthorityIdByRoleId(Map<String,String> authorityParams);

    /**
     * 根据RoleId删除 角色权限中间表
     * @param roleId Integer
     */
    void deleteAuthorityByRoleId(Integer roleId);

    /**
     * 根据roleId新增角色权限中间表
     * @param paramsMap Map
     */
    void insertAuthorityByRoleId(Map<String, Object> paramsMap);
}
