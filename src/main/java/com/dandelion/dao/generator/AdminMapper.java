/**
 *@author generator
 *@date 2019-10-29
 */
package com.dandelion.dao.generator;

import com.dandelion.bean.Admin;
import com.dandelion.bean.example.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    /**
     *自动生成方法
     *@param example generator
     *@return long
     */
    long countByExample(AdminExample example);

    /**
     *自动生成方法
     *@param example generator
     *@return int
     */
    int deleteByExample(AdminExample example);

    /**
     *自动生成方法
     *@param adminId generator
     *@return int
     */
    int deleteByPrimaryKey(Integer adminId);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int insert(Admin record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int insertSelective(Admin record);

    /**
     *自动生成方法
     *@param example generator
     *@return java.util.List<com.dandelion.bean.Admin>
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     *自动生成方法
     *@param adminId generator
     *@return com.dandelion.bean.Admin
     */
    Admin selectByPrimaryKey(Integer adminId);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKey(Admin record);

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table admin
     *
     * @mbg.generated
     * @author generator
     */
    Admin selectOneByExample(AdminExample example);
}