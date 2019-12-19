/**
 *@author generator
 *@date 2019-12-19
 */
package com.dandelion.dao.generator;

import com.dandelion.bean.Notice;
import com.dandelion.bean.example.NoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
    /**
     *自动生成方法
     *@param example generator
     *@return long
     */
    long countByExample(NoticeExample example);

    /**
     *自动生成方法
     *@param example generator
     *@return int
     */
    int deleteByExample(NoticeExample example);

    /**
     *自动生成方法
     *@param noticeId generator
     *@return int
     */
    int deleteByPrimaryKey(Integer noticeId);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int insert(Notice record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int insertSelective(Notice record);

    /**
     *自动生成方法
     *@param example generator
     *@return java.util.List<com.dandelion.bean.Notice>
     */
    List<Notice> selectByExampleWithBLOBs(NoticeExample example);

    /**
     *自动生成方法
     *@param example generator
     *@return java.util.List<com.dandelion.bean.Notice>
     */
    List<Notice> selectByExample(NoticeExample example);

    /**
     *自动生成方法
     *@param noticeId generator
     *@return com.dandelion.bean.Notice
     */
    Notice selectByPrimaryKey(Integer noticeId);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExampleWithBLOBs(@Param("record") Notice record, @Param("example") NoticeExample example);

    /**
     *自动生成方法
     *@param record generator
     *@param example generator
     *@return int
     */
    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKeySelective(Notice record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKeyWithBLOBs(Notice record);

    /**
     *自动生成方法
     *@param record generator
     *@return int
     */
    int updateByPrimaryKey(Notice record);

    /**
     *自动生成方法
     *@param example generator
     *@return com.dandelion.bean.Notice
     */
    Notice selectOneByExample(NoticeExample example);

    /**
     *自动生成方法
     *@param list generator
     *@return int
     */
    int batchInsert(@Param("list") List<Notice> list);

    /**
     *自动生成方法
     *@param list generator
     *@param selective generator
     *@return int
     */
    int batchInsertSelective(@Param("list") List<Notice> list, @Param("selective") Notice.Column ... selective);
}