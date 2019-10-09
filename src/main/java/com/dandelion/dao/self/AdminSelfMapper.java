package com.dandelion.dao.self;

import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;

import java.util.List;
import java.util.Map;

/**
 * ClassName: AdminSelfMapper
 * date:      2019/8/21 14:31
 * author:    puyiliang
 * description: 自定义用户Mapper
 */
public interface AdminSelfMapper {

    List<Authority> selectAuthorityByAdminId(Map<String,Integer> authorityParams);

    List<Role> selectRoleByAdminId(Map<String,Integer> authorityParams);
}
