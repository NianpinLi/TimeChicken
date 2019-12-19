package com.dandelion.service.impl;

import com.alibaba.fastjson.JSON;
import com.dandelion.base.BaseServiceImpl;
import com.dandelion.bean.Notice;
import com.dandelion.bean.example.NoticeExample;
import com.dandelion.dao.generator.NoticeMapper;
import com.dandelion.service.NoticeService;
import com.dandelion.utils.ObjectUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 公告管理ServiceImpl
 * @author puyiliang
 * @date create in 2019/12/1910:02
 */
@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice, Integer> implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    /**
     * 根据Id 获取公告
     * @param params Map
     * @return Notice
     */
    @Override
    public Notice getNoticeById(Map<String, String> params) throws Exception{
        return noticeMapper.selectByPrimaryKey(Integer.parseInt(params.get("noticeId")));
    }

    /**
     * 获取公告列表
     * @param params Map
     * @return Map
     */
    @Override
    public Map<String, Object> getNoticeList(Map<String, String> params) throws Exception{
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        this.setExample(params, criteria, "Notice");
        this.startPage(params);
        List<Notice> notices = noticeMapper.selectByExample(example);
        PageInfo<Notice> info = new PageInfo<>(notices);
        return this.pageResult(notices, info.getTotal());
    }

    /**
     * 新增/修改公告
     * @param params Map
     * @return Map
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> saveNotice(Map<String, String> params) throws Exception{
        Notice notice = JSON.parseObject(JSON.toJSONString(params), Notice.class);
        if(ObjectUtil.isNull(notice.getNoticeId())){
            this.setCreateInfo(notice);
            //新增
            noticeMapper.insertSelective(notice);
        }else{
            noticeMapper.updateByPrimaryKeySelective(notice);
        }
        return this.successResult(true);
    }

    /**
     * 删除公告
     * @param params Map
     * @return Map
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> deleteNotice(Map<String, String> params) throws Exception{
        String noticeIds = params.get("inNoticeId");
        if (!ObjectUtil.isNull(noticeIds)) {
            NoticeExample example = new NoticeExample();
            NoticeExample.Criteria criteria = example.createCriteria();
            setExample(params, criteria, "Notice");
            noticeMapper.deleteByExample(example);
        }
        return this.successResult(false);
    }
}
