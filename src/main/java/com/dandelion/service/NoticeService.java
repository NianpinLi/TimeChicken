package com.dandelion.service;

import com.dandelion.bean.Notice;

import java.util.Map;

/**
 * @author puyiliang
 * @date create in 2019/12/1910:01
 */
public interface NoticeService {
    /**
     * 根据Id 获取公告
     * @param params Map
     * @return Notice
     */
    Notice getNoticeById(Map<String, String> params) throws Exception;

    /**
     * 获取公告列表
     * @param params Map
     * @return Map
     */
    Map<String, Object> getNoticeList(Map<String, String> params) throws Exception;

    /**
     * 新增/修改公告
     * @param params Map
     * @return Map
     */
    Map<String, Object> saveNotice(Map<String, String> params) throws Exception;

    /**
     * 删除公告
     * @param params Map
     * @return Map
     */
    Map<String, Object> deleteNotice(Map<String, String> params) throws Exception;
}
