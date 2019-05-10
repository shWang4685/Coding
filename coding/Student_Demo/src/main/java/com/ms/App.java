package com.ms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ms.mapper")	//扫描mybatis的mapper接口
public class App {

	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}
}
