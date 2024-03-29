package com.config;

import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configurable
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket ipa(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*")).build();

    }

    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder().title("我的接口文档")
                .contact(new Contact("wangshiheng","","244313089@qq.com"))
                .description("这是我使用swaggerUi生成的接口文档")
                .version("1.0.0.0")
                .build();
    }

}
