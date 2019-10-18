package com.dandelion.service.impl;

import com.alibaba.fastjson.JSON;
import com.dandelion.base.BaseService;
import com.dandelion.bean.Authority;
import com.dandelion.bean.AuthorityExample;
import com.dandelion.dao.generator.AuthorityMapper;
import com.dandelion.service.AuthorityService;
import com.dandelion.utils.DateUtil;
import com.dandelion.utils.ObjectUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * AuthorityService
 * @date      2019/8/19 16:04
 * @author    puyiliang
 *  权限Service
 */
@SuppressWarnings({"ALL", "AlibabaTransactionMustHaveRollback"})
@Service
public class AuthorityServiceImpl extends BaseService<Authority,Integer> implements AuthorityService{

    @Resource
    private AuthorityMapper authorityMapper;


    /**
     * 获取权限列表 不分页
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    public Map getAuthorityList(Map<String, String> paramsMap) throws Exception{
        AuthorityExample example = new AuthorityExample();
        AuthorityExample.Criteria criteria = example.createCriteria();
        //查询条件
        this.setExample(paramsMap, criteria,"Authority");
        List<Authority> authorityList = authorityMapper.selectByExample(example);
        int total = authorityList.size();
        return this.pageResult(authorityList, total);
    }

    /**
     * 获取权限列表 分页
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    public Map getAuthorityPageList(Map<String,String> paramsMap) throws Exception{
        //查询页面权限
        paramsMap.put("equalsToAuthorityType","1");

        AuthorityExample example = new AuthorityExample();
        AuthorityExample.Criteria criteria = example.createCriteria();
        //查询条件
        this.setExample(paramsMap, criteria,"Authority");
        //分页
        startPage(paramsMap);
        List<Authority> authorityList = authorityMapper.selectByExample(example);
        PageInfo<Authority> pageInfo = new PageInfo(authorityList);
        long total = pageInfo.getTotal();
        return pageResult(authorityList, total);
    }

    /**
     * 新增 / 修改 权限
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @Transactional(rollbackFor=Exception.class)
    public Map saveAuthority(Map<String, String> paramsMap){
        try {
            //将Map 转化成 entity
            Authority authority = JSON.parseObject(JSON.toJSONString(paramsMap),Authority.class);
            String authorityIcon = authority.getAuthorityIcon();
            //权限图标存储
            String iconStartsWith = "fa-";
            if (!ObjectUtil.isNull(authorityIcon) && authorityIcon.startsWith(iconStartsWith)){
                authority.setAuthorityIcon("fa "+authorityIcon);
            }
            //页面权限没有标识
            if (authority.getAuthorityType() == 1){
                authority.setAuthorityIdentifier(null);
            }
            String fieldName = "authorityId";
            if(ObjectUtil.isNull(paramsMap.get(fieldName))){
                //不存在权限Id 新增
                authority.setCreateName(this.getLoginAdmin().getRealName());
                authority.setCreateId(this.getLoginAdmin().getAdminId());
                authority.setCreateTime(DateUtil.getNowDateEn());
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
        }catch (Exception e){

        }


        return this.successResult(true);
    }

    /**
     * 删除权限
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    @Transactional(rollbackFor=Exception.class)
    public Map deleteAuthority(Map<String, String> paramsMap) throws Exception{
        authorityMapper.deleteByPrimaryKey(Integer.parseInt(paramsMap.get("equalToAuthorityId")));
        return this.successResult(false);
    }

    /**
     * 权限信息回显
     * @param paramsMap Map
     * @throws Exception e
     */
    public void getAuthorityById(Map<String, String> paramsMap)  throws Exception{
        Authority authority = authorityMapper.selectByPrimaryKey(Integer.parseInt(paramsMap.get("authorityId")));
        this.setAttribute("authority",authority);
    }
}
