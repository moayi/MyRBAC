package com.sx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.sx.controller"})
@EnableWebMvc
public class SwaggerConfig{
	@Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Blog前台API接口",//大标题 title
                "Swagger测试demo",//小标题
                "0.0.1",//版本
                "http://localhost/mq/swagger/index.html",//termsOfServiceUrl
                "moayi",//作者
                "Blog",//链接显示文字
                "http://localhost/mq/"//网站链接
        );
    }


}