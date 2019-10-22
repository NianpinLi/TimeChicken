/**
 *@author generator
 *@date 2019-10-22
 */
package com.dandelion.dao.generator;

import com.dandelion.bean.Authority;
import com.dandelion.bean.AuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorityMapper {
    /**
     *自动生成方法
     *@param example generator
     *@return long
     */
    long countByExample(AuthorityExample example);

    /**
     *自动生成方法
     *@param example generator
     *@return int
     */
    int deleteByExample(AuthorityExample example);

    /**
     *自动生成方法
     *@param authorityId generator
     *@return int
     */
    int deleteByPrimaryKey(Integer authorityId);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int insert(Authority record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int insertSelective(Authority record);

    /**
     *自动生成方法
     *@param example generator
     *@return java.util.List<com.dandelion.bean.Authority>
     */
    List<Authority> selectByExample(AuthorityExample example);

    /**
     *自动生成方法
     *@param authorityId generator
     *@return com.dandelion.bean.Authority
     */
    Authority selectByPrimaryKey(Integer authorityId);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExampleSelective(@Param("record") Authority record, @Param("example") AuthorityExample example);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExample(@Param("record") Authority record, @Param("example") AuthorityExample example);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKeySelective(Authority record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKey(Authority record);
}