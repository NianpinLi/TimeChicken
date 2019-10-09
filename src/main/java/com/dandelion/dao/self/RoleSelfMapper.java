package com.dandelion.dao.self;

import com.dandelion.bean.Authority;

import java.util.List;
import java.util.Map;

/**
 * ClassName: RoleSelfMapper
 * date:      2019/10/8 9:23
 * author:    puyiliang
 * description: 角色自定义Mapper
 */
public interface RoleSelfMapper {

    List<Authority> selectAuthorityByAdminId(Map<String,String> authorityParams);

    List<Integer> selectAuthorityIdByRoleId(Map<String,String> authorityParams);
}
