package com.lliyuu520.root.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author liliangyu
 * @date 2019-08-02
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final static Predicate<String> regex = PathSelectors.regex("^(?!auth).*$")::apply;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(regex::test)
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("后台开发swagger接口文档")
                .description("lliyuu520@gmail.com")
                .build();


    }

    private List<ApiKey> securitySchemes() {
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");

        List<ApiKey> arrayList = new ArrayList<>();
        arrayList.add(apiKey);
        return arrayList;
    }


    private List<SecurityContext> securityContexts() {
        SecurityContext build = SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(regex::test)
                .build();
        List<SecurityContext> arrayList = new ArrayList<>();
        arrayList.add(build);
        return arrayList;

    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        SecurityReference authorization = new SecurityReference("Authorization", authorizationScopes);
        List<SecurityReference> arrayList = new ArrayList<>();
        arrayList.add(authorization);
        return arrayList;
    }

}
