package com.dandelion.service;

import com.alibaba.fastjson.JSON;
import com.dandelion.base.BaseService;
import com.dandelion.bean.Authority;
import com.dandelion.bean.AuthorityExample;
import com.dandelion.dao.generator.AuthorityMapper;
import com.dandelion.utils.DateUtil;
import com.dandelion.utils.ObjectUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ClassName: AuthorityService
 * date:      2019/8/19 16:04
 * author:    puyiliang
 * description: 权限Service
 */
@Service
public class AuthorityService extends BaseService<Authority,Integer>{

    @Resource
    private AuthorityMapper authorityMapper;


    public Map getAuthorityList(Map<String, String> paramsMap) throws Exception{
        AuthorityExample example = new AuthorityExample();
        AuthorityExample.Criteria criteria = example.createCriteria();
        //查询条件
        this.getSearchExample(paramsMap, criteria,"Authority");
        List<Authority> authorityList = authorityMapper.selectByExample(example);
        int total = authorityList.size();
        return this.pageResult(authorityList, total);
    }

    public Map getAuthorityPageList(Map<String,String> paramsMap) throws Exception{
        //查询页面权限
        paramsMap.put("equalsToAuthorityType","1");

        AuthorityExample example = new AuthorityExample();
        AuthorityExample.Criteria criteria = example.createCriteria();
        //查询条件
        this.getSearchExample(paramsMap, criteria,"Authority");
        //example.setOrderByClause();
        //分页
        startPage(paramsMap);
        List<Authority> authorityList = authorityMapper.selectByExample(example);
        PageInfo<Authority> pageInfo = new PageInfo(authorityList);
        long total = pageInfo.getTotal();
        return pageResult(authorityList, total);
    }

    public Map saveAuthority(Map<String, String> paramsMap) {
        //将Map 转化成 entity
        Authority authority = JSON.parseObject(JSON.toJSONString(paramsMap),Authority.class);
        String authorityIcon = authority.getAuthorityIcon();
        //权限图标存储
        if (!ObjectUtil.isNull(authorityIcon) && authorityIcon.startsWith("fa-")){
            authority.setAuthorityIcon("fa "+authorityIcon);
        }
        //页面权限没有标识
        if (authority.getAuthorityType() == 1){
            authority.setAuthorityIdentifier(null);
        }

        if(ObjectUtil.isNull(paramsMap.get("authorityId"))){
            //不存在权限Id 新增
            authority.setCreateName(this.getAdmin().getRealName());
            authority.setCreateId(this.getAdmin().getAdminId());
            authority.setCreateTime(DateUtil.getNowDate_EN());
            if(ObjectUtil.isNull(authority.getParentAuthorityId())) {
                //无上级权限
                authority.setParentAuthorityId(-1);
            }
            //新增权限
            authorityMapper.insertSelective(authority);
        }else{
            //存在权限Id 修改
            authorityMapper.updateByPrimaryKeySelective(authority);
        }

        return this.successResult(true);
    }

    public Map deleteAuthority(Map<String, String> paramsMap) throws Exception{
        authorityMapper.deleteByPrimaryKey(Integer.parseInt(paramsMap.get("equalToAuthorityId")));
        return this.successResult(false);
    }

    public void getAuthorityById(Map<String, String> paramsMap) {
        Authority authority = authorityMapper.selectByPrimaryKey(Integer.parseInt(paramsMap.get("authorityId")));
        this.setAttribute("authority",authority);
    }
}
