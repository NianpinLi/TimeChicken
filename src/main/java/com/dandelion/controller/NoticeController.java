package com.dandelion.controller;

import com.dandelion.base.BaseController;
import com.dandelion.bean.Notice;
import com.dandelion.service.NoticeService;
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
 * 公告管理Controller
 * @author puyiliang
 * @date create in 2019/12/199:59
 */
@Controller
@RequestMapping(value = "notice")
public class NoticeController extends BaseController {

    @Resource
    private NoticeService noticeService;

    /**
     * 跳转公告管理页面
     * @return String
     */
    @RequiresPermissions("/notice/getNotice")
    @RequestMapping(value = "/getNotice", method = RequestMethod.GET)
    public String getNotice() throws Exception{
        return this.disPlay();
    }

    /**
     * 跳转添加公告页面
     * @return String
     */
    @RequiresPermissions("/notice/addNotice")
    @RequestMapping(value = "addNotice", method = RequestMethod.GET)
    public String addNotice() throws Exception{
        return this.disPlay();
    }

    /**
     * 跳转修改公告页面
     * @param params Map
     * @return String
     */
    @RequiresPermissions("/notice/updateNotice")
    @RequestMapping(value = "updateNotice", method = RequestMethod.GET)
    public String updateNotice(@RequestParam Map<String, String> params) throws Exception{
        Notice notice = noticeService.getNoticeById(params);
        this.setAttribute("notice", notice);
        return this.disPlay();
    }

    /**
     * 获取公告列表
     * @param params Map
     * @return Map
     */
    @RequiresPermissions("/notice/getNoticeList")
    @RequestMapping(value = "getNoticeList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getNoticeList(@RequestParam Map<String, String> params) throws Exception{
        return noticeService.getNoticeList(params);
    }

    /**
     * 新增/修改公告
     * @param params Map
     * @return Map
     */
    @RequiresPermissions(value = {"/notice/addNotice","/notice/updateNotice"},logical = Logical.OR)
    @RequestMapping(value = "saveNotice", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveNotice(@RequestParam Map<String, String> params) throws Exception{
        return noticeService.saveNotice(params);
    }

    /**
     * 删除公告
     * @param params Map
     * @return Map
     */
    @RequiresPermissions("/notice/deleteNotice")
    @RequestMapping(value = "deleteNotice", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteNotice(@RequestParam Map<String, String> params) throws Exception{
        return noticeService.deleteNotice(params);
    }

}
