/**
 *@author generator
 *@date 2019-10-29
 */
package com.dandelion.dao.generator;

import com.dandelion.bean.Role;
import com.dandelion.bean.example.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     *自动生成方法
     *@param example generator
     *@return long
     */
    long countByExample(RoleExample example);

    /**
     *自动生成方法
     *@param example generator
     *@return int
     */
    int deleteByExample(RoleExample example);

    /**
     *自动生成方法
     *@param roleId generator
     *@return int
     */
    int deleteByPrimaryKey(Integer roleId);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int insert(Role record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int insertSelective(Role record);

    /**
     *自动生成方法
     *@param example generator
     *@return java.util.List<com.dandelion.bean.Role>
     */
    List<Role> selectByExample(RoleExample example);

    /**
     *自动生成方法
     *@param roleId generator
     *@return com.dandelion.bean.Role
     */
    Role selectByPrimaryKey(Integer roleId);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKey(Role record);

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table role
     *
     * @mbg.generated
     * @author generator
     */
    Role selectOneByExample(RoleExample example);
}