package com.dandelion.service;

import com.dandelion.dao.AuthorityMapper;
import com.dandelion.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: AuthorityService
 * date:      2019/8/19 16:04
 * author:    puyiliang
 * description: 权限Service
 */
@Service
public class AuthorityService {

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
        return flag;
    }
}
