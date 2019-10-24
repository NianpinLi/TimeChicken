package com.dandelion.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * GeneratorUtil
 * @date      2019/8/13 9:32
 * @author    puyiliang
 *  mybatis Generator 自动生成文件
 */
public class GeneratorUtil {
    public static void main(String[] args) throws Exception{
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        String filepath=System.getProperty("user.dir")+"/src/main/resources/generatorConfig.xml";
        File configFile = new File(filepath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
