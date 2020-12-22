package com.spring.cg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
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
	public Docket InterviewModule() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.spring.cg"))
				.paths(PathSelectors.regex("/cgits.*"))
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		ApiInfo apiInfo = new ApiInfo("Interview Tracking System API Documentation ",
				"This is Interview Tracking System Info",
				"1.0",
				"public terms of service",
				new Contact("Neeti Mishra","http:neeti.com", "neeti.mishra2011@gmail.com"),
				"GPL",
				"http://gpl.info");
		return apiInfo;
		
	}

}
