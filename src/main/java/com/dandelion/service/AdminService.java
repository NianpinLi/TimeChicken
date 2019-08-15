package com.dandelion.service;

import com.dandelion.Base.BaseService;
import com.dandelion.bean.Admin;
import com.dandelion.bean.AdminExample;
import com.dandelion.dao.AdminMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ClassName: AdminService
 * date:      2019/8/13 10:54
 * author:    puyiliang
 * description: AdminService
 */
@Service
public class AdminService extends BaseService<Admin, Integer>{

    @Resource
    private AdminMapper adminMapper;

    public List<Admin> selectAdminPageList(Map<String,String> paramsMap) throws Exception{
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        this.getSearchExample(paramsMap, criteria);
        PageHelper.startPage(1, 5);
        return adminMapper.selectByExample(example);
    }
}
