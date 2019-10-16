package com.dandelion.base;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * @ClassName: CommonMessage
 * @date:      2019/8/14 12:25
 * @author:    puyiliang
 * @description: 公共信息
 */
public class CommonMessage {

    /** 成功 */
    public static Integer SUCCESS = 0;
    /** 失败*/
    public static Integer ERROR = 1;
    /** 参数错误*/
    public static Integer PARAMS_ERROR = 2;
    /** 系统错误*/
    public static Integer SYSTEM_ERROR = 3;
    /** 无权限错误*/
    public static Integer PERMISSION_ERROR = 4;
    /** 错误码默认提醒*/
    public static Map<Integer, String> MESSAGE = ImmutableMap.<Integer, String>builder()
            .put(CommonMessage.SUCCESS, "操作成功")
            .put(CommonMessage.ERROR, "操作失败")
            .put(CommonMessage.PARAMS_ERROR, "参数错误")
            .put(CommonMessage.SYSTEM_ERROR, "系统错误")
            .put(CommonMessage.PERMISSION_ERROR, "权限异常")
            .build();
}
