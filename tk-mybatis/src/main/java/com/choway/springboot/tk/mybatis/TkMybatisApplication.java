package com.choway.springboot.tk.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = "com.choway.springboot.tk.mybatis.dao")
public class TkMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkMybatisApplication.class, args);
	}

}

