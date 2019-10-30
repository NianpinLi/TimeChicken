/**
 *@author generator
 *@date 2019-10-30
 */
package com.dandelion.dao.generator;

import com.dandelion.bean.WorkOrderType;
import com.dandelion.bean.example.WorkOrderTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkOrderTypeMapper {
    /**
     *自动生成方法
     *@param example generator
     *@return long
     */
    long countByExample(WorkOrderTypeExample example);

    /**
     *自动生成方法
     *@param example generator
     *@return int
     */
    int deleteByExample(WorkOrderTypeExample example);

    /**
     *自动生成方法
     *@param typeId generator
     *@return int
     */
    int deleteByPrimaryKey(Integer typeId);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int insert(WorkOrderType record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int insertSelective(WorkOrderType record);

    /**
     *自动生成方法
     *@param example generator
     *@return java.util.List<com.dandelion.bean.WorkOrderType>
     */
    List<WorkOrderType> selectByExample(WorkOrderTypeExample example);

    /**
     *自动生成方法
     *@param typeId generator
     *@return com.dandelion.bean.WorkOrderType
     */
    WorkOrderType selectByPrimaryKey(Integer typeId);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExampleSelective(@Param("record") WorkOrderType record, @Param("example") WorkOrderTypeExample example);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExample(@Param("record") WorkOrderType record, @Param("example") WorkOrderTypeExample example);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKeySelective(WorkOrderType record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKey(WorkOrderType record);

    /**
     *自动生成方法
     *@param example generator
     *@return com.dandelion.bean.WorkOrderType
     */
    WorkOrderType selectOneByExample(WorkOrderTypeExample example);
}