package com.dandelion.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

/**
 * @ClassName:   JsoupUtil
 * @date:        2019/10/15 14:06
 * @author:      puyiliang
 * @description: xss非法标签过滤工具类 过滤html中的xss字符
 */
public class JsoupUtil {

    /**
     * 使用自带的basicWithImages 白名单
	 * 允许的便签有a,b,blockquote,br,cite,code,dd,dl,dt,em,i,li,ol,p,pre,q,small,span,
     * strike,strong,sub,sup,u,ul,img
	 * 以及a标签的href,img标签的src,align,alt,height,width,title属性
	 */
    private static final Whitelist WHITE_LIST = Whitelist.basicWithImages();

    /**
     *  配置过滤化参数,不对代码进行格式化
     */
    private static final Document.OutputSettings OUTPUT_SETTINGS = new Document.OutputSettings().prettyPrint(false);

    static {
        // 富文本编辑时一些样式是使用style来进行实现的
        // 比如红色字体 style="color:red;"
        // 所以需要给所有标签添加style属性
        WHITE_LIST.addAttributes(":all", "style");
    }

    /**
     * 过滤Xss攻击方法
     * @param content String
     * @return String
     */
    public static String clean(String content) {
        if(!ObjectUtil.isNull(content)){
            content = content.trim();
        }
        return Jsoup.clean(content, "", WHITE_LIST, OUTPUT_SETTINGS);
    }
}
