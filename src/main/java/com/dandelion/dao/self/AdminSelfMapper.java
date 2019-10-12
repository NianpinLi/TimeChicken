package com.dandelion.dao.self;

import com.dandelion.bean.AdminExample;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * ClassName: AdminSelfMapper
 * date:      2019/8/21 14:31
 * author:    puyiliang
 * description: 自定义用户Mapper
 */
public interface AdminSelfMapper {

    List<Authority> selectAuthorityByAdminId(Map<String,String> authorityParams);

    List<Role> selectRoleByAdminId(Map<String,String> authorityParams);

    List<Integer> selectRoleIdByAdminId(Map<String, String> paramsMap);

    void deleteRoleByAdminId(Integer adminId);

    void insertRoleByAdminId(Map<String, Object> paramsMap);

    void updateStatusByExample(@Param("example") AdminExample example);
}
