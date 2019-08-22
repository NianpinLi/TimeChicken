package com.dandelion.service;

import com.dandelion.base.BaseService;
import com.dandelion.bean.Admin;
import com.dandelion.bean.Authority;
import com.dandelion.dao.generator.AuthorityMapper;
import com.dandelion.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private RedisUtil redisUtil;

    /**
     * 验证权限
     * @param requestURI String
     * @return Boolean
     */
    public Boolean verifyAuthority(String requestURI) {

        Boolean flag = false;
        if (requestURI.startsWith("base/")){
            flag = true;
        }
        Admin admin = this.getAdmin();
        List<Authority> authorityList = (List<Authority>) this.getSession(admin.getAdminId() + "_Authority");
        for (Authority authority : authorityList) {
            if (requestURI.equals(authority.getAuthorityUrl())){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
