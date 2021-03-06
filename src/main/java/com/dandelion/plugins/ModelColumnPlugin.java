/*
 * Copyright (c) 2017.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dandelion.plugins;

import com.dandelion.plugins.utils.CommTools;
import com.dandelion.plugins.utils.CommentTools;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.util.JavaBeansUtil;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.List;

/**
 * ---------------------------------------------------------------------------
 * 数据Model属性对应Column获取插件
 * ---------------------------------------------------------------------------
 * @author  generator
 * @date 2017/1/17 11:20
 * ---------------------------------------------------------------------------
 */
@Slf4j
public class ModelColumnPlugin  extends PluginAdapter {
    /**  内部Enum名 */
    public static final String ENUM_NAME = "Column";

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
        return true;
    }

    /**
     * Model Methods 生成
     * 具体执行顺序 http://www.mybatis.org/generator/reference/pluggingIn.html
     *
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        List<Field> fields = topLevelClass.getFields();

        // 生成内部枚举
        InnerEnum innerEnum = new InnerEnum(new FullyQualifiedJavaType(ENUM_NAME));
        innerEnum.setVisibility(JavaVisibility.PUBLIC);
        innerEnum.setStatic(true);
        CommentTools.addInnerEnumComment(innerEnum, introspectedTable);
        log.debug("itfsw(数据Model属性对应Column获取插件):"+topLevelClass.getType().getShortName()+"增加内部Builder类。");

        // 生成属性和构造函数
        Field columnField = new Field("column", FullyQualifiedJavaType.getStringInstance());
        columnField.setVisibility(JavaVisibility.PRIVATE);
        columnField.setFinal(true);
        CommentTools.addFieldComment(columnField, introspectedTable);
        innerEnum.addField(columnField);

        Method mValue = new Method("value");
        mValue.setVisibility(JavaVisibility.PUBLIC);
        mValue.setReturnType(FullyQualifiedJavaType.getStringInstance());
        mValue.addBodyLine("return this.column;");
        CommentTools.addGeneralMethodComment(mValue, introspectedTable);
        innerEnum.addMethod(mValue);

        Method mGetValue = new Method("getValue");
        mGetValue.setVisibility(JavaVisibility.PUBLIC);
        mGetValue.setReturnType(FullyQualifiedJavaType.getStringInstance());
        mGetValue.addBodyLine("return this.column;");
        CommentTools.addGeneralMethodComment(mGetValue, introspectedTable);
        innerEnum.addMethod(mGetValue);

        Method constructor = new Method(ENUM_NAME);
        constructor.setConstructor(true);
        constructor.addBodyLine("this.column = column;");
        constructor.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "column"));
        CommentTools.addGeneralMethodComment(constructor, introspectedTable);
        innerEnum.addMethod(constructor);
        log.debug("itfsw(数据Model属性对应Column获取插件):"+topLevelClass.getType().getShortName()+".Column增加构造方法和column属性。");

        // Enum枚举
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            Field field = JavaBeansUtil.getJavaBeansField(introspectedColumn, context, introspectedTable);

            StringBuffer sb = new StringBuffer();
            sb.append("/**");
            sb.append(introspectedColumn.getActualColumnName());
            sb.append(" */\n");
            sb.append(field.getName());
            sb.append("(\"");
            sb.append(introspectedColumn.getActualColumnName());
            sb.append("\")");

            innerEnum.addEnumConstant(sb.toString());
            log.debug("itfsw(数据Model属性对应Column获取插件):" + topLevelClass.getType().getShortName() + ".Column增加" + field.getName() + "枚举。");
        }

        // asc 和 desc 方法
        Method desc = new Method("desc");
        desc.setVisibility(JavaVisibility.PUBLIC);
        desc.setReturnType(FullyQualifiedJavaType.getStringInstance());
        desc.addBodyLine("return this.column + \" DESC\";");
        CommentTools.addGeneralMethodComment(desc, introspectedTable);
        innerEnum.addMethod(desc);

        Method asc = new Method("asc");
        asc.setVisibility(JavaVisibility.PUBLIC);
        asc.setReturnType(FullyQualifiedJavaType.getStringInstance());
        asc.addBodyLine("return this.column + \" ASC\";");
        CommentTools.addGeneralMethodComment(asc, introspectedTable);
        innerEnum.addMethod(asc);
        log.debug("itfsw(数据Model属性对应Column获取插件):" + topLevelClass.getType().getShortName() + ".Column增加asc()和desc()方法。");

        topLevelClass.addInnerEnum(innerEnum);
        return true;
    }
}
