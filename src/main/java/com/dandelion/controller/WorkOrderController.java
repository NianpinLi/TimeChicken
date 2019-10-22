package com.dandelion.controller;

import com.dandelion.base.BaseController;
import com.dandelion.service.WorkOrderTypeService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * className WorkOrderController
 * description 工单管理Controller
 *
 * @author puyiliang
 * @date 2019/10/22 11:31
 */
@Controller
@RequestMapping("workOrder")
public class WorkOrderController extends BaseController{

    @Resource
    private WorkOrderTypeService workOrderTypeService;

    /**
     * 工单类型页面跳转
     * @return String
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/workOrder/getType"})
    @RequestMapping(value = "getType", method = RequestMethod.GET)
    public String getType() throws Exception{
        return this.disPlay();
    }
    /**
     * 添加工单类型页面跳转
     * @return String
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/workOrder/addType"})
    @RequestMapping(value = "addType", method = RequestMethod.GET)
    public String addType() throws Exception{
        return this.disPlay();
    }

    /**
     * 工单类型列表查询
     * @param params Map
     * @return Map
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/workOrder/getTypeList"})
    @RequestMapping(value = "getTypeList", method = RequestMethod.GET)
    @ResponseBody
    public Map getTypeList(@RequestParam Map<String,String> params) throws Exception{
        return workOrderTypeService.getTypeList(params);
    }

    /**
     * 新增/修改 工单类型
     * @param params Map
     * @return Map
     * @throws Exception e
     */
    @RequiresPermissions(value = {"/workOrder/addType","/workOrder/updateType"},logical= Logical.OR)
    @RequestMapping(value = "saveType", method = RequestMethod.POST)
    @ResponseBody
    public Map saveType(@RequestParam Map<String,String> params) throws Exception{
        return workOrderTypeService.getTypeList(params);
    }
}
