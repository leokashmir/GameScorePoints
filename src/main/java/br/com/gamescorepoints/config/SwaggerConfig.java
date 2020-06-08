package br.com.gamescorepoints.config;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;
import com.google.common.base.Predicate;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;






@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket api(){
         return new Docket(DocumentationType.SWAGGER_2)
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("br.com.gamescorepoints.controller"))
                 .paths(postPaths())
                 .build()
                 .apiInfo(apiInfo());
    }
    private Predicate<String> postPaths() {
        return or(regex("/.*"));

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "SERVICO GAME SCORE",
                "API GAME SCORE",
                "VERSION 1.0",
                "Terms of service",
                new Contact("Leonardo Barros", "", "leonardobarrosbhzs@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}
