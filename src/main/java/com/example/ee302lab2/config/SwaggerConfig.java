package com.example.ee302lab2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }
    Contact contact = new Contact("HuaQi", "", "");

    private ApiInfo apiInfo() {
        return new ApiInfo("west2_6 Api文档", "Api 文档", "1.0", "urn:tos", contact, "", "", new ArrayList());
    }
}
