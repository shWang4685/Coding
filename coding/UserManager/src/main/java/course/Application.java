package course;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PreDestroy;
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
@MapperScan("course.mapper")
public class Application {

   // private  static ConfigurableApplicationContext context;

    public static void main(String[] args) {
      SpringApplication.run(Application.class,args);
    }

//    @PreDestroy
//    public void close(){
//        Application.context.close();
//    }

}
