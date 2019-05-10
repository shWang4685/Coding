package com.sqxinxibu.neikanhoutai;

import com.sqxinxibu.neikanhoutai.util.PassportInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@MapperScan("com.sqxinxibu.neikanhoutai.dao")
public class NeikanhoutaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeikanhoutaiApplication.class, args);
	}

}
