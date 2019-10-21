package com.dandelion.service;

import java.util.Map;

/**
 * className AuthorityService
 * description
 * @author puyiliang
 * @date 2019/10/18 17:56
 */
public interface AuthorityService {
    /**
     * 获取权限列表 不分页
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map getAuthorityList(Map<String, String> paramsMap) throws Exception;
    /**
     * 获取权限列表 分页
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map getAuthorityPageList(Map<String, String> paramsMap) throws Exception;
    /**
     * 权限信息回显
     * @param paramsMap Map
     * @throws Exception e
     */
    void getAuthorityById(Map<String, String> paramsMap) throws Exception;
    /**
     * 新增 / 修改 权限
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map saveAuthority(Map<String, String> paramsMap) throws Exception;
    /**
     * 删除权限
     * @param paramsMap Map
     * @return Map
     * @throws Exception e
     */
    Map deleteAuthority(Map<String, String> paramsMap) throws Exception;
}
