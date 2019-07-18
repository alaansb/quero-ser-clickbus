package com.clickbus.place.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
 
	@Bean
	public Docket apiDetails() {
 
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
 
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.clickbus.place.controller"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.apiInformations().build());
 
		return docket;
	}
 
	private ApiInfoBuilder apiInformations() {
 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("Api-Place");
		apiInfoBuilder.description("Api CRUD place");
		apiInfoBuilder.version("1.0");

		return apiInfoBuilder;
 
	}

}
