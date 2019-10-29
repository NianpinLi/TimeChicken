/*
 *
 *  * Copyright (c) 2017.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.dandelion.plugins;

import com.dandelion.plugins.utils.CommTools;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.internal.util.StringUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;

/**
 * ---------------------------------------------------------------------------
 * Example类生成位置修改
 * ---------------------------------------------------------------------------
 * @author generator
 * @date 2017/1/12 12:36
 * ---------------------------------------------------------------------------
 */
@Slf4j
public class ExampleTargetPlugin extends PluginAdapter {
    /** 配置targetPackage名 */
    public static final String TARGET_PACKAGE_KEY = "targetPackage";

    /** 目标包 */
    private static String targetPackage;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(List<String> warnings) {
        // 插件使用前提是targetRuntime为MyBatis3
        if (StringUtility.stringHasValue(getContext().getTargetRuntime()) && CommTools.MYBATIS_VERSION.equalsIgnoreCase(getContext().getTargetRuntime()) == false ){
            log.warn("itfsw:插件"+this.getClass().getTypeName()+"要求运行targetRuntime必须为MyBatis3！");
            return false;
        }
        // 获取配置的目标package
        Properties properties = getProperties();
        ExampleTargetPlugin.targetPackage = properties.getProperty(TARGET_PACKAGE_KEY);
        if (ExampleTargetPlugin.targetPackage == null){
            log.warn("请配置com.itfsw.mybatis.generator.plugins.ExampleTargetPlugin插件的目标包名(targetPackage)！");
            return false;
        }
        return true;
    }

    /**
     * 初始化阶段
     * 具体执行顺序 http://www.mybatis.org/generator/reference/pluggingIn.html
     *
     * @param introspectedTable
     */
    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        String exampleType = introspectedTable.getExampleType();
        // 修改包名
        Context context = getContext();
        JavaModelGeneratorConfiguration configuration = context.getJavaModelGeneratorConfiguration();
        String targetPackage = configuration.getTargetPackage();
        String newExampleType = exampleType.replace(targetPackage, ExampleTargetPlugin.targetPackage);

        introspectedTable.setExampleType(newExampleType);

        log.debug("itfsw(Example 目标包修改插件):修改"+introspectedTable.getExampleType()+"的包到"+ExampleTargetPlugin.targetPackage);
    }

}
