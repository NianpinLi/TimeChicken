package com.dandelion.plugins;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author puyiliang
 * @date create in 2019/12/1110:09
 * mybatis generator 自动生成时，如果存在原文件xml 直接覆盖插件（默认追加）
 */
public class OverwriteXmlPlugin extends PluginAdapter {

    @Override
    public boolean validate(List warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap,false);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
