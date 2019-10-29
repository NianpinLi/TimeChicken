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

package com.dandelion.plugins.utils;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.GeneratedKey;

/**
 * ---------------------------------------------------------------------------
 * Xml 节点生成工具 参考 org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator
 * ---------------------------------------------------------------------------
 * @author generator
 * @date 2016/12/29 16:47
 * ---------------------------------------------------------------------------
 */
public class XmlElementGeneratorTools {

    /**
     * This method should return an XmlElement for the select key used to
     * automatically generate keys.
     *
     * @param introspectedColumn
     *            the column related to the select key statement
     * @param generatedKey
     *            the generated key for the current table
     * @return the selectKey element
     */
    public static XmlElement getSelectKey(IntrospectedColumn introspectedColumn, GeneratedKey generatedKey) {
        String identityColumnType = introspectedColumn
                .getFullyQualifiedJavaType().getFullyQualifiedName();

        XmlElement answer = new XmlElement("selectKey"); 
        answer.addAttribute(new Attribute("resultType", identityColumnType)); 
        answer.addAttribute(new Attribute(
                "keyProperty", introspectedColumn.getJavaProperty())); 
        answer.addAttribute(new Attribute("order", 
                generatedKey.getMyBatis3Order()));

        answer.addElement(new TextElement(generatedKey
                .getRuntimeSqlStatement()));

        return answer;
    }

    public static XmlElement getBaseColumnListElement(IntrospectedTable introspectedTable) {
        XmlElement answer = new XmlElement("include"); 
        answer.addAttribute(new Attribute("refid", 
                introspectedTable.getBaseColumnListId()));
        return answer;
    }

    public static XmlElement getBlobColumnListElement(IntrospectedTable introspectedTable) {
        XmlElement answer = new XmlElement("include"); 
        answer.addAttribute(new Attribute("refid", 
                introspectedTable.getBlobColumnListId()));
        return answer;
    }

    public static XmlElement getExampleIncludeElement(IntrospectedTable introspectedTable) {
        XmlElement ifElement = new XmlElement("if"); 
        ifElement.addAttribute(new Attribute("test", "_parameter != null"));  

        XmlElement includeElement = new XmlElement("include"); 
        includeElement.addAttribute(new Attribute("refid", 
                introspectedTable.getExampleWhereClauseId()));
        ifElement.addElement(includeElement);

        return ifElement;
    }

    public static XmlElement getUpdateByExampleIncludeElement(IntrospectedTable introspectedTable) {
        XmlElement ifElement = new XmlElement("if"); 
        ifElement.addAttribute(new Attribute("test", "_parameter != null"));  

        XmlElement includeElement = new XmlElement("include"); 
        includeElement.addAttribute(new Attribute("refid", 
                introspectedTable.getMyBatis3UpdateByExampleWhereClauseId()));
        ifElement.addElement(includeElement);

        return ifElement;
    }
}
