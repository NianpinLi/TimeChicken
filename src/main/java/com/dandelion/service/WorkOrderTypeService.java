package com.dandelion.service;

import java.util.Map; /**
 * className WorkOrderTypeService
 * description 工单类型Service
 *
 * @author puyiliang
 * @date 2019/10/22 11:50
 */
public interface WorkOrderTypeService {
    /**
     * 查询工单类型列表
     * @param params Map
     * @return Map
     * @throws Exception e
     */
    Map getTypeList(Map<String, String> params) throws Exception;
}
