package com.dandelion.service.impl;

import com.dandelion.base.BaseServiceImpl;
import com.dandelion.bean.Admin;
import com.dandelion.bean.WorkOrderType;
import com.dandelion.bean.WorkOrderTypeExample;
import com.dandelion.dao.generator.WorkOrderTypeMapper;
import com.dandelion.service.WorkOrderTypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * className WorkOrderTypeServiceImpl
 * description 工单类型ServiceImpl
 *
 * @author puyiliang
 * @date 2019/10/22 11:50
 */
@Service
public class WorkOrderTypeServiceImpl extends BaseServiceImpl<WorkOrderType,Integer> implements WorkOrderTypeService{

    @Resource
    private WorkOrderTypeMapper workOrderTypeMapper;

    @Override
    public Map getTypeList(Map<String, String> params) throws Exception {
        WorkOrderTypeExample example = new WorkOrderTypeExample();
        WorkOrderTypeExample.Criteria criteria = example.createCriteria();
        //查询条件
        this.setExample(params, criteria,"WorkOrderType");
        //分页
        startPage(params);
        List<WorkOrderType> list = workOrderTypeMapper.selectByExample(example);
        PageInfo<WorkOrderType> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        return pageResult(list, total);
    }
}
