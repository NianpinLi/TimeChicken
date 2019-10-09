package com.dandelion.service;

import com.alibaba.fastjson.JSON;
import com.dandelion.base.BaseService;
import com.dandelion.bean.Authority;
import com.dandelion.bean.Role;
import com.dandelion.bean.RoleExample;
import com.dandelion.dao.generator.RoleMapper;
import com.dandelion.dao.self.RoleSelfMapper;
import com.dandelion.utils.DateUtil;
import com.dandelion.utils.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: AdminController
 * date:      2019/8/13 10:26
 * author:    puyiliang
 * description: 角色管理Service
 */
@Service
public class RoleService extends BaseService<Role, Integer>{

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleSelfMapper roleSelfMapper;

    public Map getRoleList(Map paramsMap) throws Exception{
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        //查询条件
        this.getSearchExample(paramsMap, criteria, "Role");
        //排序字段
        this.setOrderByClause(paramsMap, example, "Role");
        //分页
        startPage(paramsMap);
        List<Role> roleList = roleMapper.selectByExample(example);
        PageInfo<Role> pageInfo = new PageInfo(roleList);
        long total = pageInfo.getTotal();
        return pageResult(roleList, total);
    }

    public void getRoleById(Map<String, String> paramsMap) {
        Role role = roleMapper.selectByPrimaryKey(Integer.parseInt(paramsMap.get("roleId")));
        this.setAttribute("role",role);
    }

    public Map saveRole(Map<String, String> paramsMap) {
        Role role = JSON.parseObject(JSON.toJSONString(paramsMap), Role.class);
        if(ObjectUtil.isNull(role.getRoleId())){
            //存入添加信息
            role.setCreateName(this.getAdmin().getRealName());
            role.setCreateId(this.getAdmin().getAdminId());
            role.setCreateTime(DateUtil.getNowDate_EN());
            //判断是否存在角色ID 不存在新增
            roleMapper.insertSelective(role);
        }else{
            //存在修改
            roleMapper.updateByPrimaryKeySelective(role);
        }
        return this.successResult(true);
    }

    public Map deleteRole(Map<String, String> paramsMap) {
        String roleIds = paramsMap.get("inRoleId");
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        //处理ID
        List<Integer> inRoleList = Lists.newArrayList();
        if (!ObjectUtil.isNull(roleIds)){
            for (String roleIdStr : roleIds.split(",")) {
                inRoleList.add(Integer.parseInt(roleIdStr));
            }
            if (!ObjectUtil.isNull(inRoleList)){
                //删除
                criteria.andRoleIdIn(inRoleList);
                roleMapper.deleteByExample(example);
            }
        }
        return this.successResult(false);
    }

    public Map empowermentAuthority(Map<String, String> paramsMap) {
        //查询当前角色拥有的权限
        List<Integer> authorityList = roleSelfMapper.selectAuthorityIdByRoleId(paramsMap);

        if(this.getAdmin().getAdminId() != 1){
            //非顶级登录人,查询当前登录角色拥有的权限
            paramsMap.put("adminId",String.valueOf(this.getAdmin().getAdminId()));
        }
        List<Authority> allAuthorityList = roleSelfMapper.selectAuthorityByAdminId(paramsMap);
        List zTreeNode = Lists.newArrayList();
        HashMap<Integer, Map> authorityMap = Maps.newHashMap();
        allAuthorityList.forEach(authority -> {
            Map<String, Object> map = getAuthorityNode(authority);
            Integer parentId = authority.getParentAuthorityId();
            Integer authorityId = authority.getAuthorityId();
            authorityMap.put(authorityId,map);
            if (authorityList.contains(authorityId.intValue())){
                map.put("checked",true);
            }
            if (parentId != -1){
                //非顶级菜单
                Map parent = authorityMap.get(parentId);
                if (parent != null){
                    ((List)parent.get("data")).add(map);
                }
            }else{
                zTreeNode.add(map);
            }
        });

        return this.successResult(zTreeNode,false);
    }

    private Map<String,Object> getAuthorityNode(Authority authority){
        Map<String,Object> map = Maps.newHashMap();
        map.put("value",authority.getAuthorityId());
        map.put("title",authority.getAuthorityName());
        map.put("data",Lists.newArrayList());
        return map;
    }
}
