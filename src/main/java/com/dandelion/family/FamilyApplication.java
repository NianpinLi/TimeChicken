package com.dandelion.family;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: FamilyApplication
 * @date:      2019/8/14 15:34
 * @author:    puyiliang
 * @description: 项目启动类
 */
@SpringBootApplication
@MapperScan("com.dandelion.dao")
@ComponentScan("com.dandelion")
public class FamilyApplication {
	public static void main(String[] args) {
		SpringApplication.run(FamilyApplication.class, args);
	}

}
