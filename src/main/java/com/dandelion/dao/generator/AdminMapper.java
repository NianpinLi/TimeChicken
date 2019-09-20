package com.dandelion.dao.generator;

import com.dandelion.bean.Admin;
import com.dandelion.bean.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    long countByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    int deleteByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    int deleteByPrimaryKey(Integer adminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    int insert(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    int insertSelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    Admin selectByPrimaryKey(Integer adminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Sep 20 17:47:20 CST 2019
     */
    int updateByPrimaryKey(Admin record);
}