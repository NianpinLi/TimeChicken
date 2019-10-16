package com.dandelion.dao.self;

import com.dandelion.bean.AdminExample;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: AdminSelfMapper
 * @date:      2019/8/21 14:31
 * @author:    puyiliang
 * @description: 自定义用户Mapper
 */
public interface AdminSelfMapper {

    /**
     * 根据AdminId查询权限列表
     * @param authorityParams Map
     * @return list
     */
    List<Authority> selectAuthorityByAdminId(Map<String,String> authorityParams);
    /**
     * 根据AdminId 查询角色
     * @param authorityParams Map
     * @return list
     */
    List<Role> selectRoleByAdminId(Map<String,String> authorityParams);
    /**
     * 根据AdminId查询角色Id
     * @param paramsMap Map
     * @return list
     */
    List<Integer> selectRoleIdByAdminId(Map<String, String> paramsMap);
    /**
     * 根据AdminId删除用户角色中间表
     * @param adminId Integer
     */
    void deleteRoleByAdminId(Integer adminId);
    /**
     * 根据AdminId添加用户角色中间表
     * @param paramsMap Map
     */
    void insertRoleByAdminId(Map<String, Object> paramsMap);
    /**
     * 修改用户状态
     * @param example AdminExample
     */
    void updateStatusByExample(@Param("example") AdminExample example);
}
