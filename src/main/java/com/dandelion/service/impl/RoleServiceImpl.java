package com.dandelion.service.impl;

import com.alibaba.fastjson.JSON;
import com.dandelion.annotation.ReadOnlyConnection;
import com.dandelion.base.BaseServiceImpl;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;
import com.dandelion.bean.example.RoleExample;
import com.dandelion.dao.generator.RoleMapper;
import com.dandelion.dao.self.RoleSelfMapper;
import com.dandelion.service.RoleService;
import com.dandelion.utils.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AdminController
 *
 * @author puyiliang
 * 角色管理Service
 * @date 2019/8/13 10:26
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleSelfMapper roleSelfMapper;

    /**
     * 角色列表 不带分页
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @Override
    @ReadOnlyConnection
    public Map getRoleList(Map<String, String> paramsMap) throws Exception {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        //查询条件
        this.setExample(paramsMap, criteria, "Role");
        List<Role> roleList = roleMapper.selectByExample(example);
        int total = roleList.size();
        return pageResult(roleList, total);
    }

    /**
     * 角色列表 带分页
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @Override
    @ReadOnlyConnection
    public Map getRolePageList(Map<String, String> paramsMap) throws Exception {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        //查询条件
        this.setExample(paramsMap, criteria, "Role");
        //排序字段
        this.setOrderByClause(paramsMap, example, "Role");
        //分页
        startPage(paramsMap);
        List<Role> roleList = roleMapper.selectByExample(example);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        long total = pageInfo.getTotal();
        return pageResult(roleList, total);
    }

    /**
     * 根据角色ID查询角色信息 存入Session中
     *
     * @param paramsMap Map
     * @return Role
     * @throws Exception e
     */
    @Override
    @ReadOnlyConnection
    public Role getRoleById(Map<String, String> paramsMap) throws Exception {
        return roleMapper.selectByPrimaryKey(Integer.parseInt(paramsMap.get("roleId")));

    }

    /**
     * 新增/修改 角色
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map saveRole(Map<String, String> paramsMap) throws Exception {
        Role role = JSON.parseObject(JSON.toJSONString(paramsMap), Role.class);
        if (ObjectUtil.isNull(role.getRoleId())) {
            //存入添加信息
            this.setCreateInfo(role, this.getLoginAdmin());
            //判断是否存在角色ID 不存在新增
            roleMapper.insertSelective(role);
        } else {
            //存在修改
            roleMapper.updateByPrimaryKeySelective(role);
        }
        return this.successResult(true);
    }

    /**
     * 删除角色
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map deleteRole(Map<String, String> paramsMap) throws Exception {
        String roleIds = paramsMap.get("inRoleId");
        if (!ObjectUtil.isNull(roleIds)) {
            RoleExample example = new RoleExample();
            RoleExample.Criteria criteria = example.createCriteria();
            setExample(paramsMap, criteria, "Role");
            roleMapper.deleteByExample(example);
        }
        return this.successResult(false);
    }

    /**
     * 角色分配权限回显
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @Override
    @ReadOnlyConnection
    public Map empowermentAuthority(Map<String, String> paramsMap) throws Exception {
        //查询当前角色拥有的权限
        List<Integer> authorityList = roleSelfMapper.selectAuthorityIdByRoleId(paramsMap);

        if (this.getLoginAdmin().getAdminId() != 1) {
            //非顶级登录人,查询当前登录角色拥有的权限
            paramsMap.put("adminId", String.valueOf(this.getLoginAdmin().getAdminId()));
        }
        List<Authority> allAuthorityList = roleSelfMapper.selectAuthorityByAdminId(paramsMap);
        List<Map<String, Object>> zTreeNode = Lists.newArrayList();
        HashMap<Integer, Map> authorityMap = Maps.newHashMap();
        allAuthorityList.forEach(authority -> {
            Map<String, Object> map = Maps.newHashMap();
            map.put("value", authority.getAuthorityId());
            map.put("title", authority.getAuthorityName());
            map.put("data", Lists.newArrayList());
            map.put("parent", true);
            Integer parentId = authority.getParentAuthorityId();
            Integer authorityId = authority.getAuthorityId();
            authorityMap.put(authorityId, map);
            if (authorityList.contains(authorityId)) {
                map.put("checked", true);
            }
            Map parent = authorityMap.get(parentId);
            if (parent != null) {
                ((List) parent.get("data")).add(map);
            } else {
                zTreeNode.add(map);
            }
        });

        return this.successResult(zTreeNode, false);
    }

    /**
     * 角色分配权限
     *
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map saveEmpowermentAuthority(Map<String, Object> paramsMap) throws Exception {
        //删除角色所拥有的所有权限
        Integer roleId = Integer.parseInt(String.valueOf(paramsMap.get("roleId")));
        roleSelfMapper.deleteAuthorityByRoleId(roleId);
        //添加新的权限
        String authorityIds = String.valueOf(paramsMap.get("authorityIds"));
        if (!ObjectUtil.isNull(authorityIds)) {
            List<String> authorityIdList = Lists.newArrayList();
            String splitRegex = ",";
            for (String authorityId : authorityIds.split(splitRegex)) {
                if (!ObjectUtil.isNull(authorityId) && !"on".equals(authorityId)) {
                    authorityIdList.add(authorityId);
                }
            }
            if (authorityIdList.size() > 0) {
                paramsMap.put("authorityIdList", authorityIdList);
                roleSelfMapper.insertAuthorityByRoleId(paramsMap);
            }
        }
        return successResult(true);
    }
}
