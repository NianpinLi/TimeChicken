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


}
