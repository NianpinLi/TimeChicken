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
    private String title;
    private String icon;
    private String href;
    private String target;
    private List<AuthorityVo> child;



    public AuthorityVo(Authority authority) {
        this.title = String.valueOf(authority.getAuthorityId());
        this.icon = authority.getAuthorityIcon();
        if (authority.getAuthorityUrl() != null && !"#".equals(authority.getAuthorityUrl())){
            this.href = authority.getAuthorityUrl();
            this.target = "_self";
        }
        this.child = Lists.newArrayList();
    }

    public void addChild(AuthorityVo child){
        this.child.add(child);
    }

    public void addChildList(List<AuthorityVo> childList){
        this.child.addAll(childList);
    }
}
