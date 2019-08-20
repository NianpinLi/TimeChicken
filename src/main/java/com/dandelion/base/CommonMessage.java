package com.dandelion.base;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * ClassName: CommonMessage
 * date:      2019/8/14 12:25
 * author:    puyiliang
 * description: 公共信息
 */
public class CommonMessage {

    //成功
    public static int SUCCESS = 200;
    //参数错误
    public static int PARAMSERROR = 3000;
    //系统错误
    public static int SYSTEMERROR = 4000;

    //错误码默认提醒
    public static Map<Integer, String> MESSAGE = ImmutableMap.<Integer, String>builder()
            .put(CommonMessage.SUCCESS, "操作成功")
            .put(CommonMessage.PARAMSERROR, "参数错误")
            .put(CommonMessage.SYSTEMERROR, "系统错误")
            .build();
}
