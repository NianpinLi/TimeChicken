package com.dandelion.vo;

import com.dandelion.bean.Authority;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * ClassName: AuthorityVo
 * date:      2019/9/4 10:57
 * author:    puyiliang
 * description: 权限树形结构
 */
@Data
public class AuthorityVo {
    private Integer authorityId;
    private String authorityUrl;
    private String authorityName;
    private Integer parentAuthorityId;
    private List<AuthorityVo> childAuthorityList;

    public AuthorityVo(Authority authority) {
        this.authorityId = authority.getAuthorityId();
        this.authorityUrl = authority.getAuthorityUrl();
        this.authorityName = authority.getAuthorityName();
        this.parentAuthorityId = authority.getParentAuthorityId();
        this.childAuthorityList = Lists.newArrayList();
    }

    public void addChildAuthority(AuthorityVo child){
        childAuthorityList.add(child);
    }

    public void addChildAuthorityList(List<AuthorityVo> childList){
        childAuthorityList.addAll(childList);
    }
}
