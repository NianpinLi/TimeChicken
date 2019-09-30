package com.dandelion.service;

import com.alibaba.fastjson.JSON;
import com.dandelion.base.BaseService;
import com.dandelion.bean.Role;
import com.dandelion.bean.RoleExample;
import com.dandelion.dao.generator.RoleMapper;
import com.dandelion.utils.DateUtil;
import com.dandelion.utils.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
            //无上级权限
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

        List<Integer> inRoleList = Lists.newArrayList();
        if (!ObjectUtil.isNull(roleIds)){
            for (String roleIdStr : roleIds.split(",")) {
                inRoleList.add(Integer.parseInt(roleIdStr));
            }
            if (!ObjectUtil.isNull(inRoleList)){
                criteria.andRoleIdIn(inRoleList);
                roleMapper.deleteByExample(example);
            }
        }
        return this.successResult(false);
    }
}
