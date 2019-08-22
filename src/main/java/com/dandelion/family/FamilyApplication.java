package com.dandelion.family;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.dandelion.dao")
@ComponentScan("com.dandelion")
public class FamilyApplication {
	public static void main(String[] args) {
		SpringApplication.run(FamilyApplication.class, args);
	}

}
