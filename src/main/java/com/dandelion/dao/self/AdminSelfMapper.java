package com.dandelion.dao.self;

import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;

import java.util.List;

/**
 * ClassName: AdminSelfMapper
 * date:      2019/8/21 14:31
 * author:    puyiliang
 * description: 权限查询
 */
public interface AdminSelfMapper {
    List<Authority> selectAuthorityByAdminId(Integer adminId);
    List<Role> selectRoleByAdminId(Integer adminId);
}
